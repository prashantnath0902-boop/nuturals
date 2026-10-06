import { ButtonLink, Eyebrow } from '@/components/ui-blocks'

export default function NotFound() {
  return (
    <section className="mx-auto flex max-w-xl flex-col items-center gap-5 px-5 py-28 text-center">
      <Eyebrow>404</Eyebrow>
      <h1 className="font-serif text-5xl font-medium">Page not found</h1>
      <p className="text-muted-foreground">The page you are looking for has moved or does not exist.</p>
      <ButtonLink href="/products">Browse products</ButtonLink>
    </section>
  )
}
