package com.example.ui.screens

import android.widget.Toast
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Chat
import androidx.compose.material.icons.outlined.Download
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.BrandConfig
import com.example.data.ProductRepository
import com.example.model.Product
import com.example.model.ProductCategory
import com.example.ui.Screen
import com.example.ui.components.NuturalsFooter
import com.example.ui.components.NuturalsLogoMedallion
import com.example.ui.components.ProductArtCanvas
import com.example.ui.theme.DarkCharcoal
import com.example.ui.theme.EditorialSerif
import com.example.ui.theme.ImperialGold
import com.example.ui.theme.ImperialGoldBright
import com.example.ui.theme.ImperialGoldLight
import com.example.ui.theme.IvoryWarm
import com.example.ui.theme.WalnutBackground
import com.example.ui.theme.WalnutBorder
import com.example.ui.theme.WalnutDarkest
import com.example.ui.theme.WalnutSurface
import com.example.ui.theme.WalnutSurfaceVariant

@Composable
fun CatalogueScreen(
  onNavigate: (Screen) -> Unit,
  onRequestPriceList: () -> Unit,
  onWhatsAppClick: () -> Unit,
  onProductClick: (Product) -> Unit = {},
  modifier: Modifier = Modifier
) {
  val context = LocalContext.current
  var selectedPageIndex by remember { mutableIntStateOf(0) }

  val cataloguePages = listOf(
    CataloguePageData(
      pageNumber = 1,
      tome = "TOME I",
      title = "IMPERIAL NUTS & RARE DRY FRUITS",
      sanctuary = "THE IMPERIAL CROWN COLLECTION",
      sanctuarySubtitle = "Hand-selected from imperial Persian reserves and ancient Sicilian volcanic groves.",
      footerLatin = "❦  ❖  Habsburg • Sovereign Reserve  ❖  ❦",
      sections = listOf(
        CatalogueSectionData(
          sectionName = "SOVEREIGN TREE NUTS",
          productIds = listOf("california-almonds", "bronte-pistachios", "vintage-macadamias", "royal-porcelain-walnuts")
        ),
        CatalogueSectionData(
          sectionName = "IMPERIAL DRY FRUIT COLLECTION",
          productIds = listOf("24k-gold-medjool-dates", "muscat-aged-figs", "monukkha-green-raisins")
        )
      )
    ),
    CataloguePageData(
      pageNumber = 2,
      tome = "TOME II",
      title = "RARE CONNOISSEUR SEEDS",
      sanctuary = "THE IMPERIAL BOTANICAL SANCTUARY",
      sanctuarySubtitle = "Precious heirloom seeds infused with white truffles, wild rosehip, and rare spices.",
      footerLatin = "❦  ❖  Hermitage • Botanical Sanctuary  ❖  ❦",
      sections = listOf(
        CatalogueSectionData(
          sectionName = "SOVEREIGN BOTANICAL SEEDS",
          productIds = listOf("white-truffle-pumpkin-seeds", "imperial-jet-black-chia", "golden-flax-reserve", "ivory-hemp-hearts")
        ),
        CatalogueSectionData(
          sectionName = "IMPERIAL INFUSED SEED BLENDS",
          productIds = listOf("sargol-saffron-sunflower", "malabar-cardamom-seeds")
        )
      )
    ),
    CataloguePageData(
      pageNumber = 3,
      tome = "TOME III",
      title = "ARTISAN FLAVORED NUTS",
      sanctuary = "THE IMPERIAL SPICE MASTERPIECES",
      sanctuarySubtitle = "Masterfully seasoned with Piedmont white truffles, Cognac oak smoke, and Sargol saffron.",
      footerLatin = "❦  ❖  Venezia • Spice Masterpiece  ❖  ❦",
      sections = listOf(
        CatalogueSectionData(
          sectionName = "SOVEREIGN SEASONED RESERVE",
          productIds = listOf("truffle-salt-cashews", "pink-salt-bergamot-pistachios", "cinnamon-pecans", "smoked-rosemary-almonds")
        ),
        CatalogueSectionData(
          sectionName = "IMPERIAL SPICE MASTERWORKS",
          productIds = listOf("saffron-macadamias", "aleppo-chili-cashews")
        )
      )
    ),
    CataloguePageData(
      pageNumber = 4,
      tome = "TOME IV",
      title = "HAUTE CONFECTION & BARS",
      sanctuary = "THE IMPERIAL HAUTE CONFECTIONERY",
      sanctuarySubtitle = "Single-origin Venezuelan Criollo cacao and elite performance nutrition slabs.",
      footerLatin = "❦  ❖  Versailles • Haute Confection  ❖  ❦",
      sections = listOf(
        CatalogueSectionData(
          sectionName = "IMPERIAL CONFECTIONS",
          productIds = listOf("criollo-gold-bark", "macadamia-praline-truffles")
        ),
        CatalogueSectionData(
          sectionName = "SOVEREIGN PERFORMANCE SLABS",
          productIds = listOf("mamra-almond-protein-slab", "bronte-pistachio-protein-slab")
        ),
        CatalogueSectionData(
          sectionName = "SIGNATURE PRESENTATION CHESTS & MEMBERSHIP",
          productIds = listOf("sovereign-wooden-chest", "annual-reserve-pass")
        )
      )
    )
  )

  LazyColumn(
    modifier = modifier
      .fillMaxSize()
      .background(WalnutDarkest)
      .testTag("catalogue_screen")
  ) {
    // -------------------------------------------------------------
    // TOP LUXURY HERO BANNER WITH EMBOSSED MEDALLION
    // -------------------------------------------------------------
    item(key = "catalogue_hero_medallion") {
      Box(
        modifier = Modifier
          .fillMaxWidth()
          .background(
            Brush.verticalGradient(
              colors = listOf(Color(0xFF1C130D), WalnutDarkest)
            )
          )
          .padding(top = 28.dp, bottom = 20.dp, start = 16.dp, end = 16.dp),
        contentAlignment = Alignment.Center
      ) {
        Column(
          horizontalAlignment = Alignment.CenterHorizontally,
          modifier = Modifier.fillMaxWidth()
        ) {
          // Central Embossed Medallion
          NuturalsLogoMedallion(
            size = 110.dp,
            showTitle = false
          )

          Spacer(modifier = Modifier.height(14.dp))

          Text(
            text = "NUTURALS IMPERIAL",
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            letterSpacing = 5.sp,
            color = Color(0xFFFBF4DF)
          )

          Text(
            text = "SOVEREIGN RESERVE • OFFICIAL CATALOGUE",
            fontFamily = FontFamily.Serif,
            fontSize = 11.sp,
            letterSpacing = 2.5.sp,
            fontWeight = FontWeight.Medium,
            color = ImperialGoldBright,
            modifier = Modifier.padding(top = 4.dp)
          )

          Text(
            text = "Hand-harvested from elite micro-climates exclusively for connoisseurs.",
            fontFamily = FontFamily.Serif,
            fontSize = 12.sp,
            color = Color(0xFFC7B9A5),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 6.dp, start = 16.dp, end = 16.dp)
          )

          Spacer(modifier = Modifier.height(16.dp))

          // Concierge Quick Action Strip
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
          ) {
            Button(
              onClick = {
                Toast.makeText(
                  context,
                  "NUTURALS Sovereign Reserve Master Folio will download directly to your device.",
                  Toast.LENGTH_LONG
                ).show()
              },
              colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF2C1E14),
                contentColor = ImperialGoldBright
              ),
              shape = RoundedCornerShape(2.dp),
              modifier = Modifier
                .weight(1f)
                .border(0.8.dp, ImperialGold, RoundedCornerShape(2.dp))
            ) {
              Icon(Icons.Outlined.Download, contentDescription = null, tint = ImperialGold, modifier = Modifier.size(15.dp))
              Spacer(modifier = Modifier.width(6.dp))
              Text("Download Folio", fontSize = 11.sp, color = ImperialGoldBright)
            }

            Button(
              onClick = onWhatsAppClick,
              colors = ButtonDefaults.buttonColors(
                containerColor = ImperialGold,
                contentColor = WalnutDarkest
              ),
              shape = RoundedCornerShape(2.dp),
              modifier = Modifier.weight(1f)
            ) {
              Icon(Icons.Outlined.Chat, contentDescription = null, tint = WalnutDarkest, modifier = Modifier.size(15.dp))
              Spacer(modifier = Modifier.width(6.dp))
              Text("Concierge WhatsApp", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = WalnutDarkest)
            }
          }
        }
      }
    }

    // -------------------------------------------------------------
    // TOME / PAGE TABS (PAGES 1 TO 4)
    // -------------------------------------------------------------
    item(key = "catalogue_page_tabs") {
      ScrollableTabRow(
        selectedTabIndex = selectedPageIndex,
        containerColor = Color(0xFF140D08),
        contentColor = ImperialGoldBright,
        edgePadding = 12.dp,
        indicator = { tabPositions ->
          TabRowDefaults.SecondaryIndicator(
            modifier = Modifier.tabIndicatorOffset(tabPositions[selectedPageIndex]),
            color = ImperialGold,
            height = 2.5.dp
          )
        },
        divider = {
          Box(
            modifier = Modifier
              .fillMaxWidth()
              .height(1.dp)
              .background(Color(0xFF382618))
          )
        }
      ) {
        cataloguePages.forEachIndexed { index, page ->
          Tab(
            selected = selectedPageIndex == index,
            onClick = { selectedPageIndex = index },
            text = {
              Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                  text = "PAGE ${page.pageNumber}",
                  fontFamily = FontFamily.Serif,
                  fontWeight = FontWeight.Bold,
                  fontSize = 11.sp,
                  letterSpacing = 1.sp,
                  color = if (selectedPageIndex == index) ImperialGoldBright else Color(0xFF8F806E)
                )
                Text(
                  text = page.tome,
                  fontSize = 9.sp,
                  color = if (selectedPageIndex == index) Color(0xFFFBF4DF) else Color(0xFF6B5845)
                )
              }
            }
          )
        }
      }
    }

    // -------------------------------------------------------------
    // CURRENT TOME / CATALOGUE PAGE VIEW
    // -------------------------------------------------------------
    item(key = "catalogue_active_page_${selectedPageIndex}") {
      val currentPage = cataloguePages[selectedPageIndex]

      Column(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 14.dp, vertical = 20.dp)
      ) {
        // Imperial Header Frame matching PDF Screenshot
        Box(
          modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color(0xFF5A412A), RoundedCornerShape(2.dp))
            .background(Color(0xFF19100B))
            .padding(14.dp)
        ) {
          Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
            Text(
              text = "❖  ${currentPage.sanctuary}  ❖",
              fontFamily = FontFamily.Serif,
              fontWeight = FontWeight.Bold,
              fontSize = 13.sp,
              letterSpacing = 1.5.sp,
              color = ImperialGoldBright,
              textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
              text = currentPage.sanctuarySubtitle,
              fontFamily = FontFamily.Serif,
              fontSize = 11.sp,
              color = Color(0xFFD1C4B2),
              textAlign = TextAlign.Center
            )
          }
        }

        Spacer(modifier = Modifier.height(18.dp))

        // Sections inside page
        currentPage.sections.forEach { section ->
          // Section Title Banner with Starbursts (✦ ✦ ✦)
          Row(
            modifier = Modifier
              .fillMaxWidth()
              .background(Color(0xFF1A120B))
              .border(0.6.dp, Color(0xFF45301E))
              .padding(horizontal = 12.dp, vertical = 7.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Text(
              text = section.sectionName,
              fontFamily = FontFamily.Serif,
              fontWeight = FontWeight.Bold,
              fontSize = 11.sp,
              letterSpacing = 2.sp,
              color = Color(0xFFFBF4DF)
            )
            Text(
              text = "✦  ✦  ✦",
              fontSize = 11.sp,
              color = ImperialGold
            )
          }

          Spacer(modifier = Modifier.height(8.dp))

          // Products in this section
          val sectionProducts = section.productIds.mapNotNull { ProductRepository.getProductById(it) }

          Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.fillMaxWidth()
          ) {
            sectionProducts.forEach { product ->
              CatalogueProductRowCard(
                product = product,
                onClick = { onProductClick(product) },
                onInquire = onRequestPriceList
              )
            }
          }

          Spacer(modifier = Modifier.height(18.dp))
        }

        // Page Bottom Vignette
        Box(
          modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
          contentAlignment = Alignment.Center
        ) {
          Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
              text = currentPage.footerLatin,
              fontFamily = FontFamily.Serif,
              fontSize = 12.sp,
              letterSpacing = 2.sp,
              color = ImperialGold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
              text = "NUTURALS IMPERIAL COLLECTIONS  •  PAGE ${currentPage.pageNumber} OF 4",
              fontFamily = FontFamily.Serif,
              fontSize = 9.sp,
              letterSpacing = 2.sp,
              color = Color(0xFF7A6B59)
            )
          }
        }

        // Page 4 Concierge Inscription
        if (currentPage.pageNumber == 4) {
          Box(
            modifier = Modifier
              .fillMaxWidth()
              .border(0.8.dp, ImperialGold, RoundedCornerShape(2.dp))
              .background(Color(0xFF1F140D))
              .padding(14.dp),
            contentAlignment = Alignment.Center
          ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
              Text(
                text = "Imperial Private Concierge & Sovereign Allocations",
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = ImperialGoldBright
              )
              Text(
                text = "Email: ${BrandConfig.CONTACT_EMAIL}  •  WhatsApp: ${BrandConfig.WHATSAPP_DISPLAY}",
                fontFamily = FontFamily.Serif,
                fontSize = 11.sp,
                color = Color(0xFFFBF4DF),
                modifier = Modifier.padding(top = 4.dp)
              )
            }
          }
        }
      }
    }

    // -------------------------------------------------------------
    // FOOTER
    // -------------------------------------------------------------
    item(key = "catalogue_footer") {
      NuturalsFooter(
        onNavigate = onNavigate,
        onRequestQuote = onRequestPriceList,
        onWhatsAppClick = onWhatsAppClick
      )
    }
  }
}

/**
 * Authentic Catalogue Product Card styled directly after the 4-page PDF layout
 */
@Composable
private fun CatalogueProductRowCard(
  product: Product,
  onClick: () -> Unit,
  onInquire: () -> Unit
) {
  Box(
    modifier = Modifier
      .fillMaxWidth()
      .border(0.8.dp, Color(0xFF4A3422), RoundedCornerShape(2.dp))
      .background(Color(0xFF140D08))
      .clickable(onClick = onClick)
      .padding(12.dp)
  ) {
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.spacedBy(12.dp),
      verticalAlignment = Alignment.Top
    ) {
      // Small Visual Icon Canvas Box
      Box(
        modifier = Modifier
          .size(68.dp)
          .border(0.8.dp, Color(0xFF5A412A), RoundedCornerShape(2.dp))
          .background(Color(0xFF1E140C))
          .clip(RoundedCornerShape(2.dp)),
        contentAlignment = Alignment.Center
      ) {
        ProductArtCanvas(
          iconType = product.visualIconType,
          modifier = Modifier.fillMaxSize(),
          backgroundColor = Color(0xFF1E140C)
        )
      }

      // Details
      Column(
        modifier = Modifier.weight(1f)
      ) {
        // Name & Price Row
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.Top
        ) {
          Text(
            text = product.name,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            color = Color(0xFFFBF4DF),
            modifier = Modifier.weight(1f)
          )

          Column(horizontalAlignment = Alignment.End) {
            Text(
              text = if (product.sovereignPrice.isNotBlank()) product.sovereignPrice else product.priceDisplay,
              fontFamily = FontFamily.Serif,
              fontWeight = FontWeight.Bold,
              fontSize = 12.sp,
              color = ImperialGoldBright
            )
            if (product.sovereignPrice.isNotBlank() && product.priceDisplay.isNotBlank()) {
              Text(
                text = "Retail: ${product.priceDisplay}",
                fontSize = 9.sp,
                color = Color(0xFFA89985)
              )
            }
          }
        }

        Spacer(modifier = Modifier.height(4.dp))

        // Description / Tasting Profile
        Text(
          text = product.description,
          fontFamily = FontFamily.Serif,
          fontSize = 11.sp,
          lineHeight = 15.sp,
          color = Color(0xFFC7B9A5),
          maxLines = 3
        )

        Spacer(modifier = Modifier.height(6.dp))

        // Origin & Grade Tag Line
        Text(
          text = if (product.palatialNotes.isNotBlank()) product.palatialNotes else "ORIGIN: ${product.origin.uppercase()} • ${product.grade.uppercase()}",
          fontFamily = FontFamily.Serif,
          fontWeight = FontWeight.SemiBold,
          fontSize = 9.sp,
          letterSpacing = 1.2.sp,
          color = ImperialGold
        )
      }
    }
  }
}

private data class CataloguePageData(
  val pageNumber: Int,
  val tome: String,
  val title: String,
  val sanctuary: String,
  val sanctuarySubtitle: String,
  val footerLatin: String,
  val sections: List<CatalogueSectionData>
)

private data class CatalogueSectionData(
  val sectionName: String,
  val productIds: List<String>
)
