import type { Metadata } from 'next'
import Image from 'next/image'
import Link from 'next/link'
import { brand } from '@/lib/brand'
import { chapters, products } from '@/lib/products'
import { CtaBand, Eyebrow } from '@/components/ui-blocks'

export const metadata: Metadata = {
  title: 'Sovereign Reserve Catalogue',
  description: 'The NUTURALS Ultra-Premium Reserve catalogue: royal nuts, rare seeds, artisan flavored nuts and haute confectionery.',
}

export default function CataloguePage() {
  return (
    <>
      <section className="bg-primary text-primary-foreground">
        <div className="mx-auto flex max-w-4xl flex-col items-center gap-5 px-5 py-20 text-center lg:px-8">
          <Eyebrow>{brand.collectionTitle}</Eyebrow>
          <h1 className="font-serif text-5xl font-medium text-balance md:text-7xl">The Sovereign Reserve</h1>
          <p className="max-w-2xl text-lg leading-relaxed text-primary-foreground/80 text-pretty">{brand.philosophy}</p>
        </div>
      </section>

      {chapters.map((chapter) => {
        const items = products.filter((product) => product.chapter === chapter)
        if (items.length === 0) return null
        const [label, title] = chapter.split(': ')
        return (
          <section key={chapter} className="mx-auto max-w-5xl px-5 py-16 lg:px-8">
            <header className="mb-10 flex flex-col items-center gap-2 text-center">
              <p className="text-xs uppercase tracking-[0.3em] text-accent">{label}</p>
              <h2 className="font-serif text-4xl font-medium">{title}</h2>
            </header>
            <ul className="flex flex-col">
              {items.map((product) => (
                <li key={product.id} className="border-t border-border last:border-b">
                  <Link href={`/products/${product.id}`} className="group flex items-center gap-5 py-5">
                    <div className="relative size-20 shrink-0 overflow-hidden rounded-full bg-muted">
                      <Image src={product.image} alt="" fill sizes="80px" className="object-cover" />
                    </div>
                    <div className="min-w-0 flex-1">
                      <p className="font-serif text-2xl font-medium group-hover:text-accent">{product.name}</p>
                      <p className="text-sm text-muted-foreground">{product.notes}</p>
                    </div>
                    <div className="hidden shrink-0 text-right sm:block">
                      <p className="font-serif text-xl">{product.sovereignPrice}</p>
                      <p className="text-xs uppercase tracking-[0.15em] text-muted-foreground">Sovereign Edition</p>
                    </div>
                  </Link>
                </li>
              ))}
            </ul>
          </section>
        )
      })}

      <CtaBand
        title="Private allocations by appointment"
        description={`Reserve pieces are allocated per season. Contact our concierge at ${brand.conciergeEmail} or request a quote to secure your allocation.`}
      />
    </>
  )
}
