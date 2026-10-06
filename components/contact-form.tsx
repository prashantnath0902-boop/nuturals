'use client'

import { useActionState } from 'react'
import { CheckCircle2 } from 'lucide-react'
import { submitContact } from '@/app/actions/contact'
import { initialFormState } from '@/lib/form-utils'
import { SubmitButton, TextAreaField, TextField } from '@/components/form-field'

export function ContactForm() {
  const [state, formAction, pending] = useActionState(submitContact, initialFormState)

  if (state.status === 'success') {
    return (
      <div role="status" className="flex flex-col items-start gap-3 rounded-2xl border border-border bg-card p-8">
        <CheckCircle2 className="size-8 text-accent" aria-hidden />
        <h2 className="font-serif text-3xl font-medium">Message sent</h2>
        <p className="leading-relaxed text-muted-foreground">{state.message}</p>
      </div>
    )
  }

  const errors = state.errors ?? {}

  return (
    <form action={formAction} noValidate className="grid gap-5 rounded-2xl border border-border bg-card p-6 sm:grid-cols-2 md:p-8">
      <TextField name="name" label="Full name" required autoComplete="name" error={errors.name} />
      <TextField name="email" label="Email" type="email" required autoComplete="email" error={errors.email} />
      <TextField name="company" label="Company" autoComplete="organization" />
      <TextField name="phone" label="Phone" type="tel" autoComplete="tel" />
      <TextField name="subject" label="Subject" required error={errors.subject} className="sm:col-span-2" />
      <TextAreaField name="message" label="Message" required error={errors.message} className="sm:col-span-2" />
      <div className="flex flex-col gap-3 sm:col-span-2 sm:flex-row sm:items-center sm:justify-between">
        <p aria-live="polite" className="text-sm text-destructive">
          {state.status === 'error' ? state.message : ''}
        </p>
        <SubmitButton pending={pending}>Send Message</SubmitButton>
      </div>
    </form>
  )
}
