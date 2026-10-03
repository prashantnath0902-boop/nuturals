package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Inventory2
import androidx.compose.material.icons.outlined.Place
import androidx.compose.material.icons.outlined.RequestQuote
import androidx.compose.material.icons.outlined.Verified
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.Product
import com.example.ui.theme.ImperialGold
import com.example.ui.theme.ImperialGoldBright
import com.example.ui.theme.ImperialGoldDark
import com.example.ui.theme.IvoryWarm
import com.example.ui.theme.WalnutBorder
import com.example.ui.theme.WalnutDarkest
import com.example.ui.theme.WalnutSurface
import com.example.ui.theme.WalnutSurfaceVariant

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ProductCard(
  product: Product,
  onCardClick: () -> Unit,
  onRequestQuote: () -> Unit,
  modifier: Modifier = Modifier
) {
  Card(
    modifier = modifier
      .fillMaxWidth()
      .clip(RoundedCornerShape(3.dp))
      .border(0.8.dp, Color(0xFF4A3422), RoundedCornerShape(3.dp))
      .clickable { onCardClick() }
      .testTag("product_card_${product.id}"),
    colors = CardDefaults.cardColors(containerColor = Color(0xFF160F0A)),
    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
  ) {
    Column(modifier = Modifier.fillMaxWidth()) {
      // Product Visual Illustration Area
      Box(
        modifier = Modifier
          .fillMaxWidth()
          .height(180.dp)
          .background(Color(0xFF1E140C))
      ) {
        ProductArtCanvas(
          iconType = product.visualIconType,
          modifier = Modifier.fillMaxSize(),
          backgroundColor = Color(0xFF1E140C)
        )

        // Category Tag (top-left)
        Box(
          modifier = Modifier
            .padding(10.dp)
            .align(Alignment.TopStart)
            .background(Color(0xFF0F0A06).copy(alpha = 0.9f), RoundedCornerShape(2.dp))
            .border(0.6.dp, ImperialGold.copy(alpha = 0.7f), RoundedCornerShape(2.dp))
            .padding(horizontal = 8.dp, vertical = 4.dp)
        ) {
          Text(
            text = product.category.displayName.uppercase(),
            style = MaterialTheme.typography.labelSmall.copy(
              color = ImperialGoldBright,
              fontSize = 9.sp,
              letterSpacing = 1.2.sp,
              fontWeight = FontWeight.Bold
            )
          )
        }

        // Origin Badge (top-right)
        Box(
          modifier = Modifier
            .padding(10.dp)
            .align(Alignment.TopEnd)
            .background(Color(0xFF22160E), RoundedCornerShape(2.dp))
            .border(0.6.dp, Color(0xFF5A412A), RoundedCornerShape(2.dp))
            .padding(horizontal = 8.dp, vertical = 4.dp)
        ) {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
              imageVector = Icons.Outlined.Place,
              contentDescription = null,
              tint = ImperialGold,
              modifier = Modifier.size(11.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
              text = product.origin,
              style = MaterialTheme.typography.labelSmall.copy(
                color = Color(0xFFFBF4DF),
                fontSize = 10.sp,
                fontWeight = FontWeight.Medium
              )
            )
          }
        }
      }

      // Content Body
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .padding(16.dp)
      ) {
        // Product Name & Chapter
        Text(
          text = product.name,
          fontFamily = FontFamily.Serif,
          fontWeight = FontWeight.Bold,
          fontSize = 18.sp,
          color = Color(0xFFFBF4DF),
          maxLines = 1,
          overflow = TextOverflow.Ellipsis
        )

        if (product.chapter.isNotBlank()) {
          Text(
            text = product.chapter,
            fontSize = 9.5.sp,
            fontFamily = FontFamily.Serif,
            letterSpacing = 1.sp,
            color = ImperialGold,
            modifier = Modifier.padding(top = 2.dp)
          )
        }

        Spacer(modifier = Modifier.height(6.dp))

        // Short Description
        Text(
          text = product.description,
          fontFamily = FontFamily.Serif,
          style = MaterialTheme.typography.bodySmall.copy(
            color = Color(0xFFC7B9A5),
            fontSize = 12.sp,
            lineHeight = 17.sp
          ),
          maxLines = 2,
          overflow = TextOverflow.Ellipsis
        )

        Spacer(modifier = Modifier.height(10.dp))

        // Specification Chips
        Column(
          modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF20160F), RoundedCornerShape(2.dp))
            .border(0.6.dp, Color(0xFF3B2819), RoundedCornerShape(2.dp))
            .padding(8.dp),
          verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Outlined.Verified, contentDescription = null, tint = ImperialGold, modifier = Modifier.size(12.dp))
            Spacer(modifier = Modifier.width(6.dp))
            Text(
              text = "Grade: ",
              style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold, color = ImperialGoldBright, fontSize = 10.sp)
            )
            Text(
              text = product.grade,
              style = MaterialTheme.typography.labelSmall.copy(color = Color(0xFFE2D7C8), fontSize = 10.sp),
              maxLines = 1,
              overflow = TextOverflow.Ellipsis
            )
          }

          Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Outlined.Inventory2, contentDescription = null, tint = ImperialGold, modifier = Modifier.size(12.dp))
            Spacer(modifier = Modifier.width(6.dp))
            Text(
              text = "Packaging: ",
              style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold, color = ImperialGoldBright, fontSize = 10.sp)
            )
            Text(
              text = product.packagingOptions.firstOrNull() ?: product.packaging,
              style = MaterialTheme.typography.labelSmall.copy(color = Color(0xFFE2D7C8), fontSize = 10.sp),
              maxLines = 1,
              overflow = TextOverflow.Ellipsis
            )
          }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Price indicator (Shows Sovereign allocation and retail rate)
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          Column {
            Text(
              text = if (product.sovereignPrice.isNotBlank()) product.sovereignPrice else product.priceDisplay,
              fontFamily = FontFamily.Serif,
              style = MaterialTheme.typography.labelMedium.copy(
                color = ImperialGoldBright,
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp,
                letterSpacing = 0.5.sp
              )
            )
            Text(
              text = "MOQ: ${product.moq}",
              fontSize = 9.5.sp,
              color = Color(0xFF8F806E)
            )
          }

          Button(
            onClick = onRequestQuote,
            colors = ButtonDefaults.buttonColors(
              containerColor = ImperialGold,
              contentColor = WalnutDarkest
            ),
            shape = RoundedCornerShape(2.dp),
            contentPadding = PaddingValues(horizontal = 14.dp, vertical = 7.dp)
          ) {
            Icon(
              imageVector = Icons.Outlined.RequestQuote,
              contentDescription = null,
              tint = WalnutDarkest,
              modifier = Modifier.size(13.dp)
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
              text = "Inquire",
              fontSize = 11.5.sp,
              fontWeight = FontWeight.Bold,
              color = WalnutDarkest
            )
          }
        }
      }
    }
  }
}
