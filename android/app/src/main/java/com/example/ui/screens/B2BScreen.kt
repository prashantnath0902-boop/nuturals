package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material.icons.outlined.Apartment
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.LocalShipping
import androidx.compose.material.icons.outlined.Storefront
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import com.example.ui.Screen
import com.example.ui.components.NuturalsFooter
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
import com.example.ui.theme.WarmIvoryLight

@Composable
fun B2BScreen(
  onNavigate: (Screen) -> Unit,
  onRequestQuote: () -> Unit,
  onWhatsAppClick: () -> Unit,
  modifier: Modifier = Modifier
) {
  LazyColumn(
    modifier = modifier
      .fillMaxSize()
      .background(WarmIvory)
      .testTag("b2b_screen")
  ) {
    // Hero
    item(key = "b2b_hero") {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .background(Cream)
          .padding(horizontal = 20.dp, vertical = 32.dp)
      ) {
        SectionHeader(
          eyebrow = "Commercial Trade",
          title = "Built for Businesses That Demand Consistency",
          subtitle = "From wholesale distribution to food service and manufacturing, NUTURALS works with businesses looking for dependable product supply and flexible solutions."
        )
      }
    }

    // Segments
    item(key = "b2b_segments") {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 20.dp, vertical = 24.dp)
      ) {
        BrandConfig.B2B_AUDIENCES.forEach { audience ->
          Card(
            modifier = Modifier
              .fillMaxWidth()
              .padding(vertical = 6.dp)
              .border(0.8.dp, BeigeBorder, RoundedCornerShape(2.dp)),
            colors = CardDefaults.cardColors(containerColor = CardSurfaceLight)
          ) {
            Column(modifier = Modifier.padding(16.dp)) {
              Text(
                text = audience.title,
                style = MaterialTheme.typography.titleMedium.copy(
                  fontFamily = EditorialSerif,
                  fontWeight = FontWeight.Bold,
                  color = ForestGreenDark,
                  letterSpacing = 1.2.sp,
                  fontSize = 17.sp
                )
              )
              Text(
                text = audience.tagline,
                style = MaterialTheme.typography.labelSmall.copy(
                  color = MutedGoldDark,
                  fontSize = 11.5.sp,
                  fontWeight = FontWeight.Medium
                )
              )
              Spacer(modifier = Modifier.height(6.dp))
              Text(
                text = audience.description,
                style = MaterialTheme.typography.bodyMedium.copy(
                  color = DarkCharcoalBody,
                  fontSize = 13.5.sp,
                  lineHeight = 20.sp
                )
              )
            }
          }
        }
      }
    }

    // Partnership Benefits
    item(key = "b2b_benefits") {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .background(Cream)
          .padding(horizontal = 20.dp, vertical = 28.dp)
      ) {
        SectionHeader(
          eyebrow = "Partnership Benefits",
          title = "Why Procure Through NUTURALS",
          subtitle = "Structured for volume, stability, and professional trade compliance."
        )

        Spacer(modifier = Modifier.height(16.dp))

        val benefits = listOf(
          "Direct container-load planning & multi-origin consolidation",
          "Traceable batch coding and calibrated physical specifications",
          "Flexible packaging: bulk totes, 25kg cartons, nitrogen-flushed retail pouches",
          "Commercial trade credit evaluation for recurring accounts",
          "Dedicated procurement desk for price lock agreements"
        )

        benefits.forEach { benefit ->
          Row(
            modifier = Modifier.padding(vertical = 5.dp),
            verticalAlignment = Alignment.CenterVertically
          ) {
            Icon(Icons.Outlined.Check, contentDescription = null, tint = ForestGreenPrimary, modifier = Modifier.size(16.dp))
            Spacer(modifier = Modifier.width(10.dp))
            Text(benefit, style = MaterialTheme.typography.bodySmall.copy(color = DarkCharcoalBody, fontSize = 13.sp))
          }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
          onClick = onRequestQuote,
          colors = ButtonDefaults.buttonColors(containerColor = ForestGreenPrimary),
          shape = RoundedCornerShape(2.dp),
          modifier = Modifier.fillMaxWidth()
        ) {
          Text("Become a NUTURALS Partner", color = Color.White, letterSpacing = 0.5.sp)
        }
      }
    }

    // Footer
    item(key = "b2b_footer") {
      NuturalsFooter(
        onNavigate = onNavigate,
        onRequestQuote = onRequestQuote,
        onWhatsAppClick = onWhatsAppClick
      )
    }
  }
}
