import Link from 'next/link'
import type { QuoteRequest } from '@/lib/db/schema'

export function QuoteCard({ quote }: { quote: QuoteRequest }) {
  const submitted = new Date(quote.createdAt).toLocaleDateString('en-GB', {
    day: 'numeric',
    month: 'short',
    year: 'numeric',
  })

  return (
    <article className="flex flex-col gap-4 rounded-2xl border border-border bg-card p-6">
      <div className="flex flex-wrap items-start justify-between gap-3">
        <div>
          <p className="font-mono text-sm font-semibold">{quote.reference}</p>
          <h3 className="mt-1 font-serif text-2xl font-medium">
            {quote.productId && quote.productName ? (
              <Link href={`/products/${quote.productId}`} className="hover:text-accent">
                {quote.productName}
              </Link>
            ) : (
              'General quote request'
            )}
          </h3>
        </div>
        <span className="rounded-full bg-muted px-3 py-1 text-xs font-medium uppercase tracking-[0.15em] text-accent">
          {quote.status}
        </span>
      </div>
      <dl className="grid grid-cols-2 gap-4 text-sm md:grid-cols-4">
        <div>
          <dt className="text-xs text-muted-foreground">Submitted</dt>
          <dd className="font-medium">{submitted}</dd>
        </div>
        <div>
          <dt className="text-xs text-muted-foreground">Quantity</dt>
          <dd className="font-medium">{quote.quantity}</dd>
        </div>
        <div>
          <dt className="text-xs text-muted-foreground">Company</dt>
          <dd className="font-medium">{quote.company}</dd>
        </div>
        <div>
          <dt className="text-xs text-muted-foreground">Destination</dt>
          <dd className="font-medium">{quote.country}</dd>
        </div>
      </dl>
      {quote.message && <p className="border-t border-border pt-4 text-sm leading-relaxed text-muted-foreground">{quote.message}</p>}
    </article>
  )
}
