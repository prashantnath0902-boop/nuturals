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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
fun QualityScreen(
  onNavigate: (Screen) -> Unit,
  onRequestQuote: () -> Unit,
  onWhatsAppClick: () -> Unit,
  modifier: Modifier = Modifier
) {
  LazyColumn(
    modifier = modifier
      .fillMaxSize()
      .background(WarmIvory)
      .testTag("quality_screen")
  ) {
    // Header
    item(key = "quality_hero") {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .background(Cream)
          .padding(horizontal = 20.dp, vertical = 32.dp)
      ) {
        SectionHeader(
          eyebrow = "Quality Assurance",
          title = "From Source to Shelf",
          subtitle = "A calibrated five-stage process ensuring consistent specifications, moisture control, and packaging integrity."
        )
      }
    }

    // Process Timeline Detailed
    item(key = "quality_steps_detailed") {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 20.dp, vertical = 24.dp)
      ) {
        BrandConfig.QUALITY_STEPS.forEachIndexed { index, step ->
          Card(
            modifier = Modifier
              .fillMaxWidth()
              .padding(vertical = 8.dp)
              .border(0.8.dp, BeigeBorder, RoundedCornerShape(2.dp)),
            colors = CardDefaults.cardColors(containerColor = CardSurfaceLight)
          ) {
            Row(
              modifier = Modifier.padding(18.dp),
              verticalAlignment = Alignment.Top
            ) {
              Box(
                modifier = Modifier
                  .size(38.dp)
                  .clip(CircleShape)
                  .background(ForestGreenDark),
                contentAlignment = Alignment.Center
              ) {
                Text(
                  text = step.number,
                  style = MaterialTheme.typography.labelMedium.copy(
                    color = MutedGold,
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp
                  )
                )
              }

              Spacer(modifier = Modifier.width(16.dp))

              Column {
                Text(
                  text = step.title,
                  style = MaterialTheme.typography.titleMedium.copy(
                    fontFamily = EditorialSerif,
                    fontWeight = FontWeight.Bold,
                    color = ForestGreenDark,
                    letterSpacing = 1.sp,
                    fontSize = 17.sp
                  )
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                  text = step.description,
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
    }

    // Specifications & Transparency Note
    item(key = "transparency_box") {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 20.dp, vertical = 16.dp)
      ) {
        Card(
          modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, MutedGold.copy(alpha = 0.6f), RoundedCornerShape(2.dp)),
          colors = CardDefaults.cardColors(containerColor = Cream)
        ) {
          Column(modifier = Modifier.padding(20.dp)) {
            Text(
              text = "Technical Data Sheets & Batch COA",
              style = MaterialTheme.typography.titleMedium.copy(
                fontFamily = EditorialSerif,
                color = ForestGreenDark,
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp
              )
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
              text = "We provide verified Technical Data Sheets (TDS) and batch Certificates of Analysis (COA) for commercial consignments upon request, covering physical counts, moisture analysis, and defect thresholds.",
              style = MaterialTheme.typography.bodySmall.copy(
                color = DarkCharcoalBody,
                lineHeight = 19.sp
              )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
              onClick = onRequestQuote,
              colors = ButtonDefaults.buttonColors(containerColor = ForestGreenPrimary),
              shape = RoundedCornerShape(2.dp)
            ) {
              Text("Request Product Specification Sheet", color = Color.White)
            }
          }
        }
      }
    }

    // Footer
    item(key = "quality_footer") {
      NuturalsFooter(
        onNavigate = onNavigate,
        onRequestQuote = onRequestQuote,
        onWhatsAppClick = onWhatsAppClick
      )
    }
  }
}
