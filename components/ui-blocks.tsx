import Image from 'next/image'
import Link from 'next/link'
import { ArrowRight } from 'lucide-react'

export function Eyebrow({ children }: { children: React.ReactNode }) {
  return <p className="text-xs font-medium uppercase tracking-[0.3em] text-accent">{children}</p>
}

export function SectionHeading({
  eyebrow,
  title,
  description,
  align = 'left',
}: {
  eyebrow?: string
  title: string
  description?: string
  align?: 'left' | 'center'
}) {
  return (
    <div className={`flex max-w-2xl flex-col gap-3 ${align === 'center' ? 'mx-auto items-center text-center' : ''}`}>
      {eyebrow && <Eyebrow>{eyebrow}</Eyebrow>}
      <h2 className="font-serif text-4xl font-medium leading-tight text-balance md:text-5xl">{title}</h2>
      {description && <p className="leading-relaxed text-muted-foreground text-pretty">{description}</p>}
    </div>
  )
}

export function PageHero({
  eyebrow,
  title,
  description,
  image,
  imageAlt = '',
}: {
  eyebrow: string
  title: string
  description: string
  image?: string
  imageAlt?: string
}) {
  return (
    <section className="border-b border-border">
      <div className="mx-auto grid max-w-7xl items-center gap-10 px-5 py-16 md:py-20 lg:grid-cols-2 lg:px-8">
        <div className="flex flex-col gap-5">
          <Eyebrow>{eyebrow}</Eyebrow>
          <h1 className="font-serif text-5xl font-medium leading-[1.05] text-balance md:text-6xl">{title}</h1>
          <p className="max-w-xl text-lg leading-relaxed text-muted-foreground text-pretty">{description}</p>
        </div>
        {image && (
          <div className="relative aspect-[4/3] overflow-hidden rounded-2xl">
            <Image src={image} alt={imageAlt} fill priority sizes="(min-width: 1024px) 50vw, 100vw" className="object-cover" />
          </div>
        )}
      </div>
    </section>
  )
}

export function ButtonLink({
  href,
  children,
  variant = 'primary',
}: {
  href: string
  children: React.ReactNode
  variant?: 'primary' | 'outline' | 'light'
}) {
  const styles = {
    primary: 'bg-primary text-primary-foreground hover:opacity-90',
    outline: 'border border-foreground/30 text-foreground hover:border-foreground',
    light: 'bg-primary-foreground text-primary hover:opacity-90',
  }[variant]
  const isExternal = href.startsWith('http')
  return (
    <Link
      href={href}
      {...(isExternal ? { target: '_blank', rel: 'noopener noreferrer' } : {})}
      className={`inline-flex items-center gap-2 rounded-full px-6 py-3 text-sm font-medium transition ${styles}`}
    >
      {children}
      <ArrowRight className="size-4" aria-hidden />
    </Link>
  )
}

export function CtaBand({
  title = 'Ready to source with confidence?',
  description = 'Share your product, volume and destination. Our trade desk responds with specifications, availability and indicative pricing within one business day.',
}: {
  title?: string
  description?: string
}) {
  return (
    <section className="bg-primary text-primary-foreground">
      <div className="mx-auto flex max-w-7xl flex-col items-start justify-between gap-8 px-5 py-16 md:flex-row md:items-center lg:px-8">
        <div className="max-w-2xl">
          <h2 className="font-serif text-4xl font-medium text-balance">{title}</h2>
          <p className="mt-3 leading-relaxed text-primary-foreground/75">{description}</p>
        </div>
        <ButtonLink href="/quote" variant="light">
          Request a Quote
        </ButtonLink>
      </div>
    </section>
  )
}
