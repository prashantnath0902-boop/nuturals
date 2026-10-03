package com.example.ui

import android.app.Application
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.AppLanguage
import com.example.data.BrandConfig
import com.example.data.ProductFilterCriteria
import com.example.data.ProductRepository
import com.example.data.SortOption
import com.example.data.TranslationRepository
import com.example.data.local.NuturalsDatabase
import com.example.model.Product
import com.example.model.ProductCategory
import com.example.model.QuoteEnquiry
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.net.URLEncoder

sealed class Screen(val route: String, val title: String) {
  object Home : Screen("home", "Home")
  data class Products(val categoryId: String = "all", val originFilter: String? = null) : Screen("products", "Products")
  data class ProductDetail(val productId: String) : Screen("product_detail", "Product Details")
  object About : Screen("about", "About Us")
  object Quality : Screen("quality", "Quality Standards")
  object B2B : Screen("b2b", "B2B Supply")
  object PrivateLabel : Screen("private_label", "Private Label")
  object Export : Screen("export", "Export Trade")
  object Catalogue : Screen("catalogue", "Product Catalogue")
  object Contact : Screen("contact", "Request a Quote")
  object MyQuotes : Screen("my_quotes", "Submitted RFQs")
}

data class QuoteFormState(
  val fullName: String = "",
  val companyName: String = "",
  val businessEmail: String = "",
  val phoneWhatsApp: String = "",
  val country: String = "India",
  val businessType: String = "Wholesaler",
  val productsInterestedIn: String = "",
  val approximateQuantity: String = "",
  val packagingRequirement: String = "",
  val message: String = "",
  val isSubmitting: Boolean = false,
  val isSubmittedSuccess: Boolean = false,
  val errorMessage: String? = null
)

class NuturalsViewModel(application: Application) : AndroidViewModel(application) {

  private val database = NuturalsDatabase.getDatabase(application)
  private val quoteDao = database.quoteDao()

  // Navigation Stack
  private val _navigationStack = MutableStateFlow<List<Screen>>(listOf(Screen.Home))
  private val _screenState = MutableStateFlow<Screen>(Screen.Home)
  val activeScreen: StateFlow<Screen> = _screenState.asStateFlow()

  // Language / Localization State
  private val _currentLanguage = MutableStateFlow(AppLanguage.EN)
  val currentLanguage: StateFlow<AppLanguage> = _currentLanguage.asStateFlow()

  // Advanced Product Filters & Search State
  private val _filterCriteria = MutableStateFlow(ProductFilterCriteria())
  val filterCriteria: StateFlow<ProductFilterCriteria> = _filterCriteria.asStateFlow()

  // Quote Form
  private val _quoteForm = MutableStateFlow(QuoteFormState())
  val quoteForm: StateFlow<QuoteFormState> = _quoteForm.asStateFlow()

  // Submissions Flow from Room
  val submittedEnquiries: StateFlow<List<QuoteEnquiry>> = quoteDao.getAllEnquiries()
    .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

  fun setLanguage(language: AppLanguage) {
    _currentLanguage.value = language
  }

  fun t(key: String): String {
    return TranslationRepository.getString(key, _currentLanguage.value)
  }

  fun navigateTo(screen: Screen) {
    if (screen is Screen.Products && screen.originFilter != null) {
      // Pre-set origin filter if coming from interactive world map
      updateFilter(origin = screen.originFilter)
    }
    val current = _navigationStack.value.toMutableList()
    current.add(screen)
    _navigationStack.value = current
    _screenState.value = screen
  }

  fun navigateBack(): Boolean {
    val current = _navigationStack.value.toMutableList()
    if (current.size > 1) {
      current.removeAt(current.size - 1)
      _navigationStack.value = current
      _screenState.value = current.last()
      return true
    }
    return false
  }

  fun updateFilter(
    query: String? = null,
    category: ProductCategory? = null,
    origin: String? = null,
    availability: String? = null,
    form: String? = null,
    sortBy: SortOption? = null
  ) {
    val current = _filterCriteria.value
    _filterCriteria.value = current.copy(
      query = query ?: current.query,
      category = category ?: current.category,
      origin = origin ?: current.origin,
      availability = availability ?: current.availability,
      form = form ?: current.form,
      sortBy = sortBy ?: current.sortBy
    )
  }

  fun resetFilters() {
    _filterCriteria.value = ProductFilterCriteria()
  }

  fun setCategoryFilter(category: ProductCategory) {
    updateFilter(category = category)
  }

  fun setSearchQuery(query: String) {
    updateFilter(query = query)
  }

  fun filterByOrigin(originName: String) {
    updateFilter(origin = originName)
    navigateTo(Screen.Products(originFilter = originName))
  }

  fun openProductDetail(product: Product) {
    navigateTo(Screen.ProductDetail(product.id))
  }

  fun startQuoteForProduct(product: Product) {
    _quoteForm.value = _quoteForm.value.copy(
      productsInterestedIn = product.name,
      message = "We are interested in receiving a wholesale quote and specification sheet for ${product.name} (Grade: ${product.grade})."
    )
    navigateTo(Screen.Contact)
  }

  fun updateQuoteForm(
    fullName: String? = null,
    companyName: String? = null,
    businessEmail: String? = null,
    phoneWhatsApp: String? = null,
    country: String? = null,
    businessType: String? = null,
    productsInterestedIn: String? = null,
    approximateQuantity: String? = null,
    packagingRequirement: String? = null,
    message: String? = null
  ) {
    val current = _quoteForm.value
    _quoteForm.value = current.copy(
      fullName = fullName ?: current.fullName,
      companyName = companyName ?: current.companyName,
      businessEmail = businessEmail ?: current.businessEmail,
      phoneWhatsApp = phoneWhatsApp ?: current.phoneWhatsApp,
      country = country ?: current.country,
      businessType = businessType ?: current.businessType,
      productsInterestedIn = productsInterestedIn ?: current.productsInterestedIn,
      approximateQuantity = approximateQuantity ?: current.approximateQuantity,
      packagingRequirement = packagingRequirement ?: current.packagingRequirement,
      message = message ?: current.message,
      isSubmittedSuccess = false,
      errorMessage = null
    )
  }

  fun submitQuoteForm(context: Context) {
    val form = _quoteForm.value
    if (form.fullName.isBlank() || form.businessEmail.isBlank() || form.phoneWhatsApp.isBlank()) {
      _quoteForm.value = form.copy(errorMessage = "Please complete your Name, Email, and Phone/WhatsApp number.")
      return
    }

    viewModelScope.launch {
      _quoteForm.value = form.copy(isSubmitting = true, errorMessage = null)
      val enquiry = QuoteEnquiry(
        fullName = form.fullName.trim(),
        companyName = form.companyName.trim().ifEmpty { "Individual / Retail" },
        businessEmail = form.businessEmail.trim(),
        phoneWhatsApp = form.phoneWhatsApp.trim(),
        country = form.country.trim(),
        businessType = form.businessType,
        productsInterestedIn = form.productsInterestedIn.trim().ifEmpty { "General Catalog" },
        approximateQuantity = form.approximateQuantity.trim().ifEmpty { "Specification on Request" },
        packagingRequirement = form.packagingRequirement.trim().ifEmpty { "Standard Bulk / Retail" },
        message = form.message.trim()
      )
      quoteDao.insertEnquiry(enquiry)
      _quoteForm.value = form.copy(
        isSubmitting = false,
        isSubmittedSuccess = true,
        errorMessage = null
      )
    }
  }

  fun resetQuoteForm() {
    _quoteForm.value = QuoteFormState()
  }

  fun launchWhatsApp(context: Context, customMessage: String? = null) {
    try {
      val text = customMessage ?: BrandConfig.DEFAULT_WHATSAPP_MESSAGE
      val encoded = URLEncoder.encode(text, "UTF-8")
      val cleanNumber = BrandConfig.WHATSAPP_NUMBER.replace("+", "").replace(" ", "").trim()
      val url = "https://wa.me/$cleanNumber?text=$encoded"
      val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK
      }
      context.startActivity(intent)
    } catch (e: Exception) {
      Toast.makeText(
        context,
        "WhatsApp: ${BrandConfig.WHATSAPP_DISPLAY}\nMessage: \"${BrandConfig.DEFAULT_WHATSAPP_MESSAGE}\"",
        Toast.LENGTH_LONG
      ).show()
    }
  }

  fun sendEmailInquiry(context: Context, subject: String = "NUTURALS Product Inquiry", body: String = "") {
    try {
      val intent = Intent(Intent.ACTION_SENDTO).apply {
        data = Uri.parse("mailto:${BrandConfig.CONTACT_EMAIL}")
        putExtra(Intent.EXTRA_SUBJECT, subject)
        putExtra(Intent.EXTRA_TEXT, body)
        flags = Intent.FLAG_ACTIVITY_NEW_TASK
      }
      context.startActivity(intent)
    } catch (e: Exception) {
      Toast.makeText(context, "Contact: ${BrandConfig.CONTACT_EMAIL}", Toast.LENGTH_SHORT).show()
    }
  }
}
