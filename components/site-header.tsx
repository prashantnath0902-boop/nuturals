'use client'

import Link from 'next/link'
import { usePathname } from 'next/navigation'
import { useState } from 'react'
import { Menu, X } from 'lucide-react'
import { brand, navLinks } from '@/lib/brand'

export function SiteHeader() {
  const pathname = usePathname()
  const [open, setOpen] = useState(false)

  const isActive = (href: string) => pathname === href || pathname.startsWith(`${href}/`)

  return (
    <header className="sticky top-0 z-40 border-b border-border bg-background/90 backdrop-blur">
      <div className="mx-auto flex h-16 max-w-7xl items-center justify-between gap-6 px-5 lg:px-8">
        <Link href="/" className="flex flex-col leading-none" onClick={() => setOpen(false)}>
          <span className="font-serif text-2xl font-semibold tracking-[0.2em]">{brand.name}</span>
          <span className="text-[10px] uppercase tracking-[0.3em] text-muted-foreground">{brand.established}</span>
        </Link>

        <nav aria-label="Main" className="hidden items-center gap-6 lg:flex">
          {navLinks.map((link) => (
            <Link
              key={link.href}
              href={link.href}
              aria-current={isActive(link.href) ? 'page' : undefined}
              className={`text-sm transition-colors hover:text-accent ${
                isActive(link.href) ? 'text-accent' : 'text-foreground/80'
              }`}
            >
              {link.label}
            </Link>
          ))}
        </nav>

        <div className="hidden items-center gap-3 lg:flex">
          <Link href="/my-quotes" className="text-sm text-foreground/80 hover:text-accent">
            My Quotes
          </Link>
          <Link
            href="/quote"
            className="rounded-full bg-primary px-5 py-2 text-sm font-medium text-primary-foreground transition-opacity hover:opacity-90"
          >
            Request a Quote
          </Link>
        </div>

        <button
          type="button"
          className="inline-flex size-10 items-center justify-center rounded-full border border-border lg:hidden"
          aria-expanded={open}
          aria-controls="mobile-nav"
          onClick={() => setOpen((value) => !value)}
        >
          {open ? <X className="size-5" aria-hidden /> : <Menu className="size-5" aria-hidden />}
          <span className="sr-only">{open ? 'Close menu' : 'Open menu'}</span>
        </button>
      </div>

      {open && (
        <nav id="mobile-nav" aria-label="Mobile" className="border-t border-border bg-background lg:hidden">
          <ul className="mx-auto flex max-w-7xl flex-col px-5 py-4">
            {[...navLinks, { href: '/my-quotes', label: 'My Quotes' }].map((link) => (
              <li key={link.href}>
                <Link
                  href={link.href}
                  onClick={() => setOpen(false)}
                  aria-current={isActive(link.href) ? 'page' : undefined}
                  className={`block border-b border-border/60 py-3 font-serif text-xl ${
                    isActive(link.href) ? 'text-accent' : ''
                  }`}
                >
                  {link.label}
                </Link>
              </li>
            ))}
            <li className="pt-4">
              <Link
                href="/quote"
                onClick={() => setOpen(false)}
                className="block rounded-full bg-primary px-5 py-3 text-center text-sm font-medium text-primary-foreground"
              >
                Request a Quote
              </Link>
            </li>
          </ul>
        </nav>
      )}
    </header>
  )
}
