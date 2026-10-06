import type { Metadata } from 'next'
import { Mail, MapPin, MessageCircle, Phone } from 'lucide-react'
import { brand, whatsappLink } from '@/lib/brand'
import { ContactForm } from '@/components/contact-form'
import { Eyebrow } from '@/components/ui-blocks'

export const metadata: Metadata = {
  title: 'Contact',
  description: 'Contact the NUTURALS trade and sourcing office in Bengaluru, India.',
}

export default function ContactPage() {
  const channels = [
    { icon: MessageCircle, label: 'WhatsApp', value: brand.whatsappDisplay, href: whatsappLink() },
    { icon: Mail, label: 'Trade email', value: brand.email, href: `mailto:${brand.email}` },
    { icon: Mail, label: 'Concierge', value: brand.conciergeEmail, href: `mailto:${brand.conciergeEmail}` },
    { icon: Phone, label: 'Phone', value: brand.phone, href: `tel:${brand.phone.replace(/\s/g, '')}` },
  ]

  return (
    <section className="mx-auto grid max-w-7xl gap-12 px-5 py-16 lg:grid-cols-[1fr_1.6fr] lg:px-8">
      <div className="flex flex-col gap-6">
        <Eyebrow>Contact</Eyebrow>
        <h1 className="font-serif text-5xl font-medium leading-tight text-balance">{"Let's talk sourcing."}</h1>
        <p className="text-lg leading-relaxed text-muted-foreground">
          General enquiries, partnerships or press — reach us through any channel below or send a message.
        </p>
        <ul className="flex flex-col gap-4 border-t border-border pt-6">
          {channels.map(({ icon: Icon, label, value, href }) => (
            <li key={label}>
              <a
                href={href}
                {...(href.startsWith('http') ? { target: '_blank', rel: 'noopener noreferrer' } : {})}
                className="group flex items-center gap-4"
              >
                <span className="inline-flex size-10 items-center justify-center rounded-full bg-muted">
                  <Icon className="size-4 text-accent" aria-hidden />
                </span>
                <span className="flex flex-col">
                  <span className="text-xs uppercase tracking-[0.15em] text-muted-foreground">{label}</span>
                  <span className="font-medium group-hover:text-accent">{value}</span>
                </span>
              </a>
            </li>
          ))}
          <li className="flex items-center gap-4">
            <span className="inline-flex size-10 shrink-0 items-center justify-center rounded-full bg-muted">
              <MapPin className="size-4 text-accent" aria-hidden />
            </span>
            <span className="flex flex-col">
              <span className="text-xs uppercase tracking-[0.15em] text-muted-foreground">Office</span>
              <span className="font-medium">{brand.office}</span>
            </span>
          </li>
        </ul>
      </div>
      <ContactForm />
    </section>
  )
}
