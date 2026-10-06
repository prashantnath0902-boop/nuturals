package com.example.model

enum class ProductCategory(
  val id: String,
  val displayName: String,
  val subtitle: String,
  val chapterNumber: String = "I"
) {
  ALL("all", "All Products", "Complete Sovereign Reserve & Connoisseur catalog", "ALL"),
  NUTS("nuts", "Nuts", "Hand-selected from imperial Persian reserves and volcanic groves", "I"),
  DRIED_FRUITS("dried-fruits", "Dried Fruits", "Sun-ripened, naturally dried fruits from pristine oases", "I"),
  SEEDS_SUPERFOODS("seeds-superfoods", "Seeds & Superfoods", "Nutrient-dense botanicals and rare infused blends", "II"),
  SPECIALTY("specialty", "Specialty Products", "Masterfully roasted spiced nuts and single-origin chocolates", "III")
}

data class ProductSpecification(
  val label: String,
  val value: String
)

/**
 * Centralized Product Data Model for NUTURALS ULTRA-PREMIUM RESERVE.
 * Stores name, category, origin, grade, packaging, MOQ, and featured status,
 * alongside commercial trade parameters, catalog chapter, and reserve pricing.
 */
data class Product(
  val id: String = "",
  val name: String,
  val category: ProductCategory,
  val origin: String,
  val grade: String = "Specification to be confirmed",
  val packaging: String = "Bulk / Custom Packaging",
  val moq: String = "On Request",
  val isFeatured: Boolean = false,
  val description: String = "",
  val packagingOptions: List<String> = listOf("Bulk / Custom Packaging"),
  val priceDisplay: String = "Price: On Request",
  val availableForms: List<String> = emptyList(),
  val applications: List<String> = emptyList(),
  val specifications: List<ProductSpecification> = emptyList(),
  val availability: String = "In Stock / Regular Supply",
  val visualIconType: String = "almond",
  val chapter: String = "Chapter I: Royal Nuts & Dry Fruits",
  val netWeight: String = "250g",
  val sovereignPrice: String = "",
  val palatialNotes: String = ""
) {
  // Alias for featured status
  val featured: Boolean
    get() = isFeatured
}
