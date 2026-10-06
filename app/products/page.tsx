import type { Metadata } from 'next'
import Link from 'next/link'
import { categories, products, type CategoryId } from '@/lib/products'
import { ProductCard } from '@/components/product-card'
import { CtaBand, Eyebrow } from '@/components/ui-blocks'

export const metadata: Metadata = {
  title: 'Products',
  description: 'Premium nuts, dried fruits, seeds, superfoods and specialty products for trade buyers.',
}

export default async function ProductsPage({
  searchParams,
}: {
  searchParams: Promise<{ category?: string }>
}) {
  const { category } = await searchParams
  const activeCategory = categories.find((item) => item.id === category)?.id as CategoryId | undefined
  const visible = activeCategory ? products.filter((product) => product.category === activeCategory) : products
  const heading = activeCategory ? categories.find((item) => item.id === activeCategory) : undefined

  return (
    <>
      <section className="mx-auto max-w-7xl px-5 pt-16 lg:px-8">
        <Eyebrow>Product Range</Eyebrow>
        <h1 className="mt-3 font-serif text-5xl font-medium md:text-6xl">{heading?.name ?? 'All Products'}</h1>
        <p className="mt-4 max-w-2xl text-lg leading-relaxed text-muted-foreground">
          {heading?.subtitle ??
            'Explore our complete range. Every product is available in bulk and retail formats with full specifications on request.'}
        </p>

        <nav aria-label="Product categories" className="mt-8 flex flex-wrap gap-2">
          <FilterChip href="/products" active={!activeCategory} label="All" />
          {categories.map((item) => (
            <FilterChip
              key={item.id}
              href={`/products?category=${item.id}`}
              active={activeCategory === item.id}
              label={item.name}
            />
          ))}
        </nav>
      </section>

      <section className="mx-auto max-w-7xl px-5 py-12 lg:px-8">
        <p className="mb-6 text-sm text-muted-foreground">{`${visible.length} products`}</p>
        <div className="grid gap-6 sm:grid-cols-2 lg:grid-cols-4">
          {visible.map((product) => (
            <ProductCard key={product.id} product={product} />
          ))}
        </div>
      </section>

      <CtaBand />
    </>
  )
}

function FilterChip({ href, active, label }: { href: string; active: boolean; label: string }) {
  return (
    <Link
      href={href}
      aria-current={active ? 'page' : undefined}
      className={`rounded-full border px-4 py-2 text-sm transition-colors ${
        active ? 'border-primary bg-primary text-primary-foreground' : 'border-border hover:border-foreground/40'
      }`}
    >
      {label}
    </Link>
  )
}
