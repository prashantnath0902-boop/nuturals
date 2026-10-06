package com.example.ui.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.DarkCharcoal
import com.example.ui.theme.MutedGold
import com.example.ui.theme.MutedGoldLight

/**
 * Luxury Embossed Medallion Logo for NUTURALS.
 * Inspired by the hand-crafted antique bronze/gold medallion emblem on dark polished walnut wood.
 */
@Composable
fun NuturalsLogoMedallion(
  modifier: Modifier = Modifier,
  size: Dp = 140.dp,
  showTitle: Boolean = true,
  subtitleText: String = "ARTISANAL SEEDS & NUTS COLLECTION"
) {
  val infiniteTransition = rememberInfiniteTransition(label = "gold_sheen")
  val sheenProgress by infiniteTransition.animateFloat(
    initialValue = 0f,
    targetValue = 1f,
    animationSpec = infiniteRepeatable(
      animation = tween(4000, easing = LinearEasing),
      repeatMode = RepeatMode.Restart
    ),
    label = "sheen"
  )

  Column(
    modifier = modifier,
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
  ) {
    // Polished Dark Walnut Plaque Base with Brass Medallion
    Box(
      modifier = Modifier
        .size(size)
        .shadow(16.dp, CircleShape, spotColor = Color(0xFF000000))
        .clip(CircleShape)
        .background(
          Brush.radialGradient(
            colors = listOf(
              Color(0xFF2C1C13), // Warm walnut core
              Color(0xFF1E130D),
              Color(0xFF140C07),
              Color(0xFF0A0604)  // Outer deep espresso
            )
          )
        )
        .border(
          width = 3.dp,
          brush = Brush.sweepGradient(
            listOf(
              Color(0xFFC5A059),
              Color(0xFFF7E2A9),
              Color(0xFF8C682B),
              Color(0xFFE5C158),
              Color(0xFFC5A059)
            )
          ),
          shape = CircleShape
        ),
      contentAlignment = Alignment.Center
    ) {
      // Intricate concentric brass engravings, botanical relief & stars
      Canvas(modifier = Modifier.size(size * 0.92f)) {
        val w = this.size.width
        val h = this.size.height
        val center = Offset(w / 2f, h / 2f)
        val radius = w / 2f

        // Outer stepped rim
        drawCircle(
          brush = Brush.radialGradient(
            colors = listOf(Color(0xFF38251A), Color(0xFF19100B)),
            center = center,
            radius = radius
          ),
          radius = radius - 4f
        )

        // Engraved concentric gold circle
        drawCircle(
          color = Color(0xFFD4AF37).copy(alpha = 0.7f),
          radius = radius * 0.88f,
          style = Stroke(width = 2.5f)
        )

        // Inner dotted ring
        drawCircle(
          color = Color(0xFFA6823C).copy(alpha = 0.5f),
          radius = radius * 0.78f,
          style = Stroke(width = 1f)
        )

        // Botanical Laurel / Acorn / Almond relief in upper half
        val botanicalGold = Color(0xFFE5C158)
        val shadowBronze = Color(0xFF7A5824)

        // Center Almond
        val almondPath = Path().apply {
          moveTo(center.x, center.y - radius * 0.65f)
          cubicTo(
            center.x - radius * 0.15f, center.y - radius * 0.52f,
            center.x - radius * 0.12f, center.y - radius * 0.30f,
            center.x, center.y - radius * 0.22f
          )
          cubicTo(
            center.x + radius * 0.12f, center.y - radius * 0.30f,
            center.x + radius * 0.15f, center.y - radius * 0.52f,
            center.x, center.y - radius * 0.65f
          )
          close()
        }
        drawPath(almondPath, botanicalGold)

        // Almond rib shadow
        val almondVein = Path().apply {
          moveTo(center.x, center.y - radius * 0.60f)
          quadraticBezierTo(
            center.x - radius * 0.05f, center.y - radius * 0.42f,
            center.x, center.y - radius * 0.25f
          )
        }
        drawPath(almondVein, shadowBronze, style = Stroke(width = 2f))

        // Left Nut (Hazelnut)
        drawCircle(
          color = Color(0xFFC5A059),
          radius = radius * 0.09f,
          center = Offset(center.x - radius * 0.22f, center.y - radius * 0.40f)
        )

        // Right Nut (Acorn)
        drawCircle(
          color = Color(0xFFC5A059),
          radius = radius * 0.09f,
          center = Offset(center.x + radius * 0.22f, center.y - radius * 0.40f)
        )

        // Foliage wings
        val leftLeaf = Path().apply {
          moveTo(center.x - radius * 0.35f, center.y - radius * 0.45f)
          quadraticBezierTo(
            center.x - radius * 0.45f, center.y - radius * 0.58f,
            center.x - radius * 0.25f, center.y - radius * 0.52f
          )
          close()
        }
        drawPath(leftLeaf, Color(0xFFD4AF37))

        val rightLeaf = Path().apply {
          moveTo(center.x + radius * 0.35f, center.y - radius * 0.45f)
          quadraticBezierTo(
            center.x + radius * 0.45f, center.y - radius * 0.58f,
            center.x + radius * 0.25f, center.y - radius * 0.52f
          )
          close()
        }
        drawPath(rightLeaf, Color(0xFFD4AF37))

        // Dynamic subtle metallic sheen line
        val sheenX = w * sheenProgress
        drawLine(
          brush = Brush.horizontalGradient(
            colors = listOf(
              Color.Transparent,
              Color(0x33FFF5D7),
              Color(0x66FFFFFF),
              Color(0x33FFF5D7),
              Color.Transparent
            ),
            startX = sheenX - 40f,
            endX = sheenX + 40f
          ),
          start = Offset(0f, 0f),
          end = Offset(w, h),
          strokeWidth = 3f
        )
      }

      // Central Embossed Relief Plaque with "NUTURALS"
      Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(horizontal = 8.dp)
      ) {
        Spacer(modifier = Modifier.height(size * 0.22f))

        // Chiselled Relief Lettering
        Box(contentAlignment = Alignment.Center) {
          // Shadow / Bevel layer
          Text(
            text = "NUTURALS",
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Black,
            fontSize = (size.value * 0.16f).sp,
            letterSpacing = (size.value * 0.025f).sp,
            color = Color(0xFF0F0804),
            modifier = Modifier.padding(top = 2.dp)
          )
          // Gold Face Layer
          Text(
            text = "NUTURALS",
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Black,
            fontSize = (size.value * 0.16f).sp,
            letterSpacing = (size.value * 0.025f).sp,
            color = Color(0xFFFBF4DF)
          )
        }

        // Sub-ribbon Banner
        Box(
          modifier = Modifier
            .padding(top = 2.dp)
            .background(
              color = Color(0xFF1E130B),
              shape = RoundedCornerShape(2.dp)
            )
            .border(
              width = 0.8.dp,
              color = Color(0xFFC5A059),
              shape = RoundedCornerShape(2.dp)
            )
            .padding(horizontal = 6.dp, vertical = 1.dp)
        ) {
          Text(
            text = "ULTRA-PREMIUM RESERVE",
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold,
            fontSize = (size.value * 0.055f).sp,
            letterSpacing = 1.sp,
            color = Color(0xFFE5C158)
          )
        }

        // Starbursts
        Row(
          horizontalArrangement = Arrangement.Center,
          verticalAlignment = Alignment.CenterVertically,
          modifier = Modifier.padding(top = 3.dp)
        ) {
          Text(
            text = "✦  EST. 2023  ✦",
            fontFamily = FontFamily.Serif,
            fontSize = (size.value * 0.052f).sp,
            letterSpacing = 1.2.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFFD4AF37).copy(alpha = 0.85f)
          )
        }
      }
    }

    if (showTitle) {
      Spacer(modifier = Modifier.height(10.dp))
      Text(
        text = "NUTURALS",
        fontFamily = FontFamily.Serif,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
        letterSpacing = 4.sp,
        color = Color(0xFFFBF8F2)
      )
      Text(
        text = subtitleText,
        fontFamily = FontFamily.Serif,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        letterSpacing = 2.sp,
        color = Color(0xFFD4AF37),
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(top = 2.dp)
      )
      Text(
        text = "❖  SOVEREIGN RESERVE  ❖",
        fontFamily = FontFamily.Serif,
        fontSize = 10.sp,
        letterSpacing = 2.5.sp,
        color = Color(0xFFA89985),
        modifier = Modifier.padding(top = 4.dp)
      )
    }
  }
}
