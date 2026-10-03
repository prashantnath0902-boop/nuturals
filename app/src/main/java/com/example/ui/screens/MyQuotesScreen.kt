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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Inbox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import com.example.model.QuoteEnquiry
import com.example.ui.Screen
import com.example.ui.components.NuturalsFooter
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
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun MyQuotesScreen(
  enquiries: List<QuoteEnquiry>,
  onBack: () -> Unit,
  onNewQuoteClick: () -> Unit,
  onNavigate: (Screen) -> Unit,
  onWhatsAppClick: () -> Unit,
  modifier: Modifier = Modifier
) {
  val dateFormat = SimpleDateFormat("dd MMM yyyy, HH:mm", Locale.getDefault())

  LazyColumn(
    modifier = modifier
      .fillMaxSize()
      .background(WarmIvory)
      .testTag("my_quotes_screen")
  ) {
    // Back Bar
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
          text = "SUBMITTED TRADE RFQs",
          style = MaterialTheme.typography.labelSmall.copy(
            color = MutedGoldDark,
            letterSpacing = 1.2.sp,
            fontWeight = FontWeight.Bold
          )
        )
      }
    }

    // Hero title
    item(key = "quotes_title") {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .background(Cream)
          .padding(horizontal = 20.dp, vertical = 24.dp)
      ) {
        Text(
          text = "My Submitted Enquiries",
          style = MaterialTheme.typography.headlineMedium.copy(
            fontFamily = EditorialSerif,
            color = ForestGreenDark,
            fontSize = 24.sp
          )
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
          text = "Track your recent quotation requests submitted to the NUTURALS trade desk.",
          style = MaterialTheme.typography.bodySmall.copy(color = DarkCharcoalBody)
        )
      }
    }

    if (enquiries.isEmpty()) {
      item(key = "empty_inquiries") {
        Column(
          modifier = Modifier
            .fillMaxWidth()
            .padding(40.dp),
          horizontalAlignment = Alignment.CenterHorizontally
        ) {
          Icon(Icons.Outlined.Inbox, contentDescription = null, tint = MutedGold, modifier = Modifier.size(48.dp))
          Spacer(modifier = Modifier.height(14.dp))
          Text(
            text = "No Inquiries Submitted Yet",
            style = MaterialTheme.typography.titleMedium.copy(fontFamily = EditorialSerif, color = ForestGreenDark)
          )
          Spacer(modifier = Modifier.height(6.dp))
          Text(
            text = "When you request a quotation or product specifications, your record will appear here.",
            style = MaterialTheme.typography.bodySmall.copy(color = DarkCharcoalBody)
          )
          Spacer(modifier = Modifier.height(18.dp))
          Button(
            onClick = onNewQuoteClick,
            colors = ButtonDefaults.buttonColors(containerColor = ForestGreenPrimary),
            shape = RoundedCornerShape(2.dp)
          ) {
            Text("Request a Quote Now", color = Color.White)
          }
        }
      }
    } else {
      items(enquiries, key = { it.id }) { item ->
        Box(
          modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 8.dp)
        ) {
          Card(
            modifier = Modifier
              .fillMaxWidth()
              .border(0.8.dp, BeigeBorder, RoundedCornerShape(2.dp)),
            colors = CardDefaults.cardColors(containerColor = CardSurfaceLight)
          ) {
            Column(modifier = Modifier.padding(16.dp)) {
              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
              ) {
                Text(
                  text = "RFQ #${item.id}",
                  style = MaterialTheme.typography.labelSmall.copy(
                    fontWeight = FontWeight.Bold,
                    color = MutedGoldDark
                  )
                )

                Box(
                  modifier = Modifier
                    .background(ForestGreenDark, RoundedCornerShape(2.dp))
                    .padding(horizontal = 8.dp, vertical = 3.dp)
                ) {
                  Text(
                    text = item.status.uppercase(),
                    style = MaterialTheme.typography.labelSmall.copy(
                      color = Color.White,
                      fontSize = 9.5.sp,
                      letterSpacing = 1.sp
                    )
                  )
                }
              }

              Spacer(modifier = Modifier.height(8.dp))

              Text(
                text = item.productsInterestedIn,
                style = MaterialTheme.typography.titleMedium.copy(
                  fontFamily = EditorialSerif,
                  fontWeight = FontWeight.Bold,
                  color = ForestGreenDark,
                  fontSize = 17.sp
                )
              )

              Spacer(modifier = Modifier.height(4.dp))

              Text(
                text = "Company: ${item.companyName} | Type: ${item.businessType}",
                style = MaterialTheme.typography.bodySmall.copy(
                  color = DarkCharcoalBody.copy(alpha = 0.8f),
                  fontSize = 12.sp
                )
              )

              Text(
                text = "Quantity: ${item.approximateQuantity} | Packaging: ${item.packagingRequirement}",
                style = MaterialTheme.typography.bodySmall.copy(
                  color = DarkCharcoalBody.copy(alpha = 0.8f),
                  fontSize = 12.sp
                )
              )

              if (item.message.isNotBlank()) {
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                  text = "\"${item.message}\"",
                  style = MaterialTheme.typography.bodySmall.copy(
                    color = DarkCharcoalBody,
                    fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
                    fontSize = 12.sp
                  )
                )
              }

              Spacer(modifier = Modifier.height(10.dp))

              Text(
                text = "Submitted: ${dateFormat.format(Date(item.timestamp))}",
                style = MaterialTheme.typography.labelSmall.copy(
                  color = Color.Gray,
                  fontSize = 10.5.sp
                )
              )
            }
          }
        }
      }
    }

    // Footer
    item(key = "quotes_footer") {
      Spacer(modifier = Modifier.height(24.dp))
      NuturalsFooter(
        onNavigate = onNavigate,
        onRequestQuote = onNewQuoteClick,
        onWhatsAppClick = onWhatsAppClick
      )
    }
  }
}
