import type { Metadata } from 'next'
import { getMyQuotes } from '@/app/actions/quotes'
import { QuoteCard } from '@/components/quote-card'
import { QuoteLookup } from '@/components/quote-lookup'
import { ButtonLink, Eyebrow } from '@/components/ui-blocks'

export const metadata: Metadata = {
  title: 'My Quotes',
  description: 'Track the status of your NUTURALS quote requests.',
}

export default async function MyQuotesPage() {
  const quotes = await getMyQuotes()

  return (
    <div className="mx-auto flex max-w-5xl flex-col gap-14 px-5 py-16 lg:px-8">
      <header className="flex flex-col gap-4">
        <Eyebrow>My Quotes</Eyebrow>
        <h1 className="font-serif text-5xl font-medium">Track your requests</h1>
        <p className="max-w-2xl text-lg leading-relaxed text-muted-foreground">
          Requests submitted from this browser appear below. Submitted from another device? Look it up with your reference
          and email.
        </p>
      </header>

      <section aria-labelledby="recent-heading" className="flex flex-col gap-5">
        <h2 id="recent-heading" className="font-serif text-3xl font-medium">
          Recent requests
        </h2>
        {quotes.length === 0 ? (
          <div className="flex flex-col items-start gap-4 rounded-2xl border border-dashed border-border p-8">
            <p className="text-muted-foreground">You have not submitted any quote requests from this browser yet.</p>
            <ButtonLink href="/quote">Request a Quote</ButtonLink>
          </div>
        ) : (
          <ul className="flex flex-col gap-4">
            {quotes.map((quote) => (
              <li key={quote.id}>
                <QuoteCard quote={quote} />
              </li>
            ))}
          </ul>
        )}
      </section>

      <section aria-labelledby="lookup-heading" className="flex flex-col gap-5">
        <h2 id="lookup-heading" className="font-serif text-3xl font-medium">
          Look up a quote
        </h2>
        <QuoteLookup />
      </section>
    </div>
  )
}
