import type { Metadata } from 'next'
import { b2bAudiences, faqItems } from '@/lib/brand'
import { CtaBand, PageHero, SectionHeading } from '@/components/ui-blocks'

export const metadata: Metadata = {
  title: 'B2B Supply',
  description: 'Wholesale and commercial supply programs for wholesalers, distributors, retailers, HORECA, manufacturers and export buyers.',
}

export default function B2BPage() {
  return (
    <>
      <PageHero
        eyebrow="B2B Supply"
        title="Pure by Nature. Trusted by Business."
        description="Volume supply programs with calibrated grading, consistent replenishment and packaging matched to how your business sells."
        image="/images/packaging.png"
        imageAlt="Bulk and retail packaging of premium nuts"
      />

      <section className="mx-auto max-w-7xl px-5 py-20 lg:px-8">
        <SectionHeading eyebrow="Buyer Segments" title="Built for every link in the supply chain" />
        <ul className="mt-10 grid gap-6 sm:grid-cols-2 lg:grid-cols-3">
          {b2bAudiences.map((audience) => (
            <li key={audience.title} className="flex flex-col gap-3 rounded-2xl border border-border bg-card p-6">
              <p className="text-xs uppercase tracking-[0.2em] text-accent">{audience.tagline}</p>
              <h3 className="font-serif text-2xl font-medium">{audience.title}</h3>
              <p className="text-sm leading-relaxed text-muted-foreground">{audience.description}</p>
            </li>
          ))}
        </ul>
      </section>

      <section id="faq" className="border-t border-border">
        <div className="mx-auto max-w-3xl px-5 py-20 lg:px-8">
          <SectionHeading eyebrow="FAQ" title="Trade questions, answered" align="center" />
          <div className="mt-10 flex flex-col">
            {faqItems.map((item) => (
              <details key={item.question} className="group border-b border-border py-5">
                <summary className="flex cursor-pointer list-none items-center justify-between gap-4 font-serif text-xl font-medium">
                  {item.question}
                  <span aria-hidden className="text-accent transition-transform group-open:rotate-45">
                    +
                  </span>
                </summary>
                <p className="mt-3 leading-relaxed text-muted-foreground">{item.answer}</p>
              </details>
            ))}
          </div>
        </div>
      </section>

      <CtaBand />
    </>
  )
}
