package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.outlined.Description
import androidx.compose.material.icons.outlined.Download
import androidx.compose.material.icons.outlined.Public
import androidx.compose.material.icons.outlined.Security
import androidx.compose.material.icons.outlined.VerifiedUser
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.AppLanguage
import com.example.data.BrandConfig
import com.example.data.ProductRepository
import com.example.data.TranslationRepository
import com.example.model.Product
import com.example.model.ProductCategory
import com.example.ui.QuoteFormState
import com.example.ui.Screen
import com.example.ui.components.InteractiveWorldMap
import com.example.ui.components.NuturalsFooter
import com.example.ui.components.ProductArtCanvas
import com.example.ui.components.ProductCard
import com.example.ui.components.QuoteForm
import com.example.ui.components.SectionHeader
import com.example.ui.theme.BeigeBorder
import com.example.ui.theme.CardSurfaceLight
import com.example.ui.theme.Cream
import com.example.ui.theme.DarkCharcoalBody
import com.example.ui.theme.EditorialSerif
import com.example.ui.theme.ForestGreenDark
import com.example.ui.theme.ForestGreenPrimary
import com.example.ui.theme.MutedGold
import com.example.ui.theme.MutedGoldDark
import com.example.ui.theme.MutedGoldLight
import com.example.ui.theme.NaturalBeige
import androidx.compose.ui.text.font.FontFamily
import com.example.ui.components.NuturalsLogoMedallion
import com.example.ui.theme.ImperialGold
import com.example.ui.theme.ImperialGoldBright
import com.example.ui.theme.WalnutBackground
import com.example.ui.theme.WalnutDarkest
import com.example.ui.theme.WarmIvory
import com.example.ui.theme.WarmIvoryLight

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HomeScreen(
  currentLanguage: AppLanguage = AppLanguage.EN,
  onLanguageChange: (AppLanguage) -> Unit = {},
  onNavigate: (Screen) -> Unit,
  onProductClick: (Product) -> Unit,
  onRequestQuoteForProduct: (Product) -> Unit,
  onExploreOrigin: (String) -> Unit = {},
  quoteFormState: QuoteFormState,
  onQuoteFormChange: (
    fullName: String?,
    companyName: String?,
    businessEmail: String?,
    phoneWhatsApp: String?,
    country: String?,
    businessType: String?,
    productsInterestedIn: String?,
    approximateQuantity: String?,
    packagingRequirement: String?,
    message: String?
  ) -> Unit,
  onQuoteSubmit: () -> Unit,
  onQuoteReset: () -> Unit,
  onWhatsAppClick: () -> Unit,
  modifier: Modifier = Modifier
) {
  fun t(key: String): String = TranslationRepository.getString(key, currentLanguage)

  val featuredProducts = remember { ProductRepository.getFeaturedProducts().take(6) }
  val expandedFaqs = remember { mutableStateMapOf<Int, Boolean>() }

  LazyColumn(
    modifier = modifier
      .fillMaxSize()
      .background(WalnutBackground)
      .testTag("home_screen_lazy_column")
  ) {
    // ------------------------------------------------------------------------
    // 1. HERO SECTION
    // ------------------------------------------------------------------------
    item(key = "hero_section") {
      HeroSection(
        currentLanguage = currentLanguage,
        onExploreProducts = { onNavigate(Screen.Products()) },
        onRequestWholesaleQuote = { onNavigate(Screen.Contact) }
      )
    }

    // ------------------------------------------------------------------------
    // 2. PRODUCT CATEGORY SECTION
    // ------------------------------------------------------------------------
    item(key = "categories_section") {
      ProductCategoriesSection(
        currentLanguage = currentLanguage,
        onCategorySelected = { category ->
          onNavigate(Screen.Products(category.id))
        }
      )
    }

    // ------------------------------------------------------------------------
    // 3. FEATURED PRODUCTS
    // ------------------------------------------------------------------------
    item(key = "featured_products_header") {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 20.dp, vertical = 24.dp)
      ) {
        SectionHeader(
          eyebrow = "Curated Selection",
          title = t("featured_title"),
          subtitle = t("featured_sub")
        )
      }
    }

    items(featuredProducts, key = { "featured_${it.id}" }) { product ->
      Box(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 20.dp, vertical = 8.dp)
      ) {
        ProductCard(
          product = product,
          onCardClick = { onProductClick(product) },
          onRequestQuote = { onRequestQuoteForProduct(product) }
        )
      }
    }

    item(key = "view_all_products_cta") {
      Box(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 20.dp, vertical = 16.dp),
        contentAlignment = Alignment.Center
      ) {
        OutlinedButton(
          onClick = { onNavigate(Screen.Products()) },
          shape = RoundedCornerShape(2.dp),
          colors = ButtonDefaults.outlinedButtonColors(contentColor = ForestGreenDark),
          border = androidx.compose.foundation.BorderStroke(1.dp, ForestGreenDark),
          contentPadding = PaddingValues(horizontal = 24.dp, vertical = 12.dp)
        ) {
          Text(
            text = "VIEW COMPLETE CATALOGUE (15+ PRODUCTS) →",
            style = MaterialTheme.typography.labelMedium.copy(
              letterSpacing = 1.2.sp,
              fontWeight = FontWeight.Bold
            )
          )
        }
      }
    }

    // ------------------------------------------------------------------------
    // 4. WHY NUTURALS
    // ------------------------------------------------------------------------
    item(key = "why_nuturals_section") {
      WhyNuturalsSection(currentLanguage = currentLanguage)
    }

    // ------------------------------------------------------------------------
    // 5. ORIGINS / SOURCING (Interactive World Map)
    // ------------------------------------------------------------------------
    item(key = "origins_section") {
      OriginsSectionWithMap(
        currentLanguage = currentLanguage,
        onExploreOrigin = { originName ->
          onExploreOrigin(originName)
        },
        onExploreAllProducts = { onNavigate(Screen.Products()) }
      )
    }

    // ------------------------------------------------------------------------
    // 6. QUALITY JOURNEY
    // ------------------------------------------------------------------------
    item(key = "quality_journey_section") {
      QualityJourneySection(currentLanguage = currentLanguage)
    }

    // ------------------------------------------------------------------------
    // 7. B2B SECTION
    // ------------------------------------------------------------------------
    item(key = "b2b_section") {
      B2BSection(
        currentLanguage = currentLanguage,
        onBecomePartner = { onNavigate(Screen.Contact) }
      )
    }

    // ------------------------------------------------------------------------
    // 8. PRIVATE LABEL SECTION
    // ------------------------------------------------------------------------
    item(key = "private_label_section") {
      PrivateLabelSection(
        currentLanguage = currentLanguage,
        onStartPrivateLabel = { onNavigate(Screen.PrivateLabel) }
      )
    }

    // ------------------------------------------------------------------------
    // 9. EXPORT SECTION
    // ------------------------------------------------------------------------
    item(key = "export_section") {
      ExportSection(
        currentLanguage = currentLanguage,
        onExploreExport = { onNavigate(Screen.Export) }
      )
    }

    // ------------------------------------------------------------------------
    // 10. ABOUT NUTURALS
    // ------------------------------------------------------------------------
    item(key = "about_section") {
      AboutSummarySection(
        currentLanguage = currentLanguage,
        onReadMore = { onNavigate(Screen.About) }
      )
    }

    // ------------------------------------------------------------------------
    // 11. CATALOGUE SECTION
    // ------------------------------------------------------------------------
    item(key = "catalogue_section") {
      CatalogueCTASection(
        currentLanguage = currentLanguage,
        onDownloadCatalogue = { onNavigate(Screen.Catalogue) },
        onRequestPriceList = { onNavigate(Screen.Contact) }
      )
    }

    // ------------------------------------------------------------------------
    // 12. FAQ
    // ------------------------------------------------------------------------
    item(key = "faq_section") {
      FaqSection(
        currentLanguage = currentLanguage,
        expandedFaqs = expandedFaqs,
        onToggleFaq = { index ->
          expandedFaqs[index] = !(expandedFaqs[index] ?: false)
        }
      )
    }

    // ------------------------------------------------------------------------
    // 13. QUOTE / CONTACT FORM
    // ------------------------------------------------------------------------
    item(key = "quote_form_section") {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 20.dp, vertical = 24.dp)
      ) {
        QuoteForm(
          formState = quoteFormState,
          onFormChange = onQuoteFormChange,
          onSubmit = onQuoteSubmit,
          onReset = onQuoteReset
        )
      }
    }

    // ------------------------------------------------------------------------
    // 14. FOOTER
    // ------------------------------------------------------------------------
    item(key = "footer_section") {
      NuturalsFooter(
        onNavigate = onNavigate,
        onRequestQuote = { onNavigate(Screen.Contact) },
        onWhatsAppClick = onWhatsAppClick,
        currentLanguage = currentLanguage,
        onLanguageChange = onLanguageChange
      )
    }
  }
}

// ============================================================================
// SUB-SECTIONS IMPLEMENTATIONS WITH LOCALIZATION & INTERACTIVE MAP
// ============================================================================

@Composable
private fun HeroSection(
  currentLanguage: AppLanguage,
  onExploreProducts: () -> Unit,
  onRequestWholesaleQuote: () -> Unit
) {
  fun t(key: String): String = TranslationRepository.getString(key, currentLanguage)

  Box(
    modifier = Modifier
      .fillMaxWidth()
      .background(
        Brush.verticalGradient(
          colors = listOf(Color(0xFF261910), WalnutDarkest)
        )
      )
      .padding(horizontal = 20.dp, vertical = 28.dp)
  ) {
    Column(
      modifier = Modifier.fillMaxWidth(),
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      // Embossed Antique Gold Logo Medallion on Dark Walnut
      NuturalsLogoMedallion(
        size = 135.dp,
        showTitle = false
      )

      Spacer(modifier = Modifier.height(16.dp))

      Text(
        text = "NUTURALS",
        fontFamily = FontFamily.Serif,
        fontWeight = FontWeight.Bold,
        fontSize = 26.sp,
        letterSpacing = 5.sp,
        color = Color(0xFFFBF4DF)
      )

      Text(
        text = "ULTRA-PREMIUM RESERVE • EST. 2023",
        fontFamily = FontFamily.Serif,
        fontWeight = FontWeight.SemiBold,
        fontSize = 11.5.sp,
        letterSpacing = 2.5.sp,
        color = ImperialGoldBright,
        modifier = Modifier.padding(top = 4.dp)
      )

      Text(
        text = "Hand-harvested from elite micro-climates exclusively for connoisseurs.",
        fontFamily = FontFamily.Serif,
        style = MaterialTheme.typography.bodyMedium.copy(
          color = Color(0xFFC7B9A5),
          fontSize = 13.5.sp,
          lineHeight = 20.sp
        ),
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(top = 10.dp, start = 12.dp, end = 12.dp)
      )

      Spacer(modifier = Modifier.height(20.dp))

      // CTAs
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
      ) {
        Button(
          onClick = onExploreProducts,
          colors = ButtonDefaults.buttonColors(
            containerColor = ImperialGold,
            contentColor = WalnutDarkest
          ),
          shape = RoundedCornerShape(2.dp),
          contentPadding = PaddingValues(horizontal = 16.dp, vertical = 13.dp),
          modifier = Modifier.weight(1f)
        ) {
          Text(
            text = "Explore Catalogue",
            style = MaterialTheme.typography.labelLarge.copy(
              fontSize = 12.5.sp,
              fontWeight = FontWeight.Bold,
              color = WalnutDarkest
            )
          )
        }

        OutlinedButton(
          onClick = onRequestWholesaleQuote,
          shape = RoundedCornerShape(2.dp),
          colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFFFBF4DF)),
          border = androidx.compose.foundation.BorderStroke(1.dp, ImperialGold),
          contentPadding = PaddingValues(horizontal = 14.dp, vertical = 13.dp),
          modifier = Modifier.weight(1f)
        ) {
          Text(
            text = "VIP Allocation RFQ",
            style = MaterialTheme.typography.labelLarge.copy(
              fontSize = 12.5.sp,
              fontWeight = FontWeight.SemiBold,
              color = Color(0xFFFBF4DF)
            )
          )
        }
      }

      Spacer(modifier = Modifier.height(22.dp))

      // Trust Indicators
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .background(Color(0xFF1E130B), RoundedCornerShape(2.dp))
          .border(0.8.dp, Color(0xFF4A3422), RoundedCornerShape(2.dp))
          .padding(vertical = 12.dp, horizontal = 8.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
      ) {
        TrustBadgeItem(icon = Icons.Outlined.Security, title = t("trust_sourcing"))
        Box(modifier = Modifier.size(1.dp, 24.dp).background(Color(0xFF4A3422)))
        TrustBadgeItem(icon = Icons.Outlined.VerifiedUser, title = t("trust_quality"))
        Box(modifier = Modifier.size(1.dp, 24.dp).background(Color(0xFF4A3422)))
        TrustBadgeItem(icon = Icons.Outlined.Public, title = t("trust_export"))
      }
    }
  }
}

@Composable
private fun TrustBadgeItem(icon: androidx.compose.ui.graphics.vector.ImageVector, title: String) {
  Row(verticalAlignment = Alignment.CenterVertically) {
    Icon(icon, contentDescription = null, tint = ImperialGold, modifier = Modifier.size(16.dp))
    Spacer(modifier = Modifier.width(6.dp))
    Text(
      text = title,
      style = MaterialTheme.typography.labelSmall.copy(
        fontSize = 11.sp,
        fontWeight = FontWeight.SemiBold,
        color = Color(0xFFFBF4DF)
      )
    )
  }
}

@Composable
private fun ProductCategoriesSection(
  currentLanguage: AppLanguage,
  onCategorySelected: (ProductCategory) -> Unit
) {
  fun t(key: String): String = TranslationRepository.getString(key, currentLanguage)

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = 20.dp, vertical = 24.dp)
  ) {
    SectionHeader(
      eyebrow = "Categorized Sourcing",
      title = t("cat_title"),
      subtitle = t("cat_sub")
    )

    Spacer(modifier = Modifier.height(18.dp))

    val categories = listOf(
      Triple("01", ProductCategory.NUTS, "almond"),
      Triple("02", ProductCategory.DRIED_FRUITS, "date"),
      Triple("03", ProductCategory.SEEDS_SUPERFOODS, "makhana"),
      Triple("04", ProductCategory.SPECIALTY, "cashew")
    )

    categories.forEach { (number, category, iconType) ->
      CategoryLargeCard(
        number = number,
        category = category,
        iconType = iconType,
        onClick = { onCategorySelected(category) }
      )
      Spacer(modifier = Modifier.height(12.dp))
    }
  }
}

@Composable
private fun CategoryLargeCard(
  number: String,
  category: ProductCategory,
  iconType: String,
  onClick: () -> Unit
) {
  Card(
    modifier = Modifier
      .fillMaxWidth()
      .clip(RoundedCornerShape(3.dp))
      .border(0.8.dp, BeigeBorder, RoundedCornerShape(3.dp))
      .clickable { onClick() }
      .testTag("category_card_${category.id}"),
    colors = CardDefaults.cardColors(containerColor = CardSurfaceLight),
    elevation = CardDefaults.cardElevation(0.5.dp)
  ) {
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(14.dp),
      verticalAlignment = Alignment.CenterVertically
    ) {
      Box(
        modifier = Modifier
          .size(88.dp)
          .clip(RoundedCornerShape(2.dp))
          .border(0.8.dp, BeigeBorder, RoundedCornerShape(2.dp))
      ) {
        ProductArtCanvas(
          iconType = iconType,
          modifier = Modifier.fillMaxSize(),
          backgroundColor = Cream
        )
      }

      Spacer(modifier = Modifier.width(14.dp))

      Column(modifier = Modifier.weight(1f)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
          Text(
            text = number,
            style = MaterialTheme.typography.labelSmall.copy(
              color = MutedGoldDark,
              fontWeight = FontWeight.Bold,
              fontSize = 11.sp,
              letterSpacing = 1.sp
            )
          )
          Spacer(modifier = Modifier.width(8.dp))
          Text(
            text = category.displayName.uppercase(),
            style = MaterialTheme.typography.titleMedium.copy(
              fontFamily = EditorialSerif,
              fontWeight = FontWeight.Bold,
              fontSize = 17.sp,
              letterSpacing = 1.sp,
              color = ForestGreenDark
            )
          )
        }

        Spacer(modifier = Modifier.height(4.dp))

        Text(
          text = category.subtitle,
          style = MaterialTheme.typography.bodySmall.copy(
            color = DarkCharcoalBody.copy(alpha = 0.8f),
            fontSize = 12.sp,
            lineHeight = 17.sp
          )
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
          text = "Explore Collection →",
          style = MaterialTheme.typography.labelMedium.copy(
            color = ForestGreenPrimary,
            fontWeight = FontWeight.SemiBold,
            fontSize = 12.sp
          )
        )
      }
    }
  }
}

@Composable
private fun WhyNuturalsSection(currentLanguage: AppLanguage) {
  fun t(key: String): String = TranslationRepository.getString(key, currentLanguage)

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .background(Cream)
      .padding(horizontal = 20.dp, vertical = 32.dp)
  ) {
    SectionHeader(
      eyebrow = "Why NUTURALS",
      title = t("why_title"),
      subtitle = t("why_sub")
    )

    Spacer(modifier = Modifier.height(20.dp))

    val pillars = listOf(
      Pillar("01", "Carefully Sourced", "Products selected through trusted sourcing relationships and defined specifications across leading origins."),
      Pillar("02", "Quality Focused", "Attention to product quality, sizing consistency, moisture thresholds and premium presentation."),
      Pillar("03", "Reliable Supply", "Built around dependable fulfilment schedules and long-term business volume requirements."),
      Pillar("04", "Long-Term Partnerships", "We aim to build lasting relationships with customers, distributors and business partners worldwide.")
    )

    pillars.forEach { pillar ->
      Surface(
        modifier = Modifier
          .fillMaxWidth()
          .padding(vertical = 6.dp)
          .border(0.8.dp, BeigeBorder, RoundedCornerShape(2.dp)),
        color = WarmIvoryLight
      ) {
        Row(
          modifier = Modifier.padding(16.dp),
          verticalAlignment = Alignment.Top
        ) {
          Text(
            text = pillar.number,
            style = MaterialTheme.typography.titleMedium.copy(
              fontFamily = EditorialSerif,
              color = MutedGoldDark,
              fontWeight = FontWeight.Bold,
              fontSize = 18.sp
            )
          )
          Spacer(modifier = Modifier.width(16.dp))
          Column {
            Text(
              text = pillar.title,
              style = MaterialTheme.typography.titleMedium.copy(
                fontFamily = EditorialSerif,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = ForestGreenDark
              )
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
              text = pillar.description,
              style = MaterialTheme.typography.bodySmall.copy(
                color = DarkCharcoalBody,
                fontSize = 13.sp,
                lineHeight = 19.sp
              )
            )
          }
        }
      }
    }
  }
}

private data class Pillar(val number: String, val title: String, val description: String)

/**
 * Enhanced Origins Section featuring the Interactive World Map
 */
@Composable
private fun OriginsSectionWithMap(
  currentLanguage: AppLanguage,
  onExploreOrigin: (String) -> Unit,
  onExploreAllProducts: () -> Unit
) {
  fun t(key: String): String = TranslationRepository.getString(key, currentLanguage)

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = 20.dp, vertical = 32.dp)
  ) {
    SectionHeader(
      eyebrow = "Global Footprint",
      title = t("origins_title"),
      subtitle = t("origins_sub")
    )

    Spacer(modifier = Modifier.height(18.dp))

    // Interactive World Map Component
    InteractiveWorldMap(
      onOriginSelected = { pin ->
        // user clicked pin
      },
      onExploreProductsFromOrigin = { pin ->
        val queryOrigin = when (pin.id) {
          "usa" -> "USA"
          "india" -> "India"
          "middle-east" -> "Middle East"
          "turkey" -> "Turkey"
          "afghanistan" -> "Afghanistan"
          "chile" -> "Chile"
          else -> pin.name.split(" ").first()
        }
        onExploreOrigin(queryOrigin)
      }
    )

    Spacer(modifier = Modifier.height(14.dp))

    OutlinedButton(
      onClick = onExploreAllProducts,
      shape = RoundedCornerShape(2.dp),
      colors = ButtonDefaults.outlinedButtonColors(contentColor = ForestGreenDark),
      border = androidx.compose.foundation.BorderStroke(1.dp, ForestGreenPrimary),
      modifier = Modifier.fillMaxWidth()
    ) {
      Text(t("cta_explore_products"), color = ForestGreenDark)
    }
  }
}

@Composable
private fun QualityJourneySection(currentLanguage: AppLanguage) {
  fun t(key: String): String = TranslationRepository.getString(key, currentLanguage)

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .background(ForestGreenDark)
      .padding(horizontal = 20.dp, vertical = 32.dp)
  ) {
    SectionHeader(
      eyebrow = "Rigorous Standards",
      title = t("quality_title"),
      subtitle = t("quality_sub"),
      textColor = WarmIvory,
      accentColor = MutedGold
    )

    Spacer(modifier = Modifier.height(20.dp))

    BrandConfig.QUALITY_STEPS.forEachIndexed { index, step ->
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .padding(vertical = 8.dp),
        verticalAlignment = Alignment.Top
      ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
          Box(
            modifier = Modifier
              .size(36.dp)
              .clip(CircleShape)
              .background(MutedGoldDark),
            contentAlignment = Alignment.Center
          ) {
            Text(
              text = step.number,
              style = MaterialTheme.typography.labelMedium.copy(
                color = ForestGreenDark,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp
              )
            )
          }

          if (index < BrandConfig.QUALITY_STEPS.size - 1) {
            Box(
              modifier = Modifier
                .width(1.5.dp)
                .height(44.dp)
                .background(MutedGold.copy(alpha = 0.35f))
            )
          }
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column {
          Text(
            text = step.title,
            style = MaterialTheme.typography.titleMedium.copy(
              fontFamily = EditorialSerif,
              fontWeight = FontWeight.Bold,
              color = WarmIvory,
              fontSize = 16.sp,
              letterSpacing = 1.sp
            )
          )
          Spacer(modifier = Modifier.height(4.dp))
          Text(
            text = step.description,
            style = MaterialTheme.typography.bodySmall.copy(
              color = Color(0xFFC0CEC5),
              fontSize = 13.sp,
              lineHeight = 19.sp
            )
          )
        }
      }
    }
  }
}

@Composable
private fun B2BSection(
  currentLanguage: AppLanguage,
  onBecomePartner: () -> Unit
) {
  fun t(key: String): String = TranslationRepository.getString(key, currentLanguage)

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = 20.dp, vertical = 32.dp)
  ) {
    SectionHeader(
      eyebrow = "Commercial Solutions",
      title = t("b2b_title"),
      subtitle = t("b2b_sub")
    )

    Spacer(modifier = Modifier.height(18.dp))

    BrandConfig.B2B_AUDIENCES.forEach { audience ->
      Card(
        modifier = Modifier
          .fillMaxWidth()
          .padding(vertical = 5.dp)
          .border(0.8.dp, BeigeBorder, RoundedCornerShape(2.dp)),
        colors = CardDefaults.cardColors(containerColor = CardSurfaceLight)
      ) {
        Column(modifier = Modifier.padding(14.dp)) {
          Text(
            text = audience.title,
            style = MaterialTheme.typography.titleMedium.copy(
              fontFamily = EditorialSerif,
              fontWeight = FontWeight.Bold,
              color = ForestGreenDark,
              letterSpacing = 1.sp,
              fontSize = 15.sp
            )
          )
          Text(
            text = audience.tagline,
            style = MaterialTheme.typography.labelSmall.copy(
              color = MutedGoldDark,
              fontSize = 11.sp,
              fontWeight = FontWeight.Medium
            )
          )
          Spacer(modifier = Modifier.height(4.dp))
          Text(
            text = audience.description,
            style = MaterialTheme.typography.bodySmall.copy(
              color = DarkCharcoalBody.copy(alpha = 0.85f),
              fontSize = 12.5.sp,
              lineHeight = 18.sp
            )
          )
        }
      }
    }

    Spacer(modifier = Modifier.height(14.dp))

    Button(
      onClick = onBecomePartner,
      colors = ButtonDefaults.buttonColors(containerColor = ForestGreenPrimary),
      shape = RoundedCornerShape(2.dp),
      modifier = Modifier.fillMaxWidth()
    ) {
      Text("Become a NUTURALS Partner", color = Color.White, letterSpacing = 0.5.sp)
    }
  }
}

@Composable
private fun PrivateLabelSection(
  currentLanguage: AppLanguage,
  onStartPrivateLabel: () -> Unit
) {
  fun t(key: String): String = TranslationRepository.getString(key, currentLanguage)

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .background(Cream)
      .padding(horizontal = 20.dp, vertical = 32.dp)
  ) {
    Box(
      modifier = Modifier
        .background(ForestGreenDark, RoundedCornerShape(2.dp))
        .padding(horizontal = 10.dp, vertical = 4.dp)
    ) {
      Text(
        text = t("pl_badge"),
        style = MaterialTheme.typography.labelSmall.copy(
          color = MutedGoldLight,
          fontSize = 10.sp,
          letterSpacing = 1.5.sp,
          fontWeight = FontWeight.Bold
        )
      )
    }

    Spacer(modifier = Modifier.height(12.dp))

    SectionHeader(
      title = t("pl_title"),
      subtitle = t("pl_sub")
    )

    Spacer(modifier = Modifier.height(18.dp))

    Row(
      modifier = Modifier
        .fillMaxWidth()
        .background(WarmIvoryLight, RoundedCornerShape(2.dp))
        .border(0.8.dp, BeigeBorder, RoundedCornerShape(2.dp))
        .padding(vertical = 12.dp, horizontal = 6.dp),
      horizontalArrangement = Arrangement.SpaceAround,
      verticalAlignment = Alignment.CenterVertically
    ) {
      FlowStep("SOURCE")
      Text("→", color = MutedGoldDark, fontSize = 12.sp)
      FlowStep("SELECT")
      Text("→", color = MutedGoldDark, fontSize = 12.sp)
      FlowStep("PACK")
      Text("→", color = MutedGoldDark, fontSize = 12.sp)
      FlowStep("YOUR BRAND")
      Text("→", color = MutedGoldDark, fontSize = 12.sp)
      FlowStep("YOUR MARKET")
    }

    Spacer(modifier = Modifier.height(18.dp))

    val plFeatures = listOf(
      "Custom Packaging Solutions (Pouches, Jars, Tins)",
      "Private Label Branding Consultation",
      "Bulk Supply & Commodity Ingredients",
      "Calibrated Product Selection",
      "Long-term Business Support"
    )

    plFeatures.forEach { feat ->
      Row(
        modifier = Modifier.padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
      ) {
        Icon(Icons.Default.Check, contentDescription = null, tint = ForestGreenPrimary, modifier = Modifier.size(16.dp))
        Spacer(modifier = Modifier.width(8.dp))
        Text(feat, style = MaterialTheme.typography.bodySmall.copy(color = DarkCharcoalBody, fontSize = 13.sp))
      }
    }

    Spacer(modifier = Modifier.height(16.dp))

    Button(
      onClick = onStartPrivateLabel,
      colors = ButtonDefaults.buttonColors(containerColor = ForestGreenPrimary),
      shape = RoundedCornerShape(2.dp),
      modifier = Modifier.fillMaxWidth()
    ) {
      Text("Start a Private Label Project", color = Color.White, letterSpacing = 0.5.sp)
    }
  }
}

@Composable
private fun FlowStep(text: String) {
  Text(
    text = text,
    style = MaterialTheme.typography.labelSmall.copy(
      fontSize = 9.sp,
      fontWeight = FontWeight.Bold,
      color = ForestGreenDark,
      letterSpacing = 0.5.sp
    ),
    textAlign = TextAlign.Center
  )
}

@Composable
private fun ExportSection(
  currentLanguage: AppLanguage,
  onExploreExport: () -> Unit
) {
  fun t(key: String): String = TranslationRepository.getString(key, currentLanguage)

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = 20.dp, vertical = 32.dp)
  ) {
    SectionHeader(
      eyebrow = "International Trade",
      title = t("export_title"),
      subtitle = t("export_sub")
    )

    Spacer(modifier = Modifier.height(16.dp))

    val exportCapabilities = listOf(
      "Global Sourcing Networks with verified agricultural aggregators",
      "Export Documentation and phytosanitary certificate coordination",
      "Flexible Packaging from 10kg/25kg bulk bags to retail carton packs",
      "Bulk Supply contracts with containerized load planning",
      "International Logistics Support and port handling guidance"
    )

    exportCapabilities.forEach { cap ->
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .padding(vertical = 6.dp)
          .background(NaturalBeige.copy(alpha = 0.35f), RoundedCornerShape(2.dp))
          .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
      ) {
        Icon(Icons.Outlined.Public, contentDescription = null, tint = MutedGoldDark, modifier = Modifier.size(18.dp))
        Spacer(modifier = Modifier.width(10.dp))
        Text(cap, style = MaterialTheme.typography.bodySmall.copy(color = DarkCharcoalBody, fontSize = 13.sp))
      }
    }

    Spacer(modifier = Modifier.height(14.dp))

    OutlinedButton(
      onClick = onExploreExport,
      shape = RoundedCornerShape(2.dp),
      colors = ButtonDefaults.outlinedButtonColors(contentColor = ForestGreenDark),
      border = androidx.compose.foundation.BorderStroke(1.dp, ForestGreenPrimary),
      modifier = Modifier.fillMaxWidth()
    ) {
      Text("Learn More About Export Capabilities", color = ForestGreenDark)
    }
  }
}

@Composable
private fun AboutSummarySection(
  currentLanguage: AppLanguage,
  onReadMore: () -> Unit
) {
  fun t(key: String): String = TranslationRepository.getString(key, currentLanguage)

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .background(WarmIvoryLight)
      .padding(horizontal = 20.dp, vertical = 32.dp)
  ) {
    SectionHeader(
      eyebrow = "About NUTURALS",
      title = t("about_title"),
      subtitle = null
    )

    Spacer(modifier = Modifier.height(14.dp))

    Text(
      text = "NUTURALS is built around a simple idea: bringing carefully selected natural foods to customers who value quality, consistency and dependable supply.",
      style = MaterialTheme.typography.bodyLarge.copy(
        fontFamily = EditorialSerif,
        color = ForestGreenDark,
        fontSize = 16.sp,
        lineHeight = 24.sp
      )
    )

    Spacer(modifier = Modifier.height(10.dp))

    Text(
      text = "We work to connect trusted sourcing with modern markets — from wholesalers and distributors to retailers and food businesses. Every batch is measured against explicit physical and microbiological benchmarks.",
      style = MaterialTheme.typography.bodyMedium.copy(
        color = DarkCharcoalBody,
        fontSize = 14.sp,
        lineHeight = 22.sp
      )
    )

    Spacer(modifier = Modifier.height(16.dp))

    Text(
      text = "Read Full Brand Story →",
      style = MaterialTheme.typography.labelLarge.copy(
        color = MutedGoldDark,
        fontWeight = FontWeight.Bold,
        fontSize = 13.sp
      ),
      modifier = Modifier.clickable { onReadMore() }
    )
  }
}

@Composable
private fun CatalogueCTASection(
  currentLanguage: AppLanguage,
  onDownloadCatalogue: () -> Unit,
  onRequestPriceList: () -> Unit
) {
  fun t(key: String): String = TranslationRepository.getString(key, currentLanguage)

  Card(
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = 20.dp, vertical = 24.dp)
      .border(1.dp, MutedGold.copy(alpha = 0.5f), RoundedCornerShape(2.dp)),
    colors = CardDefaults.cardColors(containerColor = Cream)
  ) {
    Column(
      modifier = Modifier.padding(20.dp),
      horizontalAlignment = Alignment.Start
    ) {
      Icon(Icons.Outlined.Description, contentDescription = null, tint = ForestGreenPrimary, modifier = Modifier.size(28.dp))
      Spacer(modifier = Modifier.height(10.dp))

      Text(
        text = t("cat_sec_title"),
        style = MaterialTheme.typography.headlineSmall.copy(
          fontFamily = EditorialSerif,
          fontWeight = FontWeight.Normal,
          color = ForestGreenDark,
          fontSize = 20.sp
        )
      )

      Spacer(modifier = Modifier.height(6.dp))

      Text(
        text = t("cat_sec_sub"),
        style = MaterialTheme.typography.bodySmall.copy(
          color = DarkCharcoalBody,
          fontSize = 13.sp,
          lineHeight = 19.sp
        )
      )

      Spacer(modifier = Modifier.height(16.dp))

      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
      ) {
        Button(
          onClick = onDownloadCatalogue,
          colors = ButtonDefaults.buttonColors(containerColor = ForestGreenPrimary),
          shape = RoundedCornerShape(2.dp),
          contentPadding = PaddingValues(horizontal = 12.dp, vertical = 10.dp),
          modifier = Modifier.weight(1f)
        ) {
          Icon(Icons.Outlined.Download, contentDescription = null, tint = Color.White, modifier = Modifier.size(16.dp))
          Spacer(modifier = Modifier.width(6.dp))
          Text(t("cta_download_cat"), fontSize = 11.5.sp, color = Color.White)
        }

        OutlinedButton(
          onClick = onRequestPriceList,
          shape = RoundedCornerShape(2.dp),
          colors = ButtonDefaults.outlinedButtonColors(contentColor = ForestGreenDark),
          border = androidx.compose.foundation.BorderStroke(1.dp, ForestGreenPrimary),
          contentPadding = PaddingValues(horizontal = 12.dp, vertical = 10.dp),
          modifier = Modifier.weight(1.1f)
        ) {
          Text(t("cta_price_list"), fontSize = 11.5.sp, color = ForestGreenDark)
        }
      }
    }
  }
}

@Composable
private fun FaqSection(
  currentLanguage: AppLanguage,
  expandedFaqs: Map<Int, Boolean>,
  onToggleFaq: (Int) -> Unit
) {
  fun t(key: String): String = TranslationRepository.getString(key, currentLanguage)

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = 20.dp, vertical = 24.dp)
  ) {
    SectionHeader(
      eyebrow = "Trade FAQ",
      title = t("faq_title"),
      subtitle = t("faq_sub")
    )

    Spacer(modifier = Modifier.height(16.dp))

    BrandConfig.FAQ_ITEMS.forEachIndexed { index, faq ->
      val isExpanded = expandedFaqs[index] ?: false
      Card(
        modifier = Modifier
          .fillMaxWidth()
          .padding(vertical = 4.dp)
          .border(0.8.dp, BeigeBorder, RoundedCornerShape(2.dp))
          .clickable { onToggleFaq(index) },
        colors = CardDefaults.cardColors(containerColor = CardSurfaceLight)
      ) {
        Column(modifier = Modifier.padding(14.dp)) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Text(
              text = faq.question,
              style = MaterialTheme.typography.titleSmall.copy(
                fontFamily = EditorialSerif,
                fontWeight = FontWeight.SemiBold,
                color = ForestGreenDark,
                fontSize = 14.sp
              ),
              modifier = Modifier.weight(1f)
            )
            Icon(
              imageVector = if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
              contentDescription = if (isExpanded) "Collapse" else "Expand",
              tint = MutedGoldDark
            )
          }

          AnimatedVisibility(visible = isExpanded) {
            Column {
              Spacer(modifier = Modifier.height(8.dp))
              HorizontalDivider(color = BeigeBorder.copy(alpha = 0.5f), thickness = 0.5.dp)
              Spacer(modifier = Modifier.height(8.dp))
              Text(
                text = faq.answer,
                style = MaterialTheme.typography.bodySmall.copy(
                  color = DarkCharcoalBody,
                  fontSize = 12.5.sp,
                  lineHeight = 18.sp
                )
              )
            }
          }
        }
      }
    }
  }
}
