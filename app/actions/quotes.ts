'use server'

import { randomBytes, randomUUID } from 'node:crypto'
import { and, desc, eq } from 'drizzle-orm'
import { cookies } from 'next/headers'
import { revalidatePath } from 'next/cache'
import { db } from '@/lib/db'
import { quoteRequests, type QuoteRequest } from '@/lib/db/schema'
import { businessTypes } from '@/lib/brand'
import { getProduct } from '@/lib/products'
import { isValidEmail, readField, type FormState } from '@/lib/form-utils'

const VISITOR_COOKIE = 'nuturals_visitor'

async function getOrCreateVisitorId() {
  const store = await cookies()
  const existing = store.get(VISITOR_COOKIE)?.value
  if (existing) return existing
  const visitorId = randomUUID()
  store.set(VISITOR_COOKIE, visitorId, {
    httpOnly: true,
    secure: true,
    sameSite: 'none',
    path: '/',
    maxAge: 60 * 60 * 24 * 365,
  })
  return visitorId
}

function createReference() {
  return `NUT-${randomBytes(4).toString('hex').toUpperCase()}`
}

export async function submitQuote(_prev: FormState, formData: FormData): Promise<FormState> {
  const name = readField(formData, 'name', 120)
  const company = readField(formData, 'company', 160)
  const email = readField(formData, 'email', 200).toLowerCase()
  const phone = readField(formData, 'phone', 40)
  const country = readField(formData, 'country', 80)
  const businessType = readField(formData, 'businessType', 40)
  const productId = readField(formData, 'productId', 80)
  const quantity = readField(formData, 'quantity', 120)
  const packaging = readField(formData, 'packaging', 160)
  const message = readField(formData, 'message', 2000)

  const errors: Record<string, string> = {}
  if (!name) errors.name = 'Please enter your name.'
  if (!company) errors.company = 'Please enter your company name.'
  if (!isValidEmail(email)) errors.email = 'Please enter a valid email address.'
  if (!country) errors.country = 'Please enter your country.'
  if (!(businessTypes as readonly string[]).includes(businessType)) errors.businessType = 'Please select a business type.'
  if (!quantity) errors.quantity = 'Please share an estimated quantity.'

  const product = productId ? getProduct(productId) : undefined
  if (productId && !product) errors.productId = 'Please choose a product from the list.'

  if (Object.keys(errors).length > 0) {
    return { status: 'error', message: 'Please review the highlighted fields.', errors }
  }

  try {
    const visitorId = await getOrCreateVisitorId()
    const reference = createReference()
    await db.insert(quoteRequests).values({
      reference,
      visitorId,
      name,
      company,
      email,
      phone: phone || null,
      country,
      businessType,
      productId: product?.id ?? null,
      productName: product?.name ?? null,
      quantity,
      packaging: packaging || null,
      message: message || null,
    })
    revalidatePath('/my-quotes')
    return {
      status: 'success',
      reference,
      message: 'Your quote request has been received. Our trade desk will respond within one business day.',
    }
  } catch (error) {
    console.error('Failed to save quote request', error)
    return { status: 'error', message: 'We could not submit your request right now. Please try again or reach us on WhatsApp.' }
  }
}

export async function getMyQuotes(): Promise<QuoteRequest[]> {
  const store = await cookies()
  const visitorId = store.get(VISITOR_COOKIE)?.value
  if (!visitorId) return []
  return db
    .select()
    .from(quoteRequests)
    .where(eq(quoteRequests.visitorId, visitorId))
    .orderBy(desc(quoteRequests.createdAt))
    .limit(50)
}

export type LookupState = FormState & { quote?: QuoteRequest }

export async function lookupQuote(_prev: LookupState, formData: FormData): Promise<LookupState> {
  const reference = readField(formData, 'reference', 20).toUpperCase()
  const email = readField(formData, 'email', 200).toLowerCase()

  if (!/^NUT-[0-9A-F]{8}$/.test(reference) || !isValidEmail(email)) {
    return { status: 'error', message: 'Enter a valid reference (e.g. NUT-1A2B3C4D) and the email used on the request.' }
  }

  const [quote] = await db
    .select()
    .from(quoteRequests)
    .where(and(eq(quoteRequests.reference, reference), eq(quoteRequests.email, email)))
    .limit(1)

  if (!quote) {
    return { status: 'error', message: 'No quote matched that reference and email.' }
  }
  return { status: 'success', quote }
}
