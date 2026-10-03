package com.example.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.ui.theme.ForestGreenDark
import com.example.ui.theme.ForestGreenPrimary
import com.example.ui.theme.MutedGold
import com.example.ui.theme.MutedGoldDark
import com.example.ui.theme.NaturalBeige
import com.example.ui.theme.WarmIvory

/**
 * Editorial Botanical Food Illustration Canvas.
 * Renders exquisite, vector-based food illustrations for NUTURALS products and categories
 * with natural shadows, linen textures, and warm stone undertones.
 */
@Composable
fun ProductArtCanvas(
  iconType: String,
  modifier: Modifier = Modifier,
  canvasSize: Dp = 180.dp,
  backgroundColor: Color = NaturalBeige.copy(alpha = 0.5f)
) {
  Box(
    modifier = modifier
      .background(backgroundColor),
    contentAlignment = Alignment.Center
  ) {
    Canvas(modifier = Modifier.fillMaxSize()) {
      val w = size.width
      val h = size.height
      val cx = w / 2f
      val cy = h / 2f

      // Subtle warm backdrop platter/linen circle
      drawCircle(
        brush = Brush.radialGradient(
          colors = listOf(WarmIvory, NaturalBeige.copy(alpha = 0.8f)),
          center = Offset(cx, cy),
          radius = w * 0.46f
        ),
        radius = w * 0.42f,
        center = Offset(cx, cy)
      )

      // Thin gold accent concentric ring
      drawCircle(
        color = MutedGold.copy(alpha = 0.35f),
        radius = w * 0.39f,
        center = Offset(cx, cy),
        style = Stroke(width = 1.2.dp.toPx())
      )

      when (iconType.lowercase()) {
        "almond" -> drawAlmondArt(cx, cy, w, h)
        "cashew" -> drawCashewArt(cx, cy, w, h)
        "pistachio" -> drawPistachioArt(cx, cy, w, h)
        "walnut" -> drawWalnutArt(cx, cy, w, h)
        "raisin" -> drawRaisinArt(cx, cy, w, h)
        "date" -> drawDateArt(cx, cy, w, h)
        "fig" -> drawFigArt(cx, cy, w, h)
        "apricot" -> drawApricotArt(cx, cy, w, h)
        "cranberry" -> drawCranberryArt(cx, cy, w, h)
        "prune" -> drawPruneArt(cx, cy, w, h)
        "makhana" -> drawMakhanaArt(cx, cy, w, h)
        "chia", "pumpkin_seed" -> drawSeedArt(cx, cy, w, h)
        else -> drawBotanicalLeafArt(cx, cy, w, h)
      }
    }
  }
}

private fun DrawScope.drawAlmondArt(cx: Float, cy: Float, w: Float, h: Float) {
  val almondColor = Color(0xFFC48B57)
  val shadowColor = Color(0xFF915E34)
  val highlightColor = Color(0xFFDFAB7A)

  // Natural shadow
  drawOval(
    color = Color(0x22000000),
    topLeft = Offset(cx - w * 0.22f, cy + h * 0.16f),
    size = Size(w * 0.44f, h * 0.12f)
  )

  // Almond body
  val path = Path().apply {
    moveTo(cx, cy - h * 0.22f)
    cubicTo(cx + w * 0.22f, cy - h * 0.08f, cx + w * 0.20f, cy + h * 0.16f, cx, cy + h * 0.22f)
    cubicTo(cx - w * 0.20f, cy + h * 0.16f, cx - w * 0.22f, cy - h * 0.08f, cx, cy - h * 0.22f)
    close()
  }
  drawPath(path, brush = Brush.linearGradient(listOf(highlightColor, almondColor, shadowColor)))

  // Delicate surface texture striations
  val stroke = Stroke(width = 1.5.dp.toPx(), cap = StrokeCap.Round)
  drawLine(
    color = shadowColor.copy(alpha = 0.6f),
    start = Offset(cx, cy - h * 0.15f),
    end = Offset(cx, cy + h * 0.15f),
    strokeWidth = stroke.width
  )
  drawLine(
    color = highlightColor.copy(alpha = 0.8f),
    start = Offset(cx - w * 0.08f, cy - h * 0.08f),
    end = Offset(cx - w * 0.06f, cy + h * 0.08f),
    strokeWidth = 1.dp.toPx()
  )
}

private fun DrawScope.drawCashewArt(cx: Float, cy: Float, w: Float, h: Float) {
  val cashewIvory = Color(0xFFF7EBD2)
  val cashewTone = Color(0xFFE2CCA8)
  val cashewShadow = Color(0xFFBEA178)

  // Shadow
  drawOval(
    color = Color(0x22000000),
    topLeft = Offset(cx - w * 0.20f, cy + h * 0.14f),
    size = Size(w * 0.42f, h * 0.12f)
  )

  // Crescent cashew kidney curve
  val path = Path().apply {
    moveTo(cx - w * 0.12f, cy - h * 0.18f)
    cubicTo(cx + w * 0.22f, cy - h * 0.14f, cx + w * 0.22f, cy + h * 0.14f, cx - w * 0.02f, cy + h * 0.20f)
    cubicTo(cx - w * 0.18f, cy + h * 0.22f, cx - w * 0.20f, cy + h * 0.06f, cx - w * 0.04f, cy + h * 0.02f)
    cubicTo(cx + w * 0.06f, cy - h * 0.02f, cx + w * 0.05f, cy - h * 0.08f, cx - w * 0.12f, cy - h * 0.18f)
    close()
  }
  drawPath(path, brush = Brush.linearGradient(listOf(cashewIvory, cashewTone, cashewShadow)))
  drawPath(path, color = cashewShadow.copy(alpha = 0.4f), style = Stroke(width = 1.dp.toPx()))
}

private fun DrawScope.drawPistachioArt(cx: Float, cy: Float, w: Float, h: Float) {
  val shellColor = Color(0xFFEADBBE)
  val kernelGreen = Color(0xFF6F9940)
  val kernelPurple = Color(0xFF7A4A58)

  // Shadow
  drawOval(
    color = Color(0x20000000),
    topLeft = Offset(cx - w * 0.22f, cy + h * 0.16f),
    size = Size(w * 0.44f, h * 0.11f)
  )

  // Open pistachio green kernel
  val kernelPath = Path().apply {
    moveTo(cx, cy - h * 0.14f)
    cubicTo(cx + w * 0.12f, cy - h * 0.06f, cx + w * 0.12f, cy + h * 0.08f, cx, cy + h * 0.14f)
    cubicTo(cx - w * 0.12f, cy + h * 0.08f, cx - w * 0.12f, cy - h * 0.06f, cx, cy - h * 0.14f)
    close()
  }
  drawPath(kernelPath, brush = Brush.verticalGradient(listOf(kernelPurple, kernelGreen)))

  // Left shell half
  val leftShell = Path().apply {
    moveTo(cx - w * 0.02f, cy - h * 0.20f)
    cubicTo(cx - w * 0.24f, cy - h * 0.05f, cx - w * 0.22f, cy + h * 0.16f, cx - w * 0.02f, cy + h * 0.20f)
    cubicTo(cx - w * 0.10f, cy + h * 0.10f, cx - w * 0.10f, cy - h * 0.10f, cx - w * 0.02f, cy - h * 0.20f)
    close()
  }
  drawPath(leftShell, color = shellColor)
  drawPath(leftShell, color = Color(0xFFBCA77D), style = Stroke(width = 1.2.dp.toPx()))

  // Right shell half
  val rightShell = Path().apply {
    moveTo(cx + w * 0.02f, cy - h * 0.20f)
    cubicTo(cx + w * 0.24f, cy - h * 0.05f, cx + w * 0.22f, cy + h * 0.16f, cx + w * 0.02f, cy + h * 0.20f)
    cubicTo(cx + w * 0.10f, cy + h * 0.10f, cx + w * 0.10f, cy - h * 0.10f, cx + w * 0.02f, cy - h * 0.20f)
    close()
  }
  drawPath(rightShell, color = shellColor)
  drawPath(rightShell, color = Color(0xFFBCA77D), style = Stroke(width = 1.2.dp.toPx()))
}

private fun DrawScope.drawWalnutArt(cx: Float, cy: Float, w: Float, h: Float) {
  val walnutGold = Color(0xFFCE9B61)
  val walnutDeep = Color(0xFF8B5A2B)

  drawOval(
    color = Color(0x22000000),
    topLeft = Offset(cx - w * 0.20f, cy + h * 0.16f),
    size = Size(w * 0.40f, h * 0.10f)
  )

  // Brain-like lobe left
  drawOval(
    color = walnutGold,
    topLeft = Offset(cx - w * 0.18f, cy - h * 0.14f),
    size = Size(w * 0.17f, h * 0.28f)
  )
  drawOval(
    color = walnutGold,
    topLeft = Offset(cx + w * 0.01f, cy - h * 0.14f),
    size = Size(w * 0.17f, h * 0.28f)
  )
  drawCircle(
    color = walnutDeep,
    radius = w * 0.04f,
    center = Offset(cx, cy)
  )
  drawLine(
    color = walnutDeep,
    start = Offset(cx, cy - h * 0.16f),
    end = Offset(cx, cy + h * 0.16f),
    strokeWidth = 2.dp.toPx(),
    cap = StrokeCap.Round
  )
}

private fun DrawScope.drawDateArt(cx: Float, cy: Float, w: Float, h: Float) {
  val dateDark = Color(0xFF421E14)
  val dateAmber = Color(0xFF753A22)
  val dateSheen = Color(0xFFA65C3B)

  drawOval(
    color = Color(0x20000000),
    topLeft = Offset(cx - w * 0.22f, cy + h * 0.16f),
    size = Size(w * 0.44f, h * 0.12f)
  )

  val path = Path().apply {
    moveTo(cx, cy - h * 0.22f)
    cubicTo(cx + w * 0.16f, cy - h * 0.14f, cx + w * 0.16f, cy + h * 0.14f, cx, cy + h * 0.22f)
    cubicTo(cx - w * 0.16f, cy + h * 0.14f, cx - w * 0.16f, cy - h * 0.14f, cx, cy - h * 0.22f)
    close()
  }
  drawPath(path, brush = Brush.verticalGradient(listOf(dateSheen, dateAmber, dateDark)))
  // Subtle wrinkles
  drawLine(
    color = dateDark.copy(alpha = 0.5f),
    start = Offset(cx - w * 0.06f, cy - h * 0.08f),
    end = Offset(cx + w * 0.06f, cy + h * 0.08f),
    strokeWidth = 1.dp.toPx()
  )
}

private fun DrawScope.drawRaisinArt(cx: Float, cy: Float, w: Float, h: Float) {
  val goldRaisin = Color(0xFFCFA03E)
  val deepGold = Color(0xFF916A1E)

  drawOval(
    color = Color(0x1A000000),
    topLeft = Offset(cx - w * 0.18f, cy + h * 0.14f),
    size = Size(w * 0.36f, h * 0.10f)
  )

  drawOval(
    brush = Brush.linearGradient(listOf(goldRaisin, deepGold)),
    topLeft = Offset(cx - w * 0.10f, cy - h * 0.20f),
    size = Size(w * 0.20f, h * 0.38f)
  )
}

private fun DrawScope.drawFigArt(cx: Float, cy: Float, w: Float, h: Float) {
  val figAmber = Color(0xFFB57C48)
  val figBrown = Color(0xFF6B4527)

  drawOval(
    color = Color(0x22000000),
    topLeft = Offset(cx - w * 0.22f, cy + h * 0.16f),
    size = Size(w * 0.44f, h * 0.10f)
  )

  // Tear-drop fig
  val path = Path().apply {
    moveTo(cx, cy - h * 0.22f)
    cubicTo(cx + w * 0.10f, cy - h * 0.08f, cx + w * 0.22f, cy + h * 0.08f, cx + w * 0.14f, cy + h * 0.20f)
    cubicTo(cx, cy + h * 0.24f, cx - w * 0.14f, cy + h * 0.20f, cx - w * 0.22f, cy + h * 0.08f)
    cubicTo(cx - w * 0.10f, cy - h * 0.08f, cx, cy - h * 0.22f, cx, cy - h * 0.22f)
    close()
  }
  drawPath(path, brush = Brush.verticalGradient(listOf(figAmber, figBrown)))
}

private fun DrawScope.drawApricotArt(cx: Float, cy: Float, w: Float, h: Float) {
  val apricot = Color(0xFFE89437)
  val deepOrange = Color(0xFFB86314)

  drawCircle(
    brush = Brush.radialGradient(listOf(apricot, deepOrange)),
    radius = w * 0.18f,
    center = Offset(cx, cy)
  )
  drawLine(
    color = deepOrange,
    start = Offset(cx, cy - h * 0.16f),
    end = Offset(cx, cy + h * 0.14f),
    strokeWidth = 1.5.dp.toPx()
  )
}

private fun DrawScope.drawCranberryArt(cx: Float, cy: Float, w: Float, h: Float) {
  val redRuby = Color(0xFF9E1F35)
  val redDark = Color(0xFF5E0B1B)

  drawCircle(
    brush = Brush.radialGradient(listOf(Color(0xFFBA2B46), redRuby, redDark)),
    radius = w * 0.16f,
    center = Offset(cx, cy)
  )
}

private fun DrawScope.drawPruneArt(cx: Float, cy: Float, w: Float, h: Float) {
  val plumDark = Color(0xFF331626)
  val plumTone = Color(0xFF542540)

  drawOval(
    brush = Brush.linearGradient(listOf(plumTone, plumDark)),
    topLeft = Offset(cx - w * 0.14f, cy - h * 0.20f),
    size = Size(w * 0.28f, h * 0.38f)
  )
}

private fun DrawScope.drawMakhanaArt(cx: Float, cy: Float, w: Float, h: Float) {
  val creamWhite = Color(0xFFFCFAF4)
  val toastSpot = Color(0xFFC7A97E)

  drawCircle(
    color = creamWhite,
    radius = w * 0.18f,
    center = Offset(cx, cy)
  )
  drawCircle(
    color = toastSpot,
    radius = w * 0.04f,
    center = Offset(cx - w * 0.05f, cy - h * 0.04f)
  )
  drawCircle(
    color = toastSpot.copy(alpha = 0.7f),
    radius = w * 0.03f,
    center = Offset(cx + w * 0.06f, cy + h * 0.03f)
  )
}

private fun DrawScope.drawSeedArt(cx: Float, cy: Float, w: Float, h: Float) {
  val darkSeed = Color(0xFF3A4D39)
  val lightSeed = Color(0xFF597354)

  drawOval(
    brush = Brush.linearGradient(listOf(lightSeed, darkSeed)),
    topLeft = Offset(cx - w * 0.12f, cy - h * 0.18f),
    size = Size(w * 0.24f, h * 0.36f)
  )
}

private fun DrawScope.drawBotanicalLeafArt(cx: Float, cy: Float, w: Float, h: Float) {
  val path = Path().apply {
    moveTo(cx, cy - h * 0.22f)
    cubicTo(cx + w * 0.18f, cy - h * 0.05f, cx + w * 0.15f, cy + h * 0.14f, cx, cy + h * 0.22f)
    cubicTo(cx - w * 0.15f, cy + h * 0.14f, cx - w * 0.18f, cy - h * 0.05f, cx, cy - h * 0.22f)
    close()
  }
  drawPath(path, brush = Brush.verticalGradient(listOf(MutedGold, ForestGreenPrimary)))
}
