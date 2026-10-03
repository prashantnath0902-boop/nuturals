package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material.icons.outlined.Chat
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material.icons.outlined.ReceiptLong
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.BrandConfig
import com.example.ui.QuoteFormState
import com.example.ui.Screen
import com.example.ui.components.NuturalsFooter
import com.example.ui.components.QuoteForm
import com.example.ui.components.SectionHeader
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
import com.example.ui.theme.WarmIvory

@Composable
fun ContactScreen(
  onNavigate: (Screen) -> Unit,
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
  LazyColumn(
    modifier = modifier
      .fillMaxSize()
      .background(WarmIvory)
      .testTag("contact_screen")
  ) {
    // Header
    item(key = "contact_hero") {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .background(Cream)
          .padding(horizontal = 20.dp, vertical = 32.dp)
      ) {
        SectionHeader(
          eyebrow = "Trade Enquiries",
          title = "Contact the NUTURALS Trade Desk",
          subtitle = "Whether you are a wholesaler seeking container pricing, a retailer exploring private-label packaging, or an institutional buyer, our team is at your disposal."
        )
      }
    }

    // Direct Contacts Strip
    item(key = "direct_contact_info") {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 20.dp, vertical = 20.dp)
      ) {
        Card(
          modifier = Modifier
            .fillMaxWidth()
            .border(0.8.dp, BeigeBorder, RoundedCornerShape(2.dp)),
          colors = CardDefaults.cardColors(containerColor = CardSurfaceLight)
        ) {
          Column(modifier = Modifier.padding(16.dp)) {
            Text(
              text = "COMMERCIAL ENQUIRY CHANNELS",
              style = MaterialTheme.typography.labelSmall.copy(
                color = MutedGoldDark,
                fontWeight = FontWeight.Bold,
                letterSpacing = 1.5.sp
              )
            )

            Spacer(modifier = Modifier.height(12.dp))

            ContactChannelRow(
              icon = Icons.Outlined.Email,
              label = "Procurement Email",
              value = BrandConfig.CONTACT_EMAIL
            )

            ContactChannelRow(
              icon = Icons.Outlined.Phone,
              label = "Trade Line",
              value = BrandConfig.CONTACT_PHONE
            )

            ContactChannelRow(
              icon = Icons.Outlined.Chat,
              label = "WhatsApp Desk",
              value = "${BrandConfig.WHATSAPP_DISPLAY} (Click to Chat)",
              onClick = onWhatsAppClick
            )

            ContactChannelRow(
              icon = Icons.Outlined.LocationOn,
              label = "Office Hub",
              value = BrandConfig.OFFICE_LOCATION
            )
          }
        }

        Spacer(modifier = Modifier.height(14.dp))

        // Button to View past submitted RFQs
        OutlinedButton(
          onClick = { onNavigate(Screen.MyQuotes) },
          shape = RoundedCornerShape(2.dp),
          colors = ButtonDefaults.outlinedButtonColors(contentColor = ForestGreenDark),
          border = androidx.compose.foundation.BorderStroke(1.dp, ForestGreenPrimary),
          modifier = Modifier.fillMaxWidth()
        ) {
          Icon(Icons.Outlined.ReceiptLong, contentDescription = null, tint = ForestGreenDark, modifier = Modifier.size(16.dp))
          Spacer(modifier = Modifier.width(8.dp))
          Text("View My Submitted Inquiries", color = ForestGreenDark)
        }
      }
    }

    // Quote Form Component
    item(key = "contact_form_area") {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 20.dp, vertical = 10.dp)
      ) {
        QuoteForm(
          formState = quoteFormState,
          onFormChange = onQuoteFormChange,
          onSubmit = onQuoteSubmit,
          onReset = onQuoteReset
        )
      }
    }

    // Footer
    item(key = "contact_footer") {
      Spacer(modifier = Modifier.height(24.dp))
      NuturalsFooter(
        onNavigate = onNavigate,
        onRequestQuote = { /* already here */ },
        onWhatsAppClick = onWhatsAppClick
      )
    }
  }
}

@Composable
private fun ContactChannelRow(
  icon: androidx.compose.ui.graphics.vector.ImageVector,
  label: String,
  value: String,
  onClick: (() -> Unit)? = null
) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .clickable(enabled = onClick != null) { onClick?.invoke() }
      .padding(vertical = 8.dp),
    verticalAlignment = Alignment.CenterVertically
  ) {
    Icon(icon, contentDescription = null, tint = ForestGreenDark, modifier = Modifier.size(18.dp))
    Spacer(modifier = Modifier.width(12.dp))
    Column {
      Text(text = label, style = MaterialTheme.typography.labelSmall.copy(color = MutedGoldDark))
      Text(
        text = value,
        style = MaterialTheme.typography.bodySmall.copy(
          fontWeight = FontWeight.Medium,
          color = if (onClick != null) ForestGreenPrimary else DarkCharcoalBody
        )
      )
    }
  }
}
