package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Chat
import androidx.compose.material.icons.outlined.Inventory2
import androidx.compose.material.icons.outlined.Place
import androidx.compose.material.icons.outlined.RequestQuote
import androidx.compose.material.icons.outlined.Shield
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.ProductRepository
import com.example.model.Product
import com.example.ui.Screen
import com.example.ui.components.NuturalsFooter
import com.example.ui.components.ProductArtCanvas
import com.example.ui.theme.BeigeBorder
import com.example.ui.theme.CardSurfaceLight
import com.example.ui.theme.Cream
import com.example.ui.theme.DarkCharcoal
import com.example.ui.theme.DarkCharcoalBody
import com.example.ui.theme.EditorialSerif
import com.example.ui.theme.ForestGreenDark
import com.example.ui.theme.ForestGreenPrimary
import com.example.ui.theme.MutedGold
import com.example.ui.theme.MutedGoldDark
import com.example.ui.theme.NaturalBeige
import com.example.ui.theme.WarmIvory
import com.example.ui.theme.WarmIvoryLight

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ProductDetailScreen(
  productId: String,
  onBack: () -> Unit,
  onRequestQuote: (Product) -> Unit,
  onWhatsAppInquiry: (Product) -> Unit,
  onNavigate: (Screen) -> Unit,
  modifier: Modifier = Modifier
) {
  val product = ProductRepository.getProductById(productId) ?: ProductRepository.products.first()

  LazyColumn(
    modifier = modifier
      .fillMaxSize()
      .background(WarmIvory)
      .testTag("product_detail_screen")
  ) {
    // Back navigation bar
    item(key = "back_bar") {
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .background(WarmIvoryLight)
          .padding(horizontal = 12.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
      ) {
        IconButton(onClick = onBack) {
          Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "Back",
            tint = ForestGreenDark
          )
        }
        Spacer(modifier = Modifier.width(4.dp))
        Text(
          text = "ALL PRODUCTS  /  ${product.category.displayName.uppercase()}",
          style = MaterialTheme.typography.labelSmall.copy(
            color = MutedGoldDark,
            letterSpacing = 1.2.sp,
            fontWeight = FontWeight.Bold
          )
        )
      }
    }

    // Hero Visual Showcase
    item(key = "product_visual_hero") {
      Box(
        modifier = Modifier
          .fillMaxWidth()
          .height(260.dp)
          .background(Cream)
      ) {
        ProductArtCanvas(
          iconType = product.visualIconType,
          modifier = Modifier.fillMaxSize(),
          backgroundColor = Cream
        )

        // Availability Pill
        Box(
          modifier = Modifier
            .padding(16.dp)
            .align(Alignment.TopEnd)
            .background(ForestGreenDark, RoundedCornerShape(2.dp))
            .padding(horizontal = 10.dp, vertical = 4.dp)
        ) {
          Text(
            text = product.availability.uppercase(),
            style = MaterialTheme.typography.labelSmall.copy(
              color = WarmIvory,
              fontSize = 9.sp,
              letterSpacing = 1.sp
            )
          )
        }
      }
    }

    // Product Title & Core Attributes
    item(key = "core_attributes") {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .background(WarmIvoryLight)
          .padding(20.dp)
      ) {
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.Top
        ) {
          Column(modifier = Modifier.weight(1f)) {
            Text(
              text = product.name,
              style = MaterialTheme.typography.headlineMedium.copy(
                fontFamily = EditorialSerif,
                fontWeight = FontWeight.Normal,
                fontSize = 26.sp,
                color = ForestGreenDark
              )
            )

            Spacer(modifier = Modifier.height(4.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
              Icon(Icons.Outlined.Place, contentDescription = null, tint = MutedGoldDark, modifier = Modifier.size(14.dp))
              Spacer(modifier = Modifier.width(4.dp))
              Text(
                text = "Origin: ${product.origin}",
                style = MaterialTheme.typography.labelMedium.copy(
                  color = ForestGreenPrimary,
                  fontWeight = FontWeight.SemiBold
                )
              )
              Spacer(modifier = Modifier.width(12.dp))
              Text(
                text = "• Category: ${product.category.displayName}",
                style = MaterialTheme.typography.bodySmall.copy(color = DarkCharcoalBody)
              )
            }
          }
        }

        Spacer(modifier = Modifier.height(14.dp))

        Text(
          text = product.description,
          style = MaterialTheme.typography.bodyMedium.copy(
            color = DarkCharcoalBody,
            fontSize = 14.5.sp,
            lineHeight = 23.sp
          )
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Price & MOQ Strip
        Row(
          modifier = Modifier
            .fillMaxWidth()
            .background(Cream, RoundedCornerShape(2.dp))
            .border(1.dp, BeigeBorder, RoundedCornerShape(2.dp))
            .padding(14.dp),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          Column {
            Text(
              text = "COMMERCIAL PRICING",
              style = MaterialTheme.typography.labelSmall.copy(color = CharcoalMuted())
            )
            Text(
              text = product.priceDisplay,
              style = MaterialTheme.typography.titleMedium.copy(
                color = ForestGreenDark,
                fontWeight = FontWeight.Bold,
                fontFamily = EditorialSerif
              )
            )
          }

          Column(horizontalAlignment = Alignment.End) {
            Text(
              text = "MINIMUM ORDER QUANTITY",
              style = MaterialTheme.typography.labelSmall.copy(color = CharcoalMuted())
            )
            Text(
              text = product.moq,
              style = MaterialTheme.typography.titleMedium.copy(
                color = ForestGreenDark,
                fontWeight = FontWeight.Bold,
                fontFamily = EditorialSerif
              )
            )
          }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // CTAs
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
          Button(
            onClick = { onRequestQuote(product) },
            colors = ButtonDefaults.buttonColors(
              containerColor = ForestGreenPrimary,
              contentColor = Color.White
            ),
            shape = RoundedCornerShape(2.dp),
            modifier = Modifier
              .weight(1.3f)
              .height(46.dp)
              .testTag("detail_request_quote_button")
          ) {
            Icon(Icons.Outlined.RequestQuote, contentDescription = null, tint = Color.White)
            Spacer(modifier = Modifier.width(8.dp))
            Text("Request a Quote", color = Color.White, fontWeight = FontWeight.Bold)
          }

          OutlinedButton(
            onClick = { onWhatsAppInquiry(product) },
            shape = RoundedCornerShape(2.dp),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = ForestGreenDark),
            border = androidx.compose.foundation.BorderStroke(1.2.dp, ForestGreenPrimary),
            modifier = Modifier
              .weight(1f)
              .height(46.dp)
          ) {
            Icon(Icons.Outlined.Chat, contentDescription = null, tint = ForestGreenDark)
            Spacer(modifier = Modifier.width(6.dp))
            Text("WhatsApp", color = ForestGreenDark)
          }
        }
      }
    }

    // Specifications & Parameters Table
    item(key = "technical_specifications") {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .padding(20.dp)
      ) {
        Text(
          text = "TECHNICAL SPECIFICATIONS",
          style = MaterialTheme.typography.labelSmall.copy(
            color = MutedGoldDark,
            fontWeight = FontWeight.Bold,
            letterSpacing = 2.sp
          )
        )

        Spacer(modifier = Modifier.height(10.dp))

        Card(
          modifier = Modifier
            .fillMaxWidth()
            .border(0.8.dp, BeigeBorder, RoundedCornerShape(2.dp)),
          colors = CardDefaults.cardColors(containerColor = CardSurfaceLight)
        ) {
          Column(modifier = Modifier.padding(16.dp)) {
            SpecRow("Origin", product.origin)
            SpecRow("Grade Classification", product.grade)
            SpecRow("Available Forms", product.availableForms.joinToString(" • "))
            SpecRow("Packaging Solutions", product.packagingOptions.joinToString(" • "))

            product.specifications.forEach { spec ->
              SpecRow(spec.label, spec.value)
            }
          }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
          text = "* Specifications are verified per batch lot according to official Certificate of Analysis (COA). Technical Data Sheets (TDS) supplied upon contract request.",
          style = MaterialTheme.typography.bodySmall.copy(
            color = DarkCharcoalBody.copy(alpha = 0.7f),
            fontSize = 11.sp
          )
        )
      }
    }

    // Applications Section
    item(key = "product_applications") {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .background(Cream)
          .padding(20.dp)
      ) {
        Text(
          text = "TARGET COMMERCIAL APPLICATIONS",
          style = MaterialTheme.typography.labelSmall.copy(
            color = MutedGoldDark,
            fontWeight = FontWeight.Bold,
            letterSpacing = 2.sp
          )
        )

        Spacer(modifier = Modifier.height(12.dp))

        FlowRow(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.spacedBy(8.dp),
          verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
          product.applications.forEach { app ->
            Box(
              modifier = Modifier
                .background(WarmIvoryLight, RoundedCornerShape(2.dp))
                .border(0.8.dp, BeigeBorder, RoundedCornerShape(2.dp))
                .padding(horizontal = 12.dp, vertical = 7.dp)
            ) {
              Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                  Icons.Outlined.CheckCircle,
                  contentDescription = null,
                  tint = ForestGreenPrimary,
                  modifier = Modifier.size(13.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                  text = app,
                  style = MaterialTheme.typography.bodySmall.copy(
                    fontWeight = FontWeight.Medium,
                    color = ForestGreenDark
                  )
                )
              }
            }
          }
        }
      }
    }

    // Direct Pre-filled Quote CTA
    item(key = "prefilled_quote_cta") {
      Box(
        modifier = Modifier
          .fillMaxWidth()
          .padding(20.dp)
      ) {
        Card(
          modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, MutedGoldDark, RoundedCornerShape(2.dp)),
          colors = CardDefaults.cardColors(containerColor = WarmIvoryLight)
        ) {
          Column(modifier = Modifier.padding(20.dp)) {
            Text(
              text = "Procure ${product.name}",
              style = MaterialTheme.typography.titleLarge.copy(
                fontFamily = EditorialSerif,
                color = ForestGreenDark
              )
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
              text = "Submit an RFQ for customized lot sizing, target moisture thresholds, packaging styles, and delivery schedules.",
              style = MaterialTheme.typography.bodySmall.copy(color = DarkCharcoalBody)
            )
            Spacer(modifier = Modifier.height(14.dp))
            Button(
              onClick = { onRequestQuote(product) },
              colors = ButtonDefaults.buttonColors(containerColor = ForestGreenPrimary),
              shape = RoundedCornerShape(2.dp),
              modifier = Modifier.fillMaxWidth()
            ) {
              Text("Request Quote for This Product", color = Color.White)
            }
          }
        }
      }
    }

    // Footer
    item(key = "detail_footer") {
      NuturalsFooter(
        onNavigate = onNavigate,
        onRequestQuote = { onNavigate(Screen.Contact) },
        onWhatsAppClick = { onWhatsAppInquiry(product) }
      )
    }
  }
}

@Composable
private fun SpecRow(label: String, value: String) {
  Column(modifier = Modifier.padding(vertical = 6.dp)) {
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.Top
    ) {
      Text(
        text = label,
        style = MaterialTheme.typography.labelSmall.copy(
          color = ForestGreenDark,
          fontWeight = FontWeight.Bold,
          fontSize = 11.5.sp
        ),
        modifier = Modifier.weight(1.1f)
      )
      Text(
        text = value,
        style = MaterialTheme.typography.bodySmall.copy(
          color = DarkCharcoalBody,
          fontSize = 12.5.sp
        ),
        modifier = Modifier.weight(1.5f)
      )
    }
    HorizontalDivider(color = BeigeBorder.copy(alpha = 0.4f), thickness = 0.5.dp, modifier = Modifier.padding(top = 6.dp))
  }
}

@Composable
private fun CharcoalMuted(): Color = Color(0xFF6B726C)
