import Image from 'next/image'
import Link from 'next/link'
import { b2bAudiences, brand, qualitySteps, whatsappLink } from '@/lib/brand'
import { categories, products } from '@/lib/products'
import { ProductCard } from '@/components/product-card'
import { ButtonLink, CtaBand, Eyebrow, SectionHeading } from '@/components/ui-blocks'

export default function HomePage() {
  const featured = products.filter((product) => product.featured).slice(0, 8)

  return (
    <>
      <section className="relative isolate overflow-hidden bg-primary text-primary-foreground">
        <Image
          src="/images/hero.png"
          alt=""
          fill
          priority
          sizes="100vw"
          className="-z-10 object-cover opacity-45"
        />
        <div className="absolute inset-0 -z-10 bg-gradient-to-r from-primary via-primary/80 to-primary/20" />
        <div className="mx-auto flex max-w-7xl flex-col gap-6 px-5 py-24 md:py-32 lg:px-8">
          <Eyebrow>{brand.collectionTitle}</Eyebrow>
          <h1 className="max-w-3xl font-serif text-5xl font-medium leading-[1.05] text-balance md:text-7xl">
            {brand.tagline}
          </h1>
          <p className="max-w-xl text-lg leading-relaxed text-primary-foreground/80 text-pretty">{brand.supportingLine}</p>
          <div className="flex flex-wrap gap-3 pt-2">
            <ButtonLink href="/products" variant="light">
              Explore Products
            </ButtonLink>
            <Link
              href={whatsappLink()}
              target="_blank"
              rel="noopener noreferrer"
              className="inline-flex items-center rounded-full border border-primary-foreground/40 px-6 py-3 text-sm font-medium hover:border-primary-foreground"
            >
              Talk to the Trade Desk
            </Link>
          </div>
        </div>
      </section>

      <section className="border-b border-border">
        <dl className="mx-auto grid max-w-7xl grid-cols-2 gap-6 px-5 py-10 md:grid-cols-4 lg:px-8">
          {[
            { label: 'Curated products', value: `${products.length}+` },
            { label: 'Sourcing regions', value: '6' },
            { label: 'Buyer segments', value: '6' },
            { label: 'Quote response', value: '24h' },
          ].map((stat) => (
            <div key={stat.label} className="flex flex-col gap-1">
              <dt className="text-xs uppercase tracking-[0.2em] text-muted-foreground">{stat.label}</dt>
              <dd className="font-serif text-4xl font-medium">{stat.value}</dd>
            </div>
          ))}
        </dl>
      </section>

      <section className="mx-auto max-w-7xl px-5 py-20 lg:px-8">
        <SectionHeading eyebrow="Our Collections" title="Four categories, one standard of excellence" />
        <ul className="mt-10 grid gap-4 sm:grid-cols-2 lg:grid-cols-4">
          {categories.map((category, index) => (
            <li key={category.id}>
              <Link
                href={`/products?category=${category.id}`}
                className="flex h-full flex-col gap-3 rounded-2xl border border-border bg-card p-6 transition-colors hover:border-accent"
              >
                <span className="font-serif text-lg text-accent">{`0${index + 1}`}</span>
                <span className="font-serif text-2xl font-medium">{category.name}</span>
                <span className="text-sm leading-relaxed text-muted-foreground">{category.subtitle}</span>
              </Link>
            </li>
          ))}
        </ul>
      </section>

      <section className="bg-muted/60">
        <div className="mx-auto max-w-7xl px-5 py-20 lg:px-8">
          <div className="flex flex-col items-start justify-between gap-6 md:flex-row md:items-end">
            <SectionHeading eyebrow="Featured Reserve" title="The season's most sought-after selections" />
            <ButtonLink href="/products" variant="outline">
              View all products
            </ButtonLink>
          </div>
          <div className="mt-10 grid gap-6 sm:grid-cols-2 lg:grid-cols-4">
            {featured.map((product) => (
              <ProductCard key={product.id} product={product} />
            ))}
          </div>
        </div>
      </section>

      <section className="mx-auto grid max-w-7xl items-center gap-12 px-5 py-20 lg:grid-cols-2 lg:px-8">
        <div className="relative aspect-[4/3] overflow-hidden rounded-2xl">
          <Image
            src="/images/quality.png"
            alt="Quality inspection of premium nuts"
            fill
            sizes="(min-width: 1024px) 50vw, 100vw"
            className="object-cover"
          />
        </div>
        <div className="flex flex-col gap-8">
          <SectionHeading eyebrow="Our Process" title="From origin to your warehouse" description={brand.philosophy} />
          <ol className="flex flex-col gap-4">
            {qualitySteps.map((step) => (
              <li key={step.number} className="flex gap-4 border-t border-border pt-4">
                <span className="font-serif text-xl text-accent">{step.number}</span>
                <div>
                  <p className="font-medium">{step.title}</p>
                  <p className="text-sm leading-relaxed text-muted-foreground">{step.description}</p>
                </div>
              </li>
            ))}
          </ol>
        </div>
      </section>

      <section className="border-t border-border">
        <div className="mx-auto max-w-7xl px-5 py-20 lg:px-8">
          <SectionHeading
            eyebrow="Who We Serve"
            title={brand.secondaryTagline}
            description="Flexible supply programs built around the way your business buys."
          />
          <ul className="mt-10 grid gap-px overflow-hidden rounded-2xl border border-border bg-border sm:grid-cols-2 lg:grid-cols-3">
            {b2bAudiences.map((audience) => (
              <li key={audience.title} className="flex flex-col gap-2 bg-background p-6">
                <p className="text-xs uppercase tracking-[0.2em] text-accent">{audience.tagline}</p>
                <p className="font-serif text-2xl font-medium">{audience.title}</p>
                <p className="text-sm leading-relaxed text-muted-foreground">{audience.description}</p>
              </li>
            ))}
          </ul>
        </div>
      </section>

      <CtaBand />
    </>
  )
}
