package com.example.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Language
import androidx.compose.material.icons.outlined.RequestQuote
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.AppLanguage
import com.example.data.TranslationRepository
import com.example.ui.Screen
import com.example.ui.theme.BeigeBorder
import com.example.ui.theme.Cream
import com.example.ui.theme.DarkCharcoal
import com.example.ui.theme.EditorialSerif
import com.example.ui.theme.ForestGreenDark
import com.example.ui.theme.ForestGreenPrimary
import com.example.ui.theme.MutedGold
import com.example.ui.theme.MutedGoldDark
import com.example.ui.theme.WarmIvoryLight

@Composable
fun NuturalsNavbar(
  activeScreen: Screen,
  currentLanguage: AppLanguage,
  onLanguageChange: (AppLanguage) -> Unit,
  onNavigate: (Screen) -> Unit,
  onRequestQuoteClick: () -> Unit,
  modifier: Modifier = Modifier
) {
  var isMobileMenuOpen by remember { mutableStateOf(false) }
  var isLangMenuOpen by remember { mutableStateOf(false) }

  fun t(key: String): String = TranslationRepository.getString(key, currentLanguage)

  Surface(
    modifier = modifier.fillMaxWidth(),
    color = Color(0xFF140D08),
    shadowElevation = 4.dp
  ) {
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .statusBarsPadding()
    ) {
      // Main Nav Row
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 16.dp, vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        // Logo / Wordmark
        Row(
          modifier = Modifier
            .clickable { onNavigate(Screen.Home) }
            .testTag("nav_logo_brand"),
          verticalAlignment = Alignment.CenterVertically
        ) {
          NuturalsLogoMedallion(
            size = 36.dp,
            showTitle = false
          )

          Spacer(modifier = Modifier.width(10.dp))

          Column {
            Text(
              text = "NUTURALS",
              style = MaterialTheme.typography.titleLarge.copy(
                fontFamily = androidx.compose.ui.text.font.FontFamily.Serif,
                fontWeight = FontWeight.Bold,
                letterSpacing = 3.sp,
                color = Color(0xFFFBF4DF),
                fontSize = 17.sp
              )
            )
            Text(
              text = "ULTRA-PREMIUM RESERVE",
              style = MaterialTheme.typography.labelSmall.copy(
                fontSize = 7.5.sp,
                letterSpacing = 1.6.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFFD4AF37)
              )
            )
          }
        }

        // Action Row: Language Switcher + Request a Quote + Hamburger
        Row(
          verticalAlignment = Alignment.CenterVertically
        ) {
          // Language Switcher Dropdown in Header
          Box {
            Row(
              modifier = Modifier
                .clip(RoundedCornerShape(2.dp))
                .background(Cream)
                .border(0.8.dp, BeigeBorder, RoundedCornerShape(2.dp))
                .clickable { isLangMenuOpen = true }
                .padding(horizontal = 8.dp, vertical = 6.dp)
                .testTag("language_switcher_button"),
              verticalAlignment = Alignment.CenterVertically
            ) {
              Text(
                text = "${currentLanguage.flag} ${currentLanguage.code.uppercase()}",
                style = MaterialTheme.typography.labelSmall.copy(
                  fontSize = 11.sp,
                  fontWeight = FontWeight.Bold,
                  color = ForestGreenDark
                )
              )
              Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = "Switch language",
                tint = ForestGreenDark,
                modifier = Modifier.size(16.dp)
              )
            }

            DropdownMenu(
              expanded = isLangMenuOpen,
              onDismissRequest = { isLangMenuOpen = false }
            ) {
              AppLanguage.values().forEach { lang ->
                DropdownMenuItem(
                  text = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                      Text(lang.flag, fontSize = 16.sp)
                      Spacer(modifier = Modifier.width(8.dp))
                      Text(
                        text = "${lang.displayName} (${lang.nativeName})",
                        style = MaterialTheme.typography.bodyMedium.copy(
                          fontWeight = if (lang == currentLanguage) FontWeight.Bold else FontWeight.Normal,
                          color = if (lang == currentLanguage) ForestGreenPrimary else DarkCharcoal
                        )
                      )
                    }
                  },
                  onClick = {
                    onLanguageChange(lang)
                    isLangMenuOpen = false
                  }
                )
              }
            }
          }

          Spacer(modifier = Modifier.width(8.dp))

          // Primary "Request a Quote" CTA
          Button(
            onClick = onRequestQuoteClick,
            colors = ButtonDefaults.buttonColors(
              containerColor = ForestGreenPrimary,
              contentColor = Color.White
            ),
            shape = RoundedCornerShape(2.dp),
            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp),
            modifier = Modifier
              .height(36.dp)
              .testTag("nav_request_quote_button")
          ) {
            Text(
              text = t("cta_request_quote"),
              style = MaterialTheme.typography.labelLarge.copy(
                fontSize = 11.5.sp,
                letterSpacing = 0.4.sp,
                color = Color.White
              )
            )
          }

          Spacer(modifier = Modifier.width(4.dp))

          // Hamburger toggle
          IconButton(
            onClick = { isMobileMenuOpen = !isMobileMenuOpen },
            modifier = Modifier
              .size(38.dp)
              .testTag("nav_menu_toggle")
          ) {
            Icon(
              imageVector = if (isMobileMenuOpen) Icons.Default.Close else Icons.Default.Menu,
              contentDescription = if (isMobileMenuOpen) "Close menu" else "Open navigation menu",
              tint = ForestGreenDark
            )
          }
        }
      }

      // Horizontal quick-scroller for main links
      val scrollState = rememberScrollState()
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .background(WarmIvoryLight)
          .horizontalScroll(scrollState)
          .padding(horizontal = 12.dp, vertical = 6.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically
      ) {
        val quickLinks = listOf(
          t("nav_home") to Screen.Home,
          t("nav_products") to Screen.Products(),
          t("nav_about") to Screen.About,
          t("nav_quality") to Screen.Quality,
          t("nav_b2b") to Screen.B2B,
          t("nav_private_label") to Screen.PrivateLabel,
          t("nav_export") to Screen.Export,
          t("nav_catalogue") to Screen.Catalogue,
          t("nav_contact") to Screen.Contact
        )

        quickLinks.forEach { (label, targetScreen) ->
          val isSelected = when {
            activeScreen == Screen.Home && targetScreen == Screen.Home -> true
            activeScreen is Screen.Products && targetScreen is Screen.Products -> true
            activeScreen == Screen.About && targetScreen == Screen.About -> true
            activeScreen == Screen.Quality && targetScreen == Screen.Quality -> true
            activeScreen == Screen.B2B && targetScreen == Screen.B2B -> true
            activeScreen == Screen.PrivateLabel && targetScreen == Screen.PrivateLabel -> true
            activeScreen == Screen.Export && targetScreen == Screen.Export -> true
            activeScreen == Screen.Catalogue && targetScreen == Screen.Catalogue -> true
            activeScreen == Screen.Contact && targetScreen == Screen.Contact -> true
            else -> false
          }

          Box(
            modifier = Modifier
              .clip(RoundedCornerShape(2.dp))
              .clickable {
                onNavigate(targetScreen)
                isMobileMenuOpen = false
              }
              .background(if (isSelected) ForestGreenDark.copy(alpha = 0.08f) else Color.Transparent)
              .border(
                width = if (isSelected) 1.dp else 0.dp,
                color = if (isSelected) MutedGold.copy(alpha = 0.7f) else Color.Transparent,
                shape = RoundedCornerShape(2.dp)
              )
              .padding(horizontal = 10.dp, vertical = 6.dp)
          ) {
            Text(
              text = label.uppercase(),
              style = MaterialTheme.typography.labelSmall.copy(
                fontSize = 11.sp,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                letterSpacing = 1.2.sp,
                color = if (isSelected) ForestGreenDark else DarkCharcoal
              )
            )
          }
        }
      }

      HorizontalDivider(color = BeigeBorder.copy(alpha = 0.6f), thickness = 0.8.dp)

      // Expandable Full Menu Drawer
      AnimatedVisibility(
        visible = isMobileMenuOpen,
        enter = expandVertically() + fadeIn(),
        exit = shrinkVertically() + fadeOut()
      ) {
        Column(
          modifier = Modifier
            .fillMaxWidth()
            .background(WarmIvoryLight)
            .padding(16.dp)
        ) {
          // Language selection row in drawer
          Row(
            modifier = Modifier
              .fillMaxWidth()
              .background(Cream, RoundedCornerShape(2.dp))
              .padding(horizontal = 12.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
              Icon(Icons.Outlined.Language, contentDescription = null, tint = ForestGreenDark, modifier = Modifier.size(16.dp))
              Spacer(modifier = Modifier.width(8.dp))
              Text("Language / Langue:", style = MaterialTheme.typography.labelSmall.copy(color = ForestGreenDark, fontWeight = FontWeight.Bold))
            }

            Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
              AppLanguage.values().forEach { lang ->
                Text(
                  text = "${lang.flag} ${lang.code.uppercase()}",
                  style = MaterialTheme.typography.labelSmall.copy(
                    fontSize = 11.sp,
                    fontWeight = if (lang == currentLanguage) FontWeight.Bold else FontWeight.Normal,
                    color = if (lang == currentLanguage) ForestGreenPrimary else DarkCharcoal
                  ),
                  modifier = Modifier
                    .clip(RoundedCornerShape(2.dp))
                    .background(if (lang == currentLanguage) MutedGold.copy(alpha = 0.25f) else Color.Transparent)
                    .clickable { onLanguageChange(lang) }
                    .padding(horizontal = 6.dp, vertical = 3.dp)
                )
              }
            }
          }

          Spacer(modifier = Modifier.height(14.dp))

          Text(
            text = "EXPLORE NUTURALS",
            style = MaterialTheme.typography.labelSmall.copy(
              color = MutedGold,
              letterSpacing = 2.sp,
              fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(bottom = 8.dp)
          )

          val fullNavItems = listOf(
            NavItem(t("nav_home"), "Overview, core sourcing & collection", Screen.Home),
            NavItem(t("nav_products"), "Full catalogue of nuts, dried fruits & seeds", Screen.Products()),
            NavItem(t("nav_about"), "Heritage, sourcing ethos & global reach", Screen.About),
            NavItem(t("nav_quality"), "From Source to Shelf: 5-step standard", Screen.Quality),
            NavItem(t("nav_b2b"), "Bulk procurement, HORECA & manufacturing", Screen.B2B),
            NavItem(t("nav_private_label"), "Custom packaging & co-manufacturing", Screen.PrivateLabel),
            NavItem(t("nav_export"), "International documentation & global shipments", Screen.Export),
            NavItem(t("nav_catalogue"), "Download technical data & trade cards", Screen.Catalogue),
            NavItem(t("nav_contact"), "Submit RFQ or discuss business partnerships", Screen.Contact),
            NavItem(t("nav_my_quotes"), "Track your active trade quote requests", Screen.MyQuotes)
          )

          fullNavItems.forEach { item ->
            Row(
              modifier = Modifier
                .fillMaxWidth()
                .clickable {
                  onNavigate(item.screen)
                  isMobileMenuOpen = false
                }
                .padding(vertical = 10.dp),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Column {
                Text(
                  text = item.label,
                  style = MaterialTheme.typography.titleMedium.copy(
                    fontFamily = EditorialSerif,
                    fontWeight = FontWeight.Medium,
                    color = ForestGreenDark,
                    fontSize = 16.sp
                  )
                )
                Text(
                  text = item.subtext,
                  style = MaterialTheme.typography.bodySmall.copy(
                    color = DarkCharcoal.copy(alpha = 0.7f),
                    fontSize = 12.sp
                  )
                )
              }
              Text(
                text = "→",
                color = MutedGold,
                fontSize = 16.sp
              )
            }
            HorizontalDivider(color = BeigeBorder.copy(alpha = 0.4f), thickness = 0.5.dp)
          }

          Spacer(modifier = Modifier.height(14.dp))

          // Mobile Drawer Quick Quote CTA
          Button(
            onClick = {
              onRequestQuoteClick()
              isMobileMenuOpen = false
            },
            colors = ButtonDefaults.buttonColors(containerColor = ForestGreenPrimary),
            shape = RoundedCornerShape(2.dp),
            modifier = Modifier.fillMaxWidth()
          ) {
            Icon(Icons.Outlined.RequestQuote, contentDescription = null, tint = Color.White)
            Spacer(modifier = Modifier.width(8.dp))
            Text(t("cta_wholesale_quote"), color = Color.White, letterSpacing = 1.sp)
          }
        }
      }
    }
  }
}

private data class NavItem(val label: String, val subtext: String, val screen: Screen)
