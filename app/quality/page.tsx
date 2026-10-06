import type { Metadata } from 'next'
import { qualitySteps } from '@/lib/brand'
import { CtaBand, PageHero, SectionHeading } from '@/components/ui-blocks'

export const metadata: Metadata = {
  title: 'Quality',
  description: 'Our five-step quality process: source, inspect, select, pack and deliver.',
}

const parameters = [
  { label: 'Moisture', value: 'Measured per lot against product specification' },
  { label: 'Sizing', value: 'Calibrated grading by count, length or diameter' },
  { label: 'Microbiology', value: 'Third-party lab testing available per batch' },
  { label: 'Sensory', value: 'Colour, aroma, texture and flavour review' },
  { label: 'Foreign matter', value: 'Optical sorting and manual inspection' },
  { label: 'Traceability', value: 'Lot coding from origin to dispatch' },
]

export default function QualityPage() {
  return (
    <>
      <PageHero
        eyebrow="Quality"
        title="Consistency is our signature."
        description="Every lot moves through a defined five-step process so the product you approve at sampling is the product you receive at scale."
        image="/images/quality.png"
        imageAlt="Quality inspection of premium nuts"
      />

      <section className="mx-auto max-w-7xl px-5 py-20 lg:px-8">
        <SectionHeading eyebrow="Our Process" title="Five steps, no shortcuts" />
        <ol className="mt-10 grid gap-6 md:grid-cols-5">
          {qualitySteps.map((step) => (
            <li key={step.number} className="flex flex-col gap-3 rounded-2xl border border-border bg-card p-6">
              <span className="font-serif text-4xl text-accent">{step.number}</span>
              <h3 className="font-serif text-2xl font-medium">{step.title}</h3>
              <p className="text-sm leading-relaxed text-muted-foreground">{step.description}</p>
            </li>
          ))}
        </ol>
      </section>

      <section className="bg-muted/60">
        <div className="mx-auto max-w-4xl px-5 py-20 lg:px-8">
          <SectionHeading eyebrow="What We Check" title="Quality parameters" description="Detailed Technical Data Sheets are available on request for each product batch." />
          <dl className="mt-10 flex flex-col">
            {parameters.map((item) => (
              <div key={item.label} className="flex flex-col gap-1 border-b border-border py-4 sm:flex-row sm:gap-8">
                <dt className="w-40 shrink-0 font-medium">{item.label}</dt>
                <dd className="text-muted-foreground">{item.value}</dd>
              </div>
            ))}
          </dl>
        </div>
      </section>

      <CtaBand title="Request a specification sheet" />
    </>
  )
}
