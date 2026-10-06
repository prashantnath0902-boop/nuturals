import type { Metadata } from 'next'
import Image from 'next/image'
import Link from 'next/link'
import { notFound } from 'next/navigation'
import { ChevronLeft } from 'lucide-react'
import { getCategory, getProduct, products } from '@/lib/products'
import { whatsappLink } from '@/lib/brand'
import { ProductCard } from '@/components/product-card'
import { ButtonLink, Eyebrow } from '@/components/ui-blocks'

export function generateStaticParams() {
  return products.map((product) => ({ id: product.id }))
}

export async function generateMetadata({ params }: { params: Promise<{ id: string }> }): Promise<Metadata> {
  const { id } = await params
  const product = getProduct(id)
  if (!product) return {}
  return { title: product.name, description: product.description }
}

export default async function ProductDetailPage({ params }: { params: Promise<{ id: string }> }) {
  const { id } = await params
  const product = getProduct(id)
  if (!product) notFound()

  const category = getCategory(product.category)
  const related = products.filter((item) => item.category === product.category && item.id !== product.id).slice(0, 4)

  return (
    <>
      <div className="mx-auto max-w-7xl px-5 pt-8 lg:px-8">
        <Link href="/products" className="inline-flex items-center gap-1 text-sm text-muted-foreground hover:text-foreground">
          <ChevronLeft className="size-4" aria-hidden />
          All products
        </Link>
      </div>

      <section className="mx-auto grid max-w-7xl gap-12 px-5 py-10 lg:grid-cols-2 lg:px-8">
        <div className="relative aspect-square overflow-hidden rounded-2xl bg-muted">
          <Image src={product.image} alt={product.name} fill priority sizes="(min-width: 1024px) 50vw, 100vw" className="object-cover" />
        </div>

        <div className="flex flex-col gap-6">
          <div className="flex flex-col gap-3">
            <Eyebrow>{category?.name}</Eyebrow>
            <h1 className="font-serif text-5xl font-medium leading-tight text-balance">{product.name}</h1>
            <p className="text-sm text-muted-foreground">{product.notes}</p>
            <p className="text-lg leading-relaxed text-pretty">{product.description}</p>
          </div>

          <dl className="grid grid-cols-2 gap-px overflow-hidden rounded-xl border border-border bg-border text-sm">
            {[
              { label: 'Origin', value: product.origin },
              { label: 'Grade', value: product.grade },
              { label: 'MOQ', value: product.moq },
              { label: 'Availability', value: product.availability },
              { label: 'Net weight', value: product.netWeight },
              { label: 'Indicative price', value: product.priceDisplay },
            ].map((item) => (
              <div key={item.label} className="bg-card p-4">
                <dt className="text-xs uppercase tracking-[0.15em] text-muted-foreground">{item.label}</dt>
                <dd className="mt-1 font-medium">{item.value}</dd>
              </div>
            ))}
          </dl>

          <div className="flex flex-wrap gap-3">
            <ButtonLink href={`/quote?product=${product.id}`}>Request a Quote</ButtonLink>
            <ButtonLink href={whatsappLink(`Hello NUTURALS, I would like to enquire about ${product.name}.`)} variant="outline">
              Ask on WhatsApp
            </ButtonLink>
          </div>
        </div>
      </section>

      <section className="mx-auto grid max-w-7xl gap-10 border-t border-border px-5 py-14 md:grid-cols-3 lg:px-8">
        <DetailList title="Available forms" items={product.forms} />
        <DetailList title="Packaging options" items={product.packaging} />
        <DetailList title="Applications" items={product.applications} />
      </section>

      <section className="mx-auto max-w-7xl px-5 pb-16 lg:px-8">
        <h2 className="font-serif text-3xl font-medium">Specifications</h2>
        <table className="mt-6 w-full text-left text-sm">
          <tbody>
            {product.specifications.map((spec) => (
              <tr key={spec.label} className="border-b border-border">
                <th scope="row" className="py-3 pr-6 font-normal text-muted-foreground">
                  {spec.label}
                </th>
                <td className="py-3 font-medium">{spec.value}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </section>

      {related.length > 0 && (
        <section className="bg-muted/60">
          <div className="mx-auto max-w-7xl px-5 py-16 lg:px-8">
            <h2 className="font-serif text-3xl font-medium">{`More from ${category?.name}`}</h2>
            <div className="mt-8 grid gap-6 sm:grid-cols-2 lg:grid-cols-4">
              {related.map((item) => (
                <ProductCard key={item.id} product={item} />
              ))}
            </div>
          </div>
        </section>
      )}
    </>
  )
}

function DetailList({ title, items }: { title: string; items: string[] }) {
  return (
    <div>
      <h2 className="text-xs uppercase tracking-[0.2em] text-accent">{title}</h2>
      <ul className="mt-4 flex flex-col gap-2">
        {items.map((item) => (
          <li key={item} className="border-b border-border/70 pb-2">
            {item}
          </li>
        ))}
      </ul>
    </div>
  )
}
