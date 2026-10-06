import type { Metadata } from 'next'
import { CtaBand, PageHero, SectionHeading } from '@/components/ui-blocks'

export const metadata: Metadata = {
  title: 'Private Label',
  description: 'Custom private-label packaging programs for retail and distribution partners.',
}

const steps = [
  { title: 'Brief', description: 'Share your brand, target market, product mix and price positioning.' },
  { title: 'Specify', description: 'We recommend grades, forms and pack formats with technical data sheets.' },
  { title: 'Design & Sample', description: 'Packaging artwork alignment and pre-production samples for approval.' },
  { title: 'Produce & Ship', description: 'Batch production, quality release and scheduled replenishment.' },
]

const formats = ['Stand-up zip pouches', 'Glass jars & decanters', 'Gift tins & presentation boxes', 'Nitrogen-flushed foil bags', 'Master cartons & bulk sacks', 'Custom hampers']

export default function PrivateLabelPage() {
  return (
    <>
      <PageHero
        eyebrow="Private Label"
        title="Your brand, our provenance."
        description="We are preparing dedicated private-label programs for select retail and distribution partners. Submit your requirements to start a packaging consultation."
        image="/images/packaging.png"
        imageAlt="Custom retail packaging for nuts and dried fruits"
      />

      <section className="mx-auto max-w-7xl px-5 py-20 lg:px-8">
        <SectionHeading eyebrow="How It Works" title="A considered path from brief to shelf" />
        <ol className="mt-10 grid gap-6 sm:grid-cols-2 lg:grid-cols-4">
          {steps.map((step, index) => (
            <li key={step.title} className="flex flex-col gap-3 border-t-2 border-accent pt-5">
              <span className="font-serif text-3xl text-accent">{`0${index + 1}`}</span>
              <h3 className="font-serif text-2xl font-medium">{step.title}</h3>
              <p className="text-sm leading-relaxed text-muted-foreground">{step.description}</p>
            </li>
          ))}
        </ol>
      </section>

      <section className="bg-muted/60">
        <div className="mx-auto max-w-7xl px-5 py-20 lg:px-8">
          <SectionHeading eyebrow="Pack Formats" title="Packaging that matches your positioning" />
          <ul className="mt-10 flex flex-wrap gap-3">
            {formats.map((format) => (
              <li key={format} className="rounded-full border border-border bg-background px-5 py-2.5 text-sm">
                {format}
              </li>
            ))}
          </ul>
        </div>
      </section>

      <CtaBand title="Start a private-label consultation" description="Tell us about your brand and volumes. We will come back with recommended products, formats and timelines." />
    </>
  )
}
