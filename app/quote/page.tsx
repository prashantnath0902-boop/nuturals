import type { Metadata } from 'next'
import { brand, businessTypes, whatsappLink } from '@/lib/brand'
import { getProduct, products } from '@/lib/products'
import { QuoteForm } from '@/components/quote-form'
import { Eyebrow } from '@/components/ui-blocks'

export const metadata: Metadata = {
  title: 'Request a Quote',
  description: 'Request wholesale pricing, specifications and availability from the NUTURALS trade desk.',
}

export default async function QuotePage({ searchParams }: { searchParams: Promise<{ product?: string }> }) {
  const { product } = await searchParams
  const defaultProductId = product && getProduct(product) ? product : undefined

  return (
    <section className="mx-auto grid max-w-7xl gap-12 px-5 py-16 lg:grid-cols-[1fr_1.6fr] lg:px-8">
      <div className="flex flex-col gap-5">
        <Eyebrow>Request a Quote</Eyebrow>
        <h1 className="font-serif text-5xl font-medium leading-tight text-balance">Tell us what you need.</h1>
        <p className="text-lg leading-relaxed text-muted-foreground">
          Share your product, volume and destination. We will respond with specifications, availability and indicative
          commercial terms.
        </p>
        <div className="mt-4 flex flex-col gap-2 border-t border-border pt-6 text-sm">
          <p className="font-medium">Prefer to talk directly?</p>
          <a href={whatsappLink()} target="_blank" rel="noopener noreferrer" className="text-accent hover:underline">
            {`WhatsApp ${brand.whatsappDisplay}`}
          </a>
          <a href={`mailto:${brand.email}`} className="text-accent hover:underline">
            {brand.email}
          </a>
        </div>
      </div>
      <QuoteForm
        defaultProductId={defaultProductId}
        productOptions={products.map((item) => ({ value: item.id, label: item.name }))}
        businessTypeOptions={businessTypes.map((type) => ({ value: type, label: type }))}
      />
    </section>
  )
}
