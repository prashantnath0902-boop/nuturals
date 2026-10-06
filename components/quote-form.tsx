'use client'

import Link from 'next/link'
import { useActionState } from 'react'
import { CheckCircle2 } from 'lucide-react'
import { submitQuote } from '@/app/actions/quotes'
import { initialFormState } from '@/lib/form-utils'
import { SelectField, SubmitButton, TextAreaField, TextField } from '@/components/form-field'

type Props = {
  productOptions: { value: string; label: string }[]
  businessTypeOptions: { value: string; label: string }[]
  defaultProductId?: string
}

export function QuoteForm({ productOptions, businessTypeOptions, defaultProductId }: Props) {
  const [state, formAction, pending] = useActionState(submitQuote, initialFormState)

  if (state.status === 'success') {
    return (
      <div role="status" className="flex flex-col items-start gap-4 rounded-2xl border border-border bg-card p-8">
        <CheckCircle2 className="size-8 text-accent" aria-hidden />
        <h2 className="font-serif text-3xl font-medium">Request received</h2>
        <p className="leading-relaxed text-muted-foreground">{state.message}</p>
        <p className="rounded-lg bg-muted px-4 py-3 text-sm">
          Your reference: <span className="font-mono font-semibold">{state.reference}</span>
        </p>
        <Link href="/my-quotes" className="text-sm font-medium text-accent underline underline-offset-4">
          Track it in My Quotes
        </Link>
      </div>
    )
  }

  const errors = state.errors ?? {}

  return (
    <form action={formAction} noValidate className="grid gap-5 rounded-2xl border border-border bg-card p-6 sm:grid-cols-2 md:p-8">
      <TextField name="name" label="Full name" required autoComplete="name" error={errors.name} />
      <TextField name="company" label="Company" required autoComplete="organization" error={errors.company} />
      <TextField name="email" label="Business email" type="email" required autoComplete="email" error={errors.email} />
      <TextField name="phone" label="Phone / WhatsApp" type="tel" autoComplete="tel" error={errors.phone} />
      <TextField name="country" label="Country" required autoComplete="country-name" error={errors.country} />
      <SelectField
        name="businessType"
        label="Business type"
        required
        options={businessTypeOptions}
        placeholder="Select business type"
        error={errors.businessType}
      />
      <SelectField
        name="productId"
        label="Product"
        options={productOptions}
        defaultValue={defaultProductId}
        placeholder="Multiple / not sure yet"
        error={errors.productId}
        className="sm:col-span-2"
      />
      <TextField name="quantity" label="Estimated quantity" required placeholder="e.g. 2 pallets, 1 x 20ft container" error={errors.quantity} />
      <TextField name="packaging" label="Packaging preference" placeholder="e.g. 10kg vacuum bags, 250g retail tins" />
      <TextAreaField
        name="message"
        label="Additional details"
        placeholder="Destination port, delivery timeline, specifications, private-label needs…"
        className="sm:col-span-2"
      />
      <div className="flex flex-col gap-3 sm:col-span-2 sm:flex-row sm:items-center sm:justify-between">
        <p aria-live="polite" className={`text-sm ${state.status === 'error' ? 'text-destructive' : 'text-muted-foreground'}`}>
          {state.status === 'error' ? state.message : 'We respond within one business day.'}
        </p>
        <SubmitButton pending={pending}>Submit Quote Request</SubmitButton>
      </div>
    </form>
  )
}
