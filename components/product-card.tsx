import Image from 'next/image'
import Link from 'next/link'
import type { Product } from '@/lib/products'

export function ProductCard({ product }: { product: Product }) {
  return (
    <article className="group flex flex-col overflow-hidden rounded-2xl border border-border bg-card transition-shadow hover:shadow-lg">
      <Link href={`/products/${product.id}`} className="flex flex-1 flex-col">
        <div className="relative aspect-square overflow-hidden bg-muted">
          <Image
            src={product.image}
            alt={product.name}
            fill
            sizes="(min-width: 1024px) 25vw, (min-width: 640px) 50vw, 100vw"
            className="object-cover transition-transform duration-500 group-hover:scale-105"
          />
        </div>
        <div className="flex flex-1 flex-col gap-2 p-5">
          <p className="text-[11px] uppercase tracking-[0.2em] text-accent">{product.origin}</p>
          <h3 className="font-serif text-2xl font-medium leading-tight">{product.name}</h3>
          <p className="line-clamp-2 text-sm leading-relaxed text-muted-foreground">{product.description}</p>
          <div className="mt-auto flex items-center justify-between gap-3 pt-3 text-xs text-muted-foreground">
            <span className="truncate">{product.grade}</span>
            <span className="shrink-0 font-medium text-foreground">{product.priceDisplay}</span>
          </div>
        </div>
      </Link>
    </article>
  )
}
