export const brand = {
  name: 'NUTURALS',
  tagline: "Nature's Finest. Sourced for the World.",
  collectionTitle: 'Ultra-Premium Reserve • Artisanal Collection',
  established: 'Est. 2023',
  philosophy:
    'Hand-harvested from elite micro-climates exclusively for connoisseurs. Precious botanicals, artisan-selected from heritage orchards, meticulously roasted, preserved, and presented.',
  supportingLine:
    'Premium nuts, dried fruits and natural foods — carefully sourced, quality focused, and supplied with consistency.',
  secondaryTagline: 'Pure by Nature. Trusted by Business.',
  whatsappNumber: '919151290000',
  whatsappDisplay: '+91 91512 90000',
  defaultWhatsappMessage:
    'Hello NUTURALS, I would like to enquire about your Sovereign Reserve collections.',
  email: 'nuturals777@gmail.com',
  phone: '+91 91512 90000',
  conciergeEmail: 'concierge@nuturals.com',
  office: 'NUTURALS Trade & Sourcing Office, Bengaluru, Karnataka, India',
  instagram: 'https://instagram.com/nuturals',
  linkedin: 'https://linkedin.com/company/nuturals',
} as const

export function whatsappLink(message: string = brand.defaultWhatsappMessage) {
  return `https://wa.me/${brand.whatsappNumber}?text=${encodeURIComponent(message)}`
}

export const businessTypes = [
  'Wholesaler',
  'Distributor',
  'Retailer',
  'HORECA',
  'Food Manufacturer',
  'Export Buyer',
  'Other',
] as const

export const sourcingRegions = [
  { country: 'United States', products: 'Almonds, Walnuts, Cranberries', description: 'Established growing regions known for calibrated grading and high-volume consistency.' },
  { country: 'India', products: 'Cashews, Raisins, Makhana', description: 'Rich agricultural belts with specialized processing and direct farmgate relationships.' },
  { country: 'Middle East & Iran', products: 'Pistachios, Dates', description: 'Traditional arid terroirs renowned for distinctive size, flavor, and color.' },
  { country: 'Afghanistan', products: 'Figs, Dried Fruits', description: 'Heritage highland valleys producing sun-ripened, naturally dried fruit varieties.' },
  { country: 'Australia', products: 'Almonds, Macadamias', description: 'Strict phytosanitary standards and premium grade processing facilities.' },
  { country: 'Turkey', products: 'Apricots, Hazelnuts, Figs', description: 'Mediterranean growing belts with advanced sorting and grading standards.' },
]

export const qualitySteps = [
  { number: '01', title: 'Source', description: 'Responsible sourcing and supplier selection based on defined origin integrity and verifiable agricultural practices.' },
  { number: '02', title: 'Inspect', description: 'Rigorous physical and specification review upon arrival, ensuring moisture, sizing, and sensory standards.' },
  { number: '03', title: 'Select', description: 'Precision grading and optical selection calibrated to client requirements (whole, diced, blanched, or raw).' },
  { number: '04', title: 'Pack', description: 'Modified atmosphere or vacuum bulk packaging alongside custom retail-ready private label packs.' },
  { number: '05', title: 'Deliver', description: 'Dependable, trackable logistics and containerized fulfillment for regional and international enterprise partners.' },
]

export const b2bAudiences = [
  { title: 'Wholesalers', tagline: 'Bulk Supply & Reliability', description: 'Consistent pallet and container-load supply for established trading houses and regional commodity brokers.' },
  { title: 'Distributors', tagline: 'Regional Market Solutions', description: 'Co-branded or bulk distribution arrangements designed for steady weekly replenishment and market reach.' },
  { title: 'Retailers', tagline: 'Shelf-Ready Excellence', description: 'Premium shelf-ready packaging options with eye-catching clarity and tamper-evident barrier seals.' },
  { title: 'HORECA', tagline: 'Culinary Consistency', description: 'Calibrated kernel sizes and whole/broken selections tailored for five-star hotels, restaurants, and catering.' },
  { title: 'Food Manufacturers', tagline: 'Industrial Raw Materials', description: 'Uniform pastes, meal, blanched pieces, and raw ingredients for confectionery, bakery, and dairy industries.' },
  { title: 'Export Buyers', tagline: 'International Trade', description: 'Export documentation, phytosanitary compliance, and container shipping for international destinations.' },
]

export const faqItems = [
  { question: 'Do you offer wholesale quantities?', answer: 'Yes. NUTURALS is primarily structured to serve wholesale and commercial buyers with flexible volume brackets ranging from standard pallet loads to 20ft and 40ft container consignments.' },
  { question: 'Do you provide custom packaging?', answer: 'Yes. We offer both bulk commercial packaging (nitrogen-flushed bags, master cartons, 10kg/25kg bags) and custom retail packaging (pouches, jars, tins) for retail partners.' },
  { question: 'Can I request a product specification?', answer: 'Certainly. Detailed Technical Data Sheets (TDS) covering moisture content, sizing calibration, microbiological parameters, and organoleptic profiles are available upon request for each product batch.' },
  { question: 'Do you offer private-label packaging?', answer: 'We are currently preparing dedicated private-label programs for select retail and distribution partners. You may submit your brand requirements to start a customized packaging consultation.' },
  { question: 'What is the minimum order quantity (MOQ)?', answer: 'MOQs depend on the product category, packaging specification, and destination market. Typical wholesale MOQs start from one pallet. Exact requirements are confirmed during quote review.' },
  { question: 'Do you supply internationally?', answer: 'We actively collaborate with international buyers, providing export documentation, phytosanitary compliance assistance, and FOB / CIF logistics planning.' },
  { question: 'How can I request a quotation?', answer: 'You can submit an inquiry through our Quote Request form, message our trade desk directly via WhatsApp (+91 91512 90000), or email your RFQ to nuturals777@gmail.com.' },
  { question: 'What payment and shipping options are available?', answer: 'Commercial payment terms (such as LC, TT, or advance arrangements) and shipping schedules (ex-warehouse, port-to-port, or door delivery) are finalized upon business credit evaluation and contract terms.' },
]

export const navLinks = [
  { href: '/products', label: 'Products' },
  { href: '/catalogue', label: 'Catalogue' },
  { href: '/b2b', label: 'B2B' },
  { href: '/export', label: 'Export' },
  { href: '/private-label', label: 'Private Label' },
  { href: '/quality', label: 'Quality' },
  { href: '/about', label: 'About' },
  { href: '/contact', label: 'Contact' },
]
