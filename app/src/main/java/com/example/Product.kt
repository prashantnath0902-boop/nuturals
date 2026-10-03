package com.example

import com.example.model.ProductCategory
import com.example.model.ProductSpecification

/**
 * Data class 'Product' in the com.example package.
 * Properties:
 * - name: String
 * - category: String
 * - origin: String
 * - grade: String
 * - packaging: String
 * - moq: String
 * - featured: Boolean
 * - imageIds: List<Int>
 */
data class Product(
  val name: String,
  val category: String,
  val origin: String,
  val grade: String = "Specification to be confirmed",
  val packaging: String = "Bulk / Custom Packaging",
  val moq: String = "On Request",
  val featured: Boolean = false,
  val imageIds: List<Int> = emptyList(),
  val isFeatured: Boolean = featured,
  val id: String = name.lowercase().replace(" ", "-"),
  val description: String = "",
  val packagingOptions: List<String> = listOf(packaging),
  val priceDisplay: String = "Price: On Request",
  val availableForms: List<String> = emptyList(),
  val applications: List<String> = emptyList(),
  val specifications: List<ProductSpecification> = emptyList(),
  val availability: String = "In Stock / Regular Supply",
  val visualIconType: String = "almond"
) {
  // Alias for image resource IDs
  val imageResIds: List<Int>
    get() = imageIds

  val images: List<Int>
    get() = imageIds

  val imageResourceIds: List<Int>
    get() = imageIds

  val imageResources: List<Int>
    get() = imageIds

  // Alias property matching uppercase 'MOQ'
  val MOQ: String
    get() = moq

  // Secondary constructor supporting ProductCategory enum
  constructor(
    name: String,
    category: ProductCategory,
    origin: String,
    grade: String = "Specification to be confirmed",
    packaging: String = "Bulk / Custom Packaging",
    moq: String = "On Request",
    featured: Boolean = false,
    imageIds: List<Int> = emptyList(),
    id: String = name.lowercase().replace(" ", "-"),
    description: String = "",
    packagingOptions: List<String> = listOf(packaging),
    priceDisplay: String = "Price: On Request",
    availableForms: List<String> = emptyList(),
    applications: List<String> = emptyList(),
    specifications: List<ProductSpecification> = emptyList(),
    availability: String = "In Stock / Regular Supply",
    visualIconType: String = "almond",
    isFeatured: Boolean = featured
  ) : this(
    name = name,
    category = category.displayName,
    origin = origin,
    grade = grade,
    packaging = packaging,
    moq = moq,
    featured = featured,
    imageIds = imageIds,
    isFeatured = isFeatured,
    id = id,
    description = description,
    packagingOptions = packagingOptions,
    priceDisplay = priceDisplay,
    availableForms = availableForms,
    applications = applications,
    specifications = specifications,
    availability = availability,
    visualIconType = visualIconType
  )
}
