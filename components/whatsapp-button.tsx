import { MessageCircle } from 'lucide-react'
import { whatsappLink } from '@/lib/brand'

export function WhatsAppButton() {
  return (
    <a
      href={whatsappLink()}
      target="_blank"
      rel="noopener noreferrer"
      className="fixed bottom-5 right-5 z-40 inline-flex size-14 items-center justify-center rounded-full bg-[#25d366] text-white shadow-lg transition-transform hover:scale-105"
    >
      <MessageCircle className="size-6" aria-hidden />
      <span className="sr-only">Chat with NUTURALS on WhatsApp</span>
    </a>
  )
}
