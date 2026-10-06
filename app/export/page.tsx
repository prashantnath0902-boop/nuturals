import type { Metadata } from 'next'
import { FileCheck, Globe2, Ship, ShieldCheck } from 'lucide-react'
import { sourcingRegions } from '@/lib/brand'
import { CtaBand, PageHero, SectionHeading } from '@/components/ui-blocks'

export const metadata: Metadata = {
  title: 'Export & Global Sourcing',
  description: 'International sourcing and export supply with documentation, phytosanitary compliance and FOB / CIF logistics.',
}

const capabilities = [
  { icon: FileCheck, title: 'Export documentation', description: 'Commercial invoice, packing list, certificate of origin and bill of lading prepared for every consignment.' },
  { icon: ShieldCheck, title: 'Phytosanitary compliance', description: 'Lab analysis, fumigation and phytosanitary certificates aligned to destination market requirements.' },
  { icon: Ship, title: 'FOB / CIF logistics', description: '20ft and 40ft container planning, port-to-port or door delivery with trackable fulfilment.' },
  { icon: Globe2, title: 'Multi-origin sourcing', description: 'Consolidated supply from six origin regions to simplify procurement for importers.' },
]

export default function ExportPage() {
  return (
    <>
      <PageHero
        eyebrow="Export"
        title="Sourced for the world. Delivered with care."
        description="We partner with importers and distributors across markets, managing grading, documentation and logistics from origin to port."
        image="/images/export.png"
        imageAlt="Shipping containers at an export port"
      />

      <section className="mx-auto max-w-7xl px-5 py-20 lg:px-8">
        <SectionHeading eyebrow="Capabilities" title="Export-ready from day one" />
        <ul className="mt-10 grid gap-6 sm:grid-cols-2 lg:grid-cols-4">
          {capabilities.map(({ icon: Icon, title, description }) => (
            <li key={title} className="flex flex-col gap-3 rounded-2xl border border-border bg-card p-6">
              <Icon className="size-6 text-accent" aria-hidden />
              <h3 className="font-serif text-xl font-medium">{title}</h3>
              <p className="text-sm leading-relaxed text-muted-foreground">{description}</p>
            </li>
          ))}
        </ul>
      </section>

      <section className="bg-muted/60">
        <div className="mx-auto max-w-7xl px-5 py-20 lg:px-8">
          <SectionHeading eyebrow="Sourcing Regions" title="Origins we know intimately" />
          <ul className="mt-10 grid gap-px overflow-hidden rounded-2xl border border-border bg-border md:grid-cols-2 lg:grid-cols-3">
            {sourcingRegions.map((region) => (
              <li key={region.country} className="flex flex-col gap-2 bg-background p-6">
                <h3 className="font-serif text-2xl font-medium">{region.country}</h3>
                <p className="text-sm font-medium text-accent">{region.products}</p>
                <p className="text-sm leading-relaxed text-muted-foreground">{region.description}</p>
              </li>
            ))}
          </ul>
        </div>
      </section>

      <CtaBand title="Planning an import program?" />
    </>
  )
}
