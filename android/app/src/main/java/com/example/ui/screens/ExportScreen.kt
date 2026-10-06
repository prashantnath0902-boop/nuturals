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
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Description
import androidx.compose.material.icons.outlined.FlightTakeoff
import androidx.compose.material.icons.outlined.Inventory
import androidx.compose.material.icons.outlined.LocalShipping
import androidx.compose.material.icons.outlined.Public
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
fun ExportScreen(
  onNavigate: (Screen) -> Unit,
  onRequestQuote: () -> Unit,
  onWhatsAppClick: () -> Unit,
  modifier: Modifier = Modifier
) {
  LazyColumn(
    modifier = modifier
      .fillMaxSize()
      .background(WarmIvory)
      .testTag("export_screen")
  ) {
    // Header
    item(key = "export_hero") {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .background(Cream)
          .padding(horizontal = 20.dp, vertical = 32.dp)
      ) {
        SectionHeader(
          eyebrow = "International Sourcing & Trade",
          title = "Preparing NUTURALS for Global Markets",
          subtitle = "Building reliable supply relationships across markets with products designed for international business requirements."
        )
      }
    }

    // Export Pillars
    item(key = "export_pillars") {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 20.dp, vertical = 24.dp)
      ) {
        val features = listOf(
          ExportFeature("Global Sourcing", "Consolidating direct origin crops including California almonds, Indian cashews, Afghan figs, and Turkish apricots.", Icons.Outlined.Public),
          ExportFeature("Export Documentation", "Assisting international buyers with phytosanitary certificates, Certificates of Origin, Certificate of Analysis (COA), and commercial invoices.", Icons.Outlined.Description),
          ExportFeature("Flexible Packaging", "Industrial bulk (10kg / 25kg multi-wall bags, vacuum-sealed tins) to export-compliant retail cartons.", Icons.Outlined.Inventory),
          ExportFeature("Bulk Supply", "Scalable volume agreements for 20ft and 40ft FCL containerized shipping or consolidated LCL consignments.", Icons.Outlined.LocalShipping),
          ExportFeature("International Logistics Support", "Incoterms compliance (FOB, CFR, CIF) with container tracking and ocean freight coordination.", Icons.Outlined.FlightTakeoff)
        )

        features.forEach { feat ->
          Card(
            modifier = Modifier
              .fillMaxWidth()
              .padding(vertical = 6.dp)
              .border(0.8.dp, BeigeBorder, RoundedCornerShape(2.dp)),
            colors = CardDefaults.cardColors(containerColor = CardSurfaceLight)
          ) {
            Row(
              modifier = Modifier.padding(16.dp),
              verticalAlignment = Alignment.Top
            ) {
              Box(
                modifier = Modifier
                  .size(36.dp)
                  .background(Cream, RoundedCornerShape(2.dp))
                  .border(0.8.dp, MutedGold.copy(alpha = 0.5f), RoundedCornerShape(2.dp)),
                contentAlignment = Alignment.Center
              ) {
                Icon(feat.icon, contentDescription = null, tint = ForestGreenDark, modifier = Modifier.size(18.dp))
              }

              Spacer(modifier = Modifier.width(14.dp))

              Column {
                Text(
                  text = feat.title,
                  style = MaterialTheme.typography.titleMedium.copy(
                    fontFamily = EditorialSerif,
                    fontWeight = FontWeight.Bold,
                    color = ForestGreenDark,
                    fontSize = 16.sp
                  )
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                  text = feat.desc,
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

    // Trade Desk CTA
    item(key = "export_cta") {
      Box(
        modifier = Modifier
          .fillMaxWidth()
          .padding(20.dp)
      ) {
        Card(
          modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, ForestGreenPrimary, RoundedCornerShape(2.dp)),
          colors = CardDefaults.cardColors(containerColor = WarmIvoryLight)
        ) {
          Column(modifier = Modifier.padding(20.dp)) {
            Text(
              text = "Initiate an Export Procurement Enquiry",
              style = MaterialTheme.typography.titleLarge.copy(fontFamily = EditorialSerif, color = ForestGreenDark)
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
              text = "Connect with our international trade desk to specify port destination, container configuration, and required trade certifications.",
              style = MaterialTheme.typography.bodySmall.copy(color = DarkCharcoalBody)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
              onClick = onRequestQuote,
              colors = ButtonDefaults.buttonColors(containerColor = ForestGreenPrimary),
              shape = RoundedCornerShape(2.dp),
              modifier = Modifier.fillMaxWidth()
            ) {
              Text("Submit Export Inquiry", color = Color.White)
            }
          }
        }
      }
    }

    // Footer
    item(key = "export_footer") {
      NuturalsFooter(
        onNavigate = onNavigate,
        onRequestQuote = onRequestQuote,
        onWhatsAppClick = onWhatsAppClick
      )
    }
  }
}

private data class ExportFeature(
  val title: String,
  val desc: String,
  val icon: androidx.compose.ui.graphics.vector.ImageVector
)
