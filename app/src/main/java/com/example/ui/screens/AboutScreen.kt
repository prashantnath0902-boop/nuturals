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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.ui.theme.NaturalBeige
import com.example.ui.theme.WarmIvory
import com.example.ui.theme.WarmIvoryLight

@Composable
fun AboutScreen(
  onNavigate: (Screen) -> Unit,
  onRequestQuote: () -> Unit,
  onWhatsAppClick: () -> Unit,
  modifier: Modifier = Modifier
) {
  LazyColumn(
    modifier = modifier
      .fillMaxSize()
      .background(WarmIvory)
      .testTag("about_screen")
  ) {
    // Hero Title
    item(key = "about_hero") {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .background(Cream)
          .padding(horizontal = 20.dp, vertical = 32.dp)
      ) {
        SectionHeader(
          eyebrow = "About NUTURALS",
          title = "Rooted in Nature.\nBuilt for Business.",
          subtitle = "Connecting conscientious agricultural terroirs with discerning commercial markets across the world."
        )
      }
    }

    // Story Paragraphs
    item(key = "story_paragraphs") {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 20.dp, vertical = 24.dp)
      ) {
        Text(
          text = "NUTURALS is built around a simple idea: bringing carefully selected natural foods to customers who value quality, consistency and dependable supply.",
          style = MaterialTheme.typography.headlineSmall.copy(
            fontFamily = EditorialSerif,
            fontWeight = FontWeight.Normal,
            fontSize = 20.sp,
            lineHeight = 28.sp,
            color = ForestGreenDark
          )
        )

        Spacer(modifier = Modifier.height(14.dp))

        Text(
          text = "We work to connect trusted sourcing with modern markets — from wholesalers and distributors to retailers and food businesses. In an industry frequently marked by unpredictable grading, fluctuating moisture, and opaque broker channels, NUTURALS operates on the principles of verified lot integrity, transparent specifications, and long-term commercial partnership.",
          style = MaterialTheme.typography.bodyMedium.copy(
            color = DarkCharcoalBody,
            fontSize = 14.5.sp,
            lineHeight = 23.sp
          )
        )

        Spacer(modifier = Modifier.height(14.dp))

        Text(
          text = "Our sourcing footprint extends across verified agricultural clusters: California almond orchards, South Asian cashew processors, Mediterranean fig and apricot valleys, and traditional wetland fox nut cultivators.",
          style = MaterialTheme.typography.bodyMedium.copy(
            color = DarkCharcoalBody,
            fontSize = 14.5.sp,
            lineHeight = 23.sp
          )
        )
      }
    }

    // Four Operating Pillars
    item(key = "operating_pillars") {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .background(NaturalBeige.copy(alpha = 0.35f))
          .padding(horizontal = 20.dp, vertical = 28.dp)
      ) {
        SectionHeader(
          eyebrow = "Core Philosophy",
          title = "The Four Pillars of NUTURALS",
          subtitle = "How we organize our sourcing, evaluation, and commercial fulfillment."
        )

        Spacer(modifier = Modifier.height(16.dp))

        val pillars = listOf(
          "01" to ("Carefully Sourced" to "Products selected through direct aggregator relationships and predefined sizing/moisture tolerances."),
          "02" to ("Quality Focused" to "Meticulous sensory evaluation, optical sort checks, and hygienic handling at every transit station."),
          "03" to ("Reliable Supply" to "Engineered containerization and scheduling that shields commercial clients from seasonal shortages."),
          "04" to ("Long-Term Partnerships" to "Transparent pricing structures, flexible trade credit evaluations, and dedicated account managers.")
        )

        pillars.forEach { (num, pair) ->
          val (title, desc) = pair
          Card(
            modifier = Modifier
              .fillMaxWidth()
              .padding(vertical = 5.dp)
              .border(0.8.dp, BeigeBorder, RoundedCornerShape(2.dp)),
            colors = CardDefaults.cardColors(containerColor = CardSurfaceLight)
          ) {
            Row(modifier = Modifier.padding(14.dp)) {
              Text(
                text = num,
                style = MaterialTheme.typography.titleMedium.copy(
                  fontFamily = EditorialSerif,
                  fontWeight = FontWeight.Bold,
                  color = MutedGoldDark
                )
              )
              Spacer(modifier = Modifier.width(14.dp))
              Column {
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
                  style = MaterialTheme.typography.bodySmall.copy(color = DarkCharcoalBody, lineHeight = 18.sp)
                )
              }
            }
          }
        }
      }
    }

    // CTA Box
    item(key = "about_cta") {
      Column(
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
              text = "Partner with NUTURALS",
              style = MaterialTheme.typography.headlineSmall.copy(fontFamily = EditorialSerif, color = ForestGreenDark)
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
              text = "Discuss wholesale supply, private label programs, or sample evaluation with our procurement team.",
              style = MaterialTheme.typography.bodySmall.copy(color = DarkCharcoalBody)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
              onClick = onRequestQuote,
              colors = ButtonDefaults.buttonColors(containerColor = ForestGreenPrimary),
              shape = RoundedCornerShape(2.dp),
              modifier = Modifier.fillMaxWidth()
            ) {
              Text("Request a Quote", color = Color.White)
            }
          }
        }
      }
    }

    // Footer
    item(key = "about_footer") {
      NuturalsFooter(
        onNavigate = onNavigate,
        onRequestQuote = onRequestQuote,
        onWhatsAppClick = onWhatsAppClick
      )
    }
  }
}
