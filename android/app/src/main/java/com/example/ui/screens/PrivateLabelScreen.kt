package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Check
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
import androidx.compose.ui.text.style.TextAlign
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
import com.example.ui.theme.MutedGoldLight
import com.example.ui.theme.NaturalBeige
import com.example.ui.theme.WarmIvory
import com.example.ui.theme.WarmIvoryLight

@Composable
fun PrivateLabelScreen(
  onNavigate: (Screen) -> Unit,
  onRequestQuote: () -> Unit,
  onWhatsAppClick: () -> Unit,
  modifier: Modifier = Modifier
) {
  LazyColumn(
    modifier = modifier
      .fillMaxSize()
      .background(WarmIvory)
      .testTag("private_label_screen")
  ) {
    // Hero with Coming Soon Badge
    item(key = "pl_hero") {
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
            text = "PRIVATE LABEL — COMING SOON",
            style = MaterialTheme.typography.labelSmall.copy(
              color = MutedGoldLight,
              fontSize = 10.sp,
              letterSpacing = 1.5.sp,
              fontWeight = FontWeight.Bold
            )
          )
        }

        Spacer(modifier = Modifier.height(14.dp))

        SectionHeader(
          title = "Your Brand.\nOur Products.",
          subtitle = "Build your own nuts and dried-fruit range with NUTURALS sourcing and supply support."
        )
      }
    }

    // Step Flow: SOURCE -> SELECT -> PACK -> YOUR BRAND -> YOUR MARKET
    item(key = "pl_flow") {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 20.dp, vertical = 24.dp)
      ) {
        Text(
          text = "THE PRIVATE LABEL JOURNEY",
          style = MaterialTheme.typography.labelSmall.copy(
            color = MutedGoldDark,
            fontWeight = FontWeight.Bold,
            letterSpacing = 2.sp
          )
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(
          modifier = Modifier
            .fillMaxWidth()
            .background(WarmIvoryLight, RoundedCornerShape(2.dp))
            .border(0.8.dp, BeigeBorder, RoundedCornerShape(2.dp))
            .padding(vertical = 14.dp, horizontal = 8.dp),
          horizontalArrangement = Arrangement.SpaceAround,
          verticalAlignment = Alignment.CenterVertically
        ) {
          LabelStep("SOURCE")
          Text("→", color = MutedGoldDark, fontSize = 12.sp)
          LabelStep("SELECT")
          Text("→", color = MutedGoldDark, fontSize = 12.sp)
          LabelStep("PACK")
          Text("→", color = MutedGoldDark, fontSize = 12.sp)
          LabelStep("YOUR BRAND")
          Text("→", color = MutedGoldDark, fontSize = 12.sp)
          LabelStep("YOUR MARKET")
        }
      }
    }

    // Solutions Grid
    item(key = "pl_solutions") {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 20.dp, vertical = 8.dp)
      ) {
        val solutions = listOf(
          "Custom Packaging" to "Matte stand-up barrier pouches, zipper doy-packs, PET jars, and luxury rigid gift boxes with nitrogen flush.",
          "Private Label Consultation" to "Helping emerging retail brands define product blends, net weight calibrations, and barcode logistics.",
          "Bulk Supply" to "Master cartons and food-service sacks ready for co-packers and private manufacturing facilities.",
          "Product Selection" to "Customizing whole-to-broken ratios, roast profiles, and salt/seasoning formulations.",
          "Business Support" to "Documentation, lot traceability, and reliable production scheduling."
        )

        solutions.forEach { (title, desc) ->
          Card(
            modifier = Modifier
              .fillMaxWidth()
              .padding(vertical = 5.dp)
              .border(0.8.dp, BeigeBorder, RoundedCornerShape(2.dp)),
            colors = CardDefaults.cardColors(containerColor = CardSurfaceLight)
          ) {
            Column(modifier = Modifier.padding(14.dp)) {
              Text(
                text = title,
                style = MaterialTheme.typography.titleMedium.copy(
                  fontFamily = EditorialSerif,
                  fontWeight = FontWeight.Bold,
                  color = ForestGreenDark,
                  fontSize = 16.sp
                )
              )
              Spacer(modifier = Modifier.height(4.dp))
              Text(
                text = desc,
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

    // Call to action
    item(key = "pl_cta") {
      Box(
        modifier = Modifier
          .fillMaxWidth()
          .padding(20.dp)
      ) {
        Button(
          onClick = onRequestQuote,
          colors = ButtonDefaults.buttonColors(containerColor = ForestGreenPrimary),
          shape = RoundedCornerShape(2.dp),
          modifier = Modifier.fillMaxWidth()
        ) {
          Text("Start a Private Label Project", color = Color.White, letterSpacing = 0.5.sp)
        }
      }
    }

    // Footer
    item(key = "pl_footer") {
      NuturalsFooter(
        onNavigate = onNavigate,
        onRequestQuote = onRequestQuote,
        onWhatsAppClick = onWhatsAppClick
      )
    }
  }
}

@Composable
private fun LabelStep(text: String) {
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
