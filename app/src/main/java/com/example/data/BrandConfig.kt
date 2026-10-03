package com.example.data

/**
 * Centralized Brand Configuration for NUTURALS.
 * All company details, contact info, taglines, and policies are managed here
 * to avoid hardcoded duplication across the app.
 */
object BrandConfig {
  const val BRAND_NAME = "NUTURALS"
  const val TAGLINE = "Nature's Finest. Sourced for the World."
  const val COLLECTION_TITLE = "ULTRA-PREMIUM RESERVE • ARTISANAL COLLECTION"
  const val ESTABLISHED_YEAR = "EST. 2023"
  const val SOVEREIGN_PHILOSOPHY =
    "Hand-harvested from elite micro-climates exclusively for connoisseurs. Precious botanicals, artisan-selected from heritage orchards, meticulously roasted, preserved, and presented."
  const val SUPPORTING_LINE =
    "Premium nuts, dried fruits and natural foods — carefully sourced, quality focused, and supplied with consistency."
  const val SECONDARY_TAGLINE = "Pure by Nature. Trusted by Business."

  // WhatsApp Integration (Configurable phone in international format)
  const val WHATSAPP_NUMBER = "+919151290000"
  const val WHATSAPP_DISPLAY = "+91 91512 90000"
  const val DEFAULT_WHATSAPP_MESSAGE = "Hello NUTURALS, I would like to enquire about your Sovereign Reserve collections."

  // Contact Info
  const val CONTACT_EMAIL = "nuturals777@gmail.com"
  const val CONTACT_PHONE = "+91 91512 90000"
  const val CONCIERGE_EMAIL = "concierge@nuturals.com"
  const val IMPERIAL_EMAIL = "imperial@nuturals.com"
  const val OFFICE_LOCATION = "NUTURALS Trade & Sourcing Office, Bengaluru, Karnataka, India"

  // Social Links
  const val INSTAGRAM_URL = "https://instagram.com/nuturals"
  const val LINKEDIN_URL = "https://linkedin.com/company/nuturals"

  // Audience / Business Types for Lead Form
  val BUSINESS_TYPES = listOf(
    "Wholesaler",
    "Distributor",
    "Retailer",
    "HORECA",
    "Food Manufacturer",
    "Export Buyer",
    "Other"
  )

  // Sourcing Origins represented (without unsupported factual claims)
  val SOURCING_REGIONS = listOf(
    OriginRegion("United States", "Almonds, Walnuts, Cranberries", "Established growing regions known for calibrated grading and high-volume consistency."),
    OriginRegion("India", "Cashews, Raisins, Makhana", "Rich agricultural belts with specialized processing and direct farmgate relationships."),
    OriginRegion("Middle East & Iran", "Pistachios, Dates", "Traditional arid terroirs renowned for distinctive size, flavor, and color."),
    OriginRegion("Afghanistan", "Figs, Dried Fruits", "Heritage highland valleys producing sun-ripened, naturally dried fruit varieties."),
    OriginRegion("Australia", "Almonds, Macadamias", "Strict phytosanitary standards and premium grade processing facilities."),
    OriginRegion("Turkey", "Apricots, Hazelnuts, Figs", "Mediterranean Mediterranean growing belts with advanced sorting and grading standards.")
  )

  // Quality Steps for From Source to Shelf
  val QUALITY_STEPS = listOf(
    QualityStep(
      number = "01",
      title = "SOURCE",
      description = "Responsible sourcing and supplier selection based on defined origin integrity and verifiable agricultural practices."
    ),
    QualityStep(
      number = "02",
      title = "INSPECT",
      description = "Rigorous physical and specification review upon arrival, ensuring moisture, sizing, and sensory standards."
    ),
    QualityStep(
      number = "03",
      title = "SELECT",
      description = "Precision grading and optical selection calibrated to client requirements (whole, diced, blanched, or raw)."
    ),
    QualityStep(
      number = "04",
      title = "PACK",
      description = "Modified atmosphere or vacuum bulk packaging alongside custom retail-ready private label packs."
    ),
    QualityStep(
      number = "05",
      title = "DELIVER",
      description = "Dependable, trackable logistics and containerized fulfillment for regional and international enterprise partners."
    )
  )

  // B2B Segments
  val B2B_AUDIENCES = listOf(
    B2BAudience(
      title = "WHOLESALERS",
      tagline = "Bulk Supply & Reliability",
      description = "Consistent pallet and container-load supply for established trading houses and regional commodity brokers."
    ),
    B2BAudience(
      title = "DISTRIBUTORS",
      tagline = "Regional Market Solutions",
      description = "Co-branded or bulk distribution arrangements designed for steady weekly replenishment and market reach."
    ),
    B2BAudience(
      title = "RETAILERS",
      tagline = "Shelf-Ready Excellence",
      description = "Premium shelf-ready packaging options with eye-catching clarity and tamper-evident barrier seals."
    ),
    B2BAudience(
      title = "HORECA",
      tagline = "Culinary Consistency",
      description = "Calibrated kernel sizes and whole/broken selections tailored for five-star hotels, restaurants, and catering."
    ),
    B2BAudience(
      title = "FOOD MANUFACTURERS",
      tagline = "Industrial Raw Materials",
      description = "Uniform pastes, meal, blanched pieces, and raw ingredients for confectionery, bakery, and dairy industries."
    ),
    B2BAudience(
      title = "EXPORT BUYERS",
      tagline = "International Trade",
      description = "Export documentation, phytosanitary compliance, and container shipping for international destinations."
    )
  )

  // FAQ Items (using honest business wording without unsupported promises)
  val FAQ_ITEMS = listOf(
    FaqItem(
      question = "Do you offer wholesale quantities?",
      answer = "Yes. NUTURALS is primarily structured to serve wholesale and commercial buyers with flexible volume brackets ranging from standard pallet loads to 20ft and 40ft container consignments."
    ),
    FaqItem(
      question = "Do you provide custom packaging?",
      answer = "Yes. We offer both bulk commercial packaging (nitrogen-flushed bags, master cartons, 10kg/25kg bags) and custom retail packaging (pouches, jars, tins) for retail partners."
    ),
    FaqItem(
      question = "Can I request a product specification?",
      answer = "Certainly. Detailed Technical Data Sheets (TDS) covering moisture content, sizing calibration, microbiological parameters, and organoleptic profiles are available upon request for each product batch."
    ),
    FaqItem(
      question = "Do you offer private-label packaging?",
      answer = "We are currently preparing dedicated private-label programs for select retail and distribution partners. You may submit your brand requirements to start a customized packaging consultation."
    ),
    FaqItem(
      question = "What is the minimum order quantity (MOQ)?",
      answer = "MOQs depend on the product category, packaging specification, and destination market. Typical wholesale MOQs start from one pallet. Exact requirements are confirmed during quote review."
    ),
    FaqItem(
      question = "Do you supply internationally?",
      answer = "We actively collaborate with international buyers, providing export documentation, phytosanitary compliance assistance, and FOB / CIF logistics planning."
    ),
    FaqItem(
      question = "How can I request a quotation?",
      answer = "You can submit an inquiry through our digital Quote Request form, message our trade desk directly via WhatsApp (+91 91512 90000), or email your RFQ to nuturals777@gmail.com."
    ),
    FaqItem(
      question = "What payment and shipping options are available?",
      answer = "Commercial payment terms (such as LC, TT, or advance arrangements) and shipping schedules (ex-warehouse, port-to-port, or door delivery) are finalized upon business credit evaluation and contract terms."
    )
  )
}

data class OriginRegion(
  val country: String,
  val products: String,
  val description: String
)

data class QualityStep(
  val number: String,
  val title: String,
  val description: String
)

data class B2BAudience(
  val title: String,
  val tagline: String,
  val description: String
)

data class FaqItem(
  val question: String,
  val answer: String
)
