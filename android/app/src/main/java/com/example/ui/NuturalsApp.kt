package com.example.ui

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ui.components.NuturalsNavbar
import com.example.ui.components.WhatsAppFab
import com.example.ui.screens.AboutScreen
import com.example.ui.screens.B2BScreen
import com.example.ui.screens.CatalogueScreen
import com.example.ui.screens.ContactScreen
import com.example.ui.screens.ExportScreen
import com.example.ui.screens.HomeScreen
import com.example.ui.screens.MyQuotesScreen
import com.example.ui.screens.ProductDetailScreen
import com.example.ui.screens.ProductsScreen
import com.example.ui.screens.PrivateLabelScreen
import com.example.ui.screens.QualityScreen
import com.example.ui.theme.WarmIvory

@Composable
fun NuturalsApp(
  viewModel: NuturalsViewModel = viewModel(),
  modifier: Modifier = Modifier
) {
  val context = LocalContext.current
  val activeScreen by viewModel.activeScreen.collectAsState()
  val quoteFormState by viewModel.quoteForm.collectAsState()
  val submittedEnquiries by viewModel.submittedEnquiries.collectAsState()
  val currentLanguage by viewModel.currentLanguage.collectAsState()

  // Handle hardware / gesture back button
  BackHandler(enabled = activeScreen != Screen.Home) {
    viewModel.navigateBack()
  }

  Scaffold(
    modifier = modifier.fillMaxSize(),
    containerColor = WarmIvory,
    topBar = {
      NuturalsNavbar(
        activeScreen = activeScreen,
        currentLanguage = currentLanguage,
        onLanguageChange = { viewModel.setLanguage(it) },
        onNavigate = { screen -> viewModel.navigateTo(screen) },
        onRequestQuoteClick = { viewModel.navigateTo(Screen.Contact) }
      )
    }
  ) { innerPadding ->
    Box(
      modifier = Modifier
        .fillMaxSize()
        .padding(innerPadding)
    ) {
      AnimatedContent(
        targetState = activeScreen,
        transitionSpec = { fadeIn() togetherWith fadeOut() },
        label = "screen_transition"
      ) { screen ->
        when (screen) {
          is Screen.Home -> {
            HomeScreen(
              currentLanguage = currentLanguage,
              onLanguageChange = { viewModel.setLanguage(it) },
              onNavigate = { viewModel.navigateTo(it) },
              onProductClick = { product -> viewModel.openProductDetail(product) },
              onRequestQuoteForProduct = { product -> viewModel.startQuoteForProduct(product) },
              onExploreOrigin = { originName -> viewModel.filterByOrigin(originName) },
              quoteFormState = quoteFormState,
              onQuoteFormChange = { fn, cn, be, pw, co, bt, pi, aq, pr, msg ->
                viewModel.updateQuoteForm(fn, cn, be, pw, co, bt, pi, aq, pr, msg)
              },
              onQuoteSubmit = { viewModel.submitQuoteForm(context) },
              onQuoteReset = { viewModel.resetQuoteForm() },
              onWhatsAppClick = { viewModel.launchWhatsApp(context) }
            )
          }

          is Screen.Products -> {
            ProductsScreen(
              initialCategoryId = screen.categoryId,
              initialOrigin = screen.originFilter,
              currentLanguage = currentLanguage,
              onLanguageChange = { viewModel.setLanguage(it) },
              onProductClick = { product -> viewModel.openProductDetail(product) },
              onRequestQuote = { product -> viewModel.startQuoteForProduct(product) },
              onNavigate = { viewModel.navigateTo(it) },
              onWhatsAppClick = { viewModel.launchWhatsApp(context) }
            )
          }

          is Screen.ProductDetail -> {
            ProductDetailScreen(
              productId = screen.productId,
              onBack = { viewModel.navigateBack() },
              onRequestQuote = { product -> viewModel.startQuoteForProduct(product) },
              onWhatsAppInquiry = { product ->
                viewModel.launchWhatsApp(
                  context,
                  "Hello NUTURALS, I would like to enquire about ${product.name} (Grade: ${product.grade})."
                )
              },
              onNavigate = { viewModel.navigateTo(it) }
            )
          }

          is Screen.About -> {
            AboutScreen(
              onNavigate = { viewModel.navigateTo(it) },
              onRequestQuote = { viewModel.navigateTo(Screen.Contact) },
              onWhatsAppClick = { viewModel.launchWhatsApp(context) }
            )
          }

          is Screen.Quality -> {
            QualityScreen(
              onNavigate = { viewModel.navigateTo(it) },
              onRequestQuote = { viewModel.navigateTo(Screen.Contact) },
              onWhatsAppClick = { viewModel.launchWhatsApp(context) }
            )
          }

          is Screen.B2B -> {
            B2BScreen(
              onNavigate = { viewModel.navigateTo(it) },
              onRequestQuote = { viewModel.navigateTo(Screen.Contact) },
              onWhatsAppClick = { viewModel.launchWhatsApp(context) }
            )
          }

          is Screen.PrivateLabel -> {
            PrivateLabelScreen(
              onNavigate = { viewModel.navigateTo(it) },
              onRequestQuote = { viewModel.navigateTo(Screen.Contact) },
              onWhatsAppClick = { viewModel.launchWhatsApp(context) }
            )
          }

          is Screen.Export -> {
            ExportScreen(
              onNavigate = { viewModel.navigateTo(it) },
              onRequestQuote = { viewModel.navigateTo(Screen.Contact) },
              onWhatsAppClick = { viewModel.launchWhatsApp(context) }
            )
          }

          is Screen.Catalogue -> {
            CatalogueScreen(
              onNavigate = { viewModel.navigateTo(it) },
              onRequestPriceList = { viewModel.navigateTo(Screen.Contact) },
              onWhatsAppClick = { viewModel.launchWhatsApp(context) }
            )
          }

          is Screen.Contact -> {
            ContactScreen(
              onNavigate = { viewModel.navigateTo(it) },
              quoteFormState = quoteFormState,
              onQuoteFormChange = { fn, cn, be, pw, co, bt, pi, aq, pr, msg ->
                viewModel.updateQuoteForm(fn, cn, be, pw, co, bt, pi, aq, pr, msg)
              },
              onQuoteSubmit = { viewModel.submitQuoteForm(context) },
              onQuoteReset = { viewModel.resetQuoteForm() },
              onWhatsAppClick = { viewModel.launchWhatsApp(context) }
            )
          }

          is Screen.MyQuotes -> {
            MyQuotesScreen(
              enquiries = submittedEnquiries,
              onBack = { viewModel.navigateBack() },
              onNewQuoteClick = { viewModel.navigateTo(Screen.Contact) },
              onNavigate = { viewModel.navigateTo(it) },
              onWhatsAppClick = { viewModel.launchWhatsApp(context) }
            )
          }
        }
      }

      // Floating WhatsApp Enquiry Button (Accessible across all screens)
      WhatsAppFab(
        onClick = { viewModel.launchWhatsApp(context) },
        modifier = Modifier
          .align(Alignment.BottomEnd)
          .navigationBarsPadding()
          .padding(bottom = 16.dp, end = 16.dp)
      )
    }
  }
}
