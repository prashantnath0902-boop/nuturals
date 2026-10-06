'use server'

import { db } from '@/lib/db'
import { contactInquiries } from '@/lib/db/schema'
import { isValidEmail, readField, type FormState } from '@/lib/form-utils'

export async function submitContact(_prev: FormState, formData: FormData): Promise<FormState> {
  const name = readField(formData, 'name', 120)
  const email = readField(formData, 'email', 200).toLowerCase()
  const company = readField(formData, 'company', 160)
  const phone = readField(formData, 'phone', 40)
  const subject = readField(formData, 'subject', 160)
  const message = readField(formData, 'message', 3000)

  const errors: Record<string, string> = {}
  if (!name) errors.name = 'Please enter your name.'
  if (!isValidEmail(email)) errors.email = 'Please enter a valid email address.'
  if (!subject) errors.subject = 'Please add a subject.'
  if (message.length < 10) errors.message = 'Please write at least a short message.'

  if (Object.keys(errors).length > 0) {
    return { status: 'error', message: 'Please review the highlighted fields.', errors }
  }

  try {
    await db.insert(contactInquiries).values({
      name,
      email,
      company: company || null,
      phone: phone || null,
      subject,
      message,
    })
    return { status: 'success', message: 'Thank you. Our team will be in touch shortly.' }
  } catch (error) {
    console.error('Failed to save contact inquiry', error)
    return { status: 'error', message: 'We could not send your message right now. Please try again or email us directly.' }
  }
}
