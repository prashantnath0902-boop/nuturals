package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Language
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import com.example.data.AppLanguage
import com.example.data.BrandConfig
import com.example.data.TranslationRepository
import com.example.ui.Screen
import com.example.ui.theme.DarkFooterBg
import com.example.ui.theme.EditorialSerif
import com.example.ui.theme.ForestGreenDark
import com.example.ui.theme.ForestGreenPrimary
import com.example.ui.theme.MutedGold
import com.example.ui.theme.MutedGoldDark
import com.example.ui.theme.WarmIvory

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun NuturalsFooter(
  onNavigate: (Screen) -> Unit,
  onRequestQuote: () -> Unit,
  onWhatsAppClick: () -> Unit,
  currentLanguage: AppLanguage = AppLanguage.EN,
  onLanguageChange: (AppLanguage) -> Unit = {},
  modifier: Modifier = Modifier
) {
  fun t(key: String): String = TranslationRepository.getString(key, currentLanguage)

  Column(
    modifier = modifier
      .fillMaxWidth()
      .background(DarkFooterBg)
      .padding(horizontal = 20.dp, vertical = 32.dp)
      .testTag("nuturals_footer")
  ) {
    // Brand Heading & Secondary Tagline
    Row(
      verticalAlignment = Alignment.CenterVertically
    ) {
      Box(
        modifier = Modifier
          .size(20.dp)
          .clip(CircleShape)
          .background(MutedGoldDark),
        contentAlignment = Alignment.Center
      ) {
        Box(
          modifier = Modifier
            .size(8.dp)
            .clip(CircleShape)
            .background(DarkFooterBg)
        )
      }

      Spacer(modifier = Modifier.width(10.dp))

      Text(
        text = "NUTURALS",
        style = MaterialTheme.typography.titleLarge.copy(
          fontFamily = EditorialSerif,
          fontWeight = FontWeight.Bold,
          letterSpacing = 4.sp,
          color = WarmIvory,
          fontSize = 18.sp
        )
      )
    }

    Spacer(modifier = Modifier.height(10.dp))

    Text(
      text = t("secondary_tagline"),
      style = MaterialTheme.typography.titleMedium.copy(
        fontFamily = EditorialSerif,
        color = MutedGold,
        fontSize = 16.sp,
        letterSpacing = 0.5.sp
      )
    )

    Spacer(modifier = Modifier.height(8.dp))

    Text(
      text = t("supporting_line"),
      style = MaterialTheme.typography.bodySmall.copy(
        color = Color(0xFFB5BEB7),
        lineHeight = 20.sp
      )
    )

    Spacer(modifier = Modifier.height(24.dp))
    HorizontalDivider(color = Color(0xFF26332A), thickness = 1.dp)
    Spacer(modifier = Modifier.height(24.dp))

    // Navigation Columns
    Text(
      text = "NAVIGATION",
      style = MaterialTheme.typography.labelSmall.copy(
        color = MutedGold,
        letterSpacing = 2.sp,
        fontWeight = FontWeight.Bold
      )
    )
    Spacer(modifier = Modifier.height(10.dp))

    FlowRow(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.spacedBy(16.dp),
      verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
      FooterNavLink(t("nav_home")) { onNavigate(Screen.Home) }
      FooterNavLink(t("nav_products")) { onNavigate(Screen.Products()) }
      FooterNavLink(t("nav_about")) { onNavigate(Screen.About) }
      FooterNavLink(t("nav_quality")) { onNavigate(Screen.Quality) }
      FooterNavLink(t("nav_b2b")) { onNavigate(Screen.B2B) }
      FooterNavLink(t("nav_private_label")) { onNavigate(Screen.PrivateLabel) }
      FooterNavLink(t("nav_export")) { onNavigate(Screen.Export) }
      FooterNavLink(t("nav_catalogue")) { onNavigate(Screen.Catalogue) }
      FooterNavLink(t("nav_contact")) { onNavigate(Screen.Contact) }
      FooterNavLink(t("nav_my_quotes")) { onNavigate(Screen.MyQuotes) }
    }

    Spacer(modifier = Modifier.height(24.dp))
    HorizontalDivider(color = Color(0xFF26332A), thickness = 1.dp)
    Spacer(modifier = Modifier.height(20.dp))

    // Business Enquiries
    Text(
      text = "BUSINESS ENQUIRIES",
      style = MaterialTheme.typography.labelSmall.copy(
        color = MutedGold,
        letterSpacing = 2.sp,
        fontWeight = FontWeight.Bold
      )
    )
    Spacer(modifier = Modifier.height(10.dp))

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
      FooterBusinessLink(t("cta_wholesale_quote")) { onRequestQuote() }
      FooterBusinessLink("Distributor Partnerships") { onNavigate(Screen.B2B) }
      FooterBusinessLink("Private Label Packaging") { onNavigate(Screen.PrivateLabel) }
      FooterBusinessLink("Export Trade & Bulk Supply") { onNavigate(Screen.Export) }
    }

    Spacer(modifier = Modifier.height(24.dp))
    HorizontalDivider(color = Color(0xFF26332A), thickness = 1.dp)
    Spacer(modifier = Modifier.height(20.dp))

    // Contact Information
    Text(
      text = "CONTACT & TRADE DESK",
      style = MaterialTheme.typography.labelSmall.copy(
        color = MutedGold,
        letterSpacing = 2.sp,
        fontWeight = FontWeight.Bold
      )
    )
    Spacer(modifier = Modifier.height(10.dp))

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
      Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(Icons.Outlined.Email, contentDescription = null, tint = MutedGold, modifier = Modifier.size(15.dp))
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = BrandConfig.CONTACT_EMAIL, style = MaterialTheme.typography.bodySmall.copy(color = Color(0xFFD6DDD8)))
      }

      Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(Icons.Outlined.Phone, contentDescription = null, tint = MutedGold, modifier = Modifier.size(15.dp))
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = BrandConfig.CONTACT_PHONE, style = MaterialTheme.typography.bodySmall.copy(color = Color(0xFFD6DDD8)))
      }

      Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable { onWhatsAppClick() }
      ) {
        Text(text = "WhatsApp: ", style = MaterialTheme.typography.labelSmall.copy(color = MutedGold, fontWeight = FontWeight.Bold))
        Text(text = "${BrandConfig.WHATSAPP_DISPLAY} (Direct Chat)", style = MaterialTheme.typography.bodySmall.copy(color = Color(0xFF88D49E)))
      }

      Row(verticalAlignment = Alignment.Top) {
        Icon(Icons.Outlined.LocationOn, contentDescription = null, tint = MutedGold, modifier = Modifier.size(15.dp))
        Spacer(modifier = Modifier.width(8.dp))
        Text(
          text = BrandConfig.OFFICE_LOCATION,
          style = MaterialTheme.typography.bodySmall.copy(color = Color(0xFFD6DDD8))
        )
      }
    }

    Spacer(modifier = Modifier.height(24.dp))
    HorizontalDivider(color = Color(0xFF26332A), thickness = 1.dp)
    Spacer(modifier = Modifier.height(18.dp))

    // Language Selection in Footer
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .background(Color(0xFF161F18), RoundedCornerShape(2.dp))
        .padding(horizontal = 12.dp, vertical = 8.dp),
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically
    ) {
      Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(Icons.Outlined.Language, contentDescription = null, tint = MutedGold, modifier = Modifier.size(15.dp))
        Spacer(modifier = Modifier.width(6.dp))
        Text(
          text = "Select Language:",
          style = MaterialTheme.typography.labelSmall.copy(color = Color(0xFFD2DAD4), fontSize = 11.sp)
        )
      }

      Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
        AppLanguage.values().forEach { lang ->
          val isSelected = lang == currentLanguage
          Text(
            text = "${lang.flag} ${lang.code.uppercase()}",
            style = MaterialTheme.typography.labelSmall.copy(
              color = if (isSelected) MutedGold else Color(0xFF8D9991),
              fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
              fontSize = 11.sp
            ),
            modifier = Modifier
              .clickable { onLanguageChange(lang) }
              .padding(horizontal = 4.dp, vertical = 2.dp)
          )
        }
      }
    }

    Spacer(modifier = Modifier.height(16.dp))

    // Copyright & Policy Note
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically
    ) {
      Text(
        text = "© 2026 NUTURALS. All rights reserved.",
        style = MaterialTheme.typography.labelSmall.copy(
          color = Color(0xFF7E8B82),
          fontSize = 10.5.sp
        )
      )

      Text(
        text = "International Trade & Sourcing",
        style = MaterialTheme.typography.labelSmall.copy(
          color = MutedGold.copy(alpha = 0.8f),
          fontSize = 10.5.sp,
          letterSpacing = 1.sp
        )
      )
    }
  }
}

@Composable
private fun FooterNavLink(text: String, onClick: () -> Unit) {
  Text(
    text = text,
    style = MaterialTheme.typography.bodySmall.copy(
      color = Color(0xFFD2DAD4),
      fontSize = 13.sp
    ),
    modifier = Modifier
      .clickable { onClick() }
      .padding(vertical = 2.dp)
  )
}

@Composable
private fun FooterBusinessLink(text: String, onClick: () -> Unit) {
  Row(
    modifier = Modifier
      .clickable { onClick() }
      .padding(vertical = 3.dp),
    verticalAlignment = Alignment.CenterVertically
  ) {
    Text(
      text = "› ",
      color = MutedGold,
      fontSize = 14.sp,
      fontWeight = FontWeight.Bold
    )
    Text(
      text = text,
      style = MaterialTheme.typography.bodySmall.copy(
        color = Color(0xFFE2E8E4),
        fontSize = 13.sp
      )
    )
  }
}
