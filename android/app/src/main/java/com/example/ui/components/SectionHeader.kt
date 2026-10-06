package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.DarkCharcoalBody
import com.example.ui.theme.EditorialSerif
import com.example.ui.theme.ForestGreenDark
import com.example.ui.theme.ForestGreenPrimary
import com.example.ui.theme.MutedGold
import com.example.ui.theme.MutedGoldDark

@Composable
fun SectionHeader(
  eyebrow: String? = null,
  title: String,
  subtitle: String? = null,
  alignment: Alignment.Horizontal = Alignment.Start,
  textColor: Color = ForestGreenDark,
  accentColor: Color = MutedGold,
  modifier: Modifier = Modifier
) {
  val textAlign = when (alignment) {
    Alignment.CenterHorizontally -> TextAlign.Center
    Alignment.End -> TextAlign.End
    else -> TextAlign.Start
  }

  Column(
    modifier = modifier.fillMaxWidth(),
    horizontalAlignment = alignment
  ) {
    if (!eyebrow.isNullOrBlank()) {
      Text(
        text = eyebrow.uppercase(),
        style = MaterialTheme.typography.labelSmall.copy(
          fontSize = 11.sp,
          fontWeight = FontWeight.Bold,
          letterSpacing = 2.5.sp,
          color = MutedGoldDark
        ),
        textAlign = textAlign
      )
      Spacer(modifier = Modifier.height(6.dp))
    }

    Text(
      text = title,
      style = MaterialTheme.typography.headlineLarge.copy(
        fontFamily = EditorialSerif,
        fontWeight = FontWeight.Normal,
        fontSize = 26.sp,
        lineHeight = 32.sp,
        letterSpacing = 0.2.sp,
        color = textColor
      ),
      textAlign = textAlign
    )

    // Subtle gold divider
    Spacer(modifier = Modifier.height(8.dp))
    Box(
      modifier = Modifier
        .width(42.dp)
        .height(1.8.dp)
        .background(accentColor)
    )

    if (!subtitle.isNullOrBlank()) {
      Spacer(modifier = Modifier.height(8.dp))
      Text(
        text = subtitle,
        style = MaterialTheme.typography.bodyMedium.copy(
          fontSize = 14.sp,
          lineHeight = 22.sp,
          color = DarkCharcoalBody.copy(alpha = 0.85f)
        ),
        textAlign = textAlign
      )
    }
  }
}
