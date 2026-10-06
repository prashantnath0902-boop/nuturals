'use client'

import { useActionState } from 'react'
import { lookupQuote, type LookupState } from '@/app/actions/quotes'
import { SubmitButton, TextField } from '@/components/form-field'
import { QuoteCard } from '@/components/quote-card'

const initialState: LookupState = { status: 'idle' }

export function QuoteLookup() {
  const [state, formAction, pending] = useActionState(lookupQuote, initialState)

  return (
    <div className="flex flex-col gap-6">
      <form action={formAction} noValidate className="grid gap-4 rounded-2xl border border-border bg-card p-6 sm:grid-cols-[1fr_1fr_auto] sm:items-end">
        <TextField name="reference" label="Reference" placeholder="NUT-1A2B3C4D" required />
        <TextField name="email" label="Email used on request" type="email" required autoComplete="email" />
        <SubmitButton pending={pending}>Find Quote</SubmitButton>
      </form>
      <div aria-live="polite">
        {state.status === 'error' && <p className="text-sm text-destructive">{state.message}</p>}
        {state.quote && <QuoteCard quote={state.quote} />}
      </div>
    </div>
  )
}
