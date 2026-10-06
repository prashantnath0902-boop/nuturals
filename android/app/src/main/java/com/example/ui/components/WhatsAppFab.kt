package com.example.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.ForestGreenDark
import com.example.ui.theme.ForestGreenPrimary
import com.example.ui.theme.MutedGold

/**
 * Floating WhatsApp Inquiry CTA.
 * Designed specifically for B2B/Indian market communication.
 * Opens WhatsApp with pre-filled enquiry text.
 */
@Composable
fun WhatsAppFab(
  onClick: () -> Unit,
  modifier: Modifier = Modifier
) {
  Surface(
    modifier = modifier
      .shadow(elevation = 6.dp, shape = RoundedCornerShape(24.dp))
      .clip(RoundedCornerShape(24.dp))
      .clickable { onClick() }
      .border(width = 1.dp, color = MutedGold.copy(alpha = 0.5f), shape = RoundedCornerShape(24.dp))
      .testTag("whatsapp_fab_button"),
    color = ForestGreenDark,
    contentColor = Color.White
  ) {
    Row(
      modifier = Modifier.padding(horizontal = 16.dp, vertical = 11.dp),
      verticalAlignment = Alignment.CenterVertically
    ) {
      Box(
        modifier = Modifier
          .size(24.dp)
          .clip(CircleShape)
          .background(Color(0xFF25D366)), // Authentic WhatsApp Green
        contentAlignment = Alignment.Center
      ) {
        Icon(
          imageVector = Icons.Default.Chat,
          contentDescription = "WhatsApp",
          tint = Color.White,
          modifier = Modifier.size(14.dp)
        )
      }

      Spacer(modifier = Modifier.width(9.dp))

      Text(
        text = "Chat with NUTURALS",
        style = MaterialTheme.typography.labelLarge.copy(
          color = Color.White,
          fontSize = 13.sp,
          fontWeight = FontWeight.SemiBold,
          letterSpacing = 0.4.sp
        )
      )
    }
  }
}
