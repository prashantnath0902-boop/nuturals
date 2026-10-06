import Link from 'next/link'
import { brand, navLinks, whatsappLink } from '@/lib/brand'

export function SiteFooter() {
  return (
    <footer className="bg-primary text-primary-foreground">
      <div className="mx-auto grid max-w-7xl gap-10 px-5 py-14 md:grid-cols-4 lg:px-8">
        <div className="md:col-span-2">
          <p className="font-serif text-3xl font-semibold tracking-[0.2em]">{brand.name}</p>
          <p className="mt-2 font-serif text-lg italic text-primary-foreground/80">{brand.secondaryTagline}</p>
          <p className="mt-4 max-w-md text-sm leading-relaxed text-primary-foreground/70">{brand.supportingLine}</p>
        </div>

        <nav aria-label="Footer">
          <p className="text-xs uppercase tracking-[0.25em] text-accent">Explore</p>
          <ul className="mt-4 grid grid-cols-2 gap-2 text-sm">
            {navLinks.map((link) => (
              <li key={link.href}>
                <Link href={link.href} className="text-primary-foreground/80 hover:text-primary-foreground">
                  {link.label}
                </Link>
              </li>
            ))}
          </ul>
        </nav>

        <div>
          <p className="text-xs uppercase tracking-[0.25em] text-accent">Trade Desk</p>
          <ul className="mt-4 flex flex-col gap-2 text-sm text-primary-foreground/80">
            <li>
              <a href={`mailto:${brand.email}`} className="hover:text-primary-foreground">
                {brand.email}
              </a>
            </li>
            <li>
              <a href={whatsappLink()} target="_blank" rel="noopener noreferrer" className="hover:text-primary-foreground">
                WhatsApp {brand.whatsappDisplay}
              </a>
            </li>
            <li className="leading-relaxed">{brand.office}</li>
          </ul>
        </div>
      </div>
      <div className="border-t border-primary-foreground/10">
        <p className="mx-auto max-w-7xl px-5 py-6 text-xs text-primary-foreground/60 lg:px-8">
          {`© ${new Date().getFullYear()} ${brand.name}. All rights reserved.`}
        </p>
      </div>
    </footer>
  )
}
