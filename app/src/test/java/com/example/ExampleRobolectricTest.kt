package com.example

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.data.AppLanguage
import com.example.data.BrandConfig
import com.example.data.ProductFilterCriteria
import com.example.data.ProductRepository
import com.example.data.SortOption
import com.example.data.TranslationRepository
import com.example.model.ProductCategory
import com.example.ui.components.DEFAULT_SOURCING_PINS
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class ExampleRobolectricTest {

  @Test
  fun `read string from context`() {
    val context = ApplicationProvider.getApplicationContext<Context>()
    val appName = context.getString(R.string.app_name)
    assertEquals("NUTURALS", appName)
  }

  @Test
  fun `verify product catalog integrity`() {
    val products = ProductRepository.products
    assertTrue("Products catalog should not be empty", products.size >= 10)

    val featured = ProductRepository.getFeaturedProducts()
    assertTrue("Should have featured products", featured.isNotEmpty())

    val nuts = ProductRepository.getProductsByCategory(ProductCategory.NUTS)
    assertTrue("Should have nuts category products", nuts.isNotEmpty())

    val almonds = ProductRepository.getProductById("california-almonds")
    assertNotNull(almonds)
    assertEquals("USA", almonds?.origin)
    assertEquals("Price: On Request", almonds?.priceDisplay)
  }

  @Test
  fun `verify Product data class properties`() {
    val sample = Product(
      name = "California Almonds",
      category = "Nuts",
      origin = "USA",
      grade = "Nonpareil Extra #1",
      packaging = "25 lb Bulk Carton",
      moq = "1 Pallet",
      featured = true,
      imageIds = listOf(R.mipmap.ic_launcher, R.mipmap.ic_launcher_round)
    )

    assertEquals("California Almonds", sample.name)
    assertEquals("Nuts", sample.category)
    assertEquals("USA", sample.origin)
    assertEquals("Nonpareil Extra #1", sample.grade)
    assertEquals("25 lb Bulk Carton", sample.packaging)
    assertEquals("1 Pallet", sample.moq)
    assertEquals("1 Pallet", sample.MOQ)
    assertTrue(sample.featured)
    assertTrue(sample.isFeatured)
    assertEquals(2, sample.imageIds.size)
    assertEquals(2, sample.imageResIds.size)
    assertEquals(2, sample.images.size)
    assertEquals(2, sample.imageResourceIds.size)

    // Also verify enum-based category constructor
    val enumSample = Product(
      name = "Jumbo Cashews",
      category = ProductCategory.NUTS,
      origin = "India",
      grade = "W240",
      packaging = "10 kg Tin",
      moq = "500 kg",
      isFeatured = true,
      imageIds = listOf(R.mipmap.ic_launcher)
    )
    assertEquals("Jumbo Cashews", enumSample.name)
    assertEquals("Nuts", enumSample.category)
    assertEquals("India", enumSample.origin)
    assertTrue(enumSample.isFeatured)
    assertEquals(1, enumSample.imageIds.size)
  }

  @Test
  fun `verify advanced multi-facet product filtering`() {
    // 1. Filter by Origin "USA"
    val usaResults = ProductRepository.filterProducts(ProductFilterCriteria(origin = "USA"))
    assertTrue("Should find USA products", usaResults.isNotEmpty())
    assertTrue("All results should be from USA", usaResults.all { it.origin.contains("USA") })

    // 2. Filter by Category & Query
    val raisinResults = ProductRepository.filterProducts(
      ProductFilterCriteria(category = ProductCategory.DRIED_FRUITS, query = "Raisins")
    )
    assertTrue("Should find golden raisins", raisinResults.isNotEmpty())

    // 3. Filter by Form "Blanched"
    val blanchedResults = ProductRepository.filterProducts(
      ProductFilterCriteria(form = "Blanched")
    )
    assertTrue("Should find blanched products", blanchedResults.isNotEmpty())

    // 4. Sort by Name A-Z
    val sortedAsc = ProductRepository.filterProducts(
      ProductFilterCriteria(sortBy = SortOption.NAME_ASC)
    )
    assertTrue("First item name should be <= second item name", sortedAsc[0].name <= sortedAsc[1].name)
  }

  @Test
  fun `verify interactive world map sourcing pins`() {
    assertTrue("Should have global sourcing pins", DEFAULT_SOURCING_PINS.size >= 5)
    val usaPin = DEFAULT_SOURCING_PINS.find { it.id == "usa" }
    assertNotNull(usaPin)
    assertTrue("USA pin contains Almonds", usaPin!!.products.contains("Almonds"))

    val indiaPin = DEFAULT_SOURCING_PINS.find { it.id == "india" }
    assertNotNull(indiaPin)
    assertTrue("India pin contains Cashews", indiaPin!!.products.contains("Cashew"))
  }

  @Test
  fun `verify multi-language translations`() {
    // English
    val enTagline = TranslationRepository.getString("tagline", AppLanguage.EN)
    assertEquals("Nature's Finest. Sourced for the World.", enTagline)

    // French
    val frTagline = TranslationRepository.getString("tagline", AppLanguage.FR)
    assertEquals("La Nature à son Apogée. Sourcée pour le Monde.", frTagline)

    // German
    val deTagline = TranslationRepository.getString("tagline", AppLanguage.DE)
    assertEquals("Das Beste der Natur. Beschafft für die Welt.", deTagline)

    // Spanish
    val esTagline = TranslationRepository.getString("tagline", AppLanguage.ES)
    assertEquals("Lo Mejor de la Naturaleza. Obtenido para el Mundo.", esTagline)

    // Arabic
    val arTagline = TranslationRepository.getString("tagline", AppLanguage.AR)
    assertEquals("أفضل ما في الطبيعة. تم توفيره للعالم.", arTagline)
  }

  @Test
  fun `verify brand configuration`() {
    assertEquals("NUTURALS", BrandConfig.BRAND_NAME)
    assertEquals("Nature's Finest. Sourced for the World.", BrandConfig.TAGLINE)
    assertEquals("nuturals777@gmail.com", BrandConfig.CONTACT_EMAIL)
    assertEquals("+919151290000", BrandConfig.WHATSAPP_NUMBER)
    assertEquals("+91 91512 90000", BrandConfig.WHATSAPP_DISPLAY)
    assertTrue(BrandConfig.BUSINESS_TYPES.contains("Wholesaler"))
    assertTrue(BrandConfig.BUSINESS_TYPES.contains("Distributor"))
    assertTrue(BrandConfig.BUSINESS_TYPES.contains("Retailer"))
  }
}
