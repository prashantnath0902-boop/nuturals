import type { Metadata } from 'next'
import { brand } from '@/lib/brand'
import { CtaBand, PageHero, SectionHeading } from '@/components/ui-blocks'

export const metadata: Metadata = {
  title: 'About',
  description: 'NUTURALS is a premium sourcing house for nuts, dried fruits and natural foods, based in Bengaluru, India.',
}

const values = [
  { title: 'Provenance', description: 'We buy from origins we know, with direct relationships and verifiable practices.' },
  { title: 'Precision', description: 'Grading, sizing and packaging specified to each buyer — and delivered to that spec.' },
  { title: 'Partnership', description: 'Long-term supply programs over one-off trades, built on transparency and reliability.' },
]

export default function AboutPage() {
  return (
    <>
      <PageHero
        eyebrow={`About ${brand.name} • ${brand.established}`}
        title={brand.tagline}
        description={brand.philosophy}
        image="/images/hero.png"
        imageAlt="Premium nuts and dried fruits"
      />

      <section className="mx-auto max-w-3xl px-5 py-20 text-lg leading-relaxed lg:px-8">
        <p className="font-serif text-3xl leading-snug text-balance">
          {brand.name} was founded to bring the discipline of fine-food sourcing to commercial supply.
        </p>
        <p className="mt-6 text-muted-foreground">
          From our trade and sourcing office in Bengaluru, we work with growers and processors across India, the Middle East, the
          Americas, Australia and the Mediterranean to supply wholesalers, distributors, retailers, hospitality groups and
          manufacturers. Our focus is simple: carefully sourced product, rigorous quality control and supply you can plan around.
        </p>
      </section>

      <section className="bg-muted/60">
        <div className="mx-auto max-w-7xl px-5 py-20 lg:px-8">
          <SectionHeading eyebrow="Our Values" title="What guides every consignment" />
          <ul className="mt-10 grid gap-6 md:grid-cols-3">
            {values.map((value) => (
              <li key={value.title} className="flex flex-col gap-3 rounded-2xl bg-background p-8">
                <h3 className="font-serif text-3xl font-medium">{value.title}</h3>
                <p className="leading-relaxed text-muted-foreground">{value.description}</p>
              </li>
            ))}
          </ul>
        </div>
      </section>

      <CtaBand />
    </>
  )
}
