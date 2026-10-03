package com.example.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material.icons.outlined.Place
import androidx.compose.material.icons.outlined.Verified
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
import kotlin.math.sqrt

data class SourcingPin(
  val id: String,
  val name: String,
  val products: String,
  val description: String,
  val primaryCrop: String,
  val normX: Float, // 0.0f to 1.0f
  val normY: Float  // 0.0f to 1.0f
)

val DEFAULT_SOURCING_PINS = listOf(
  SourcingPin(
    id = "usa",
    name = "United States (California)",
    products = "California Almonds, Walnuts, Dried Cranberries",
    description = "Premier Mediterranean-climate Central Valley orchards known for stringent sizing, uniform mechanical harvesting, and reliable volume.",
    primaryCrop = "Almonds & Walnuts",
    normX = 0.20f,
    normY = 0.35f
  ),
  SourcingPin(
    id = "india",
    name = "India",
    products = "Whole Cashew Kernels (W180-W320), Golden Raisins, Phool Makhana",
    description = "Rich agricultural belts in Bihar, Maharashtra, and Goa with multi-generation grading precision, natural sun curing, and direct farmgate relationships.",
    primaryCrop = "Cashews & Makhana",
    normX = 0.68f,
    normY = 0.49f
  ),
  SourcingPin(
    id = "middle-east",
    name = "Middle East & Iran",
    products = "Jumbo In-Shell Pistachios, Medjool Dates, Saffron",
    description = "Arid heritage terroirs producing exceptional naturally opened pistachios with intense aromatic oils and amber Medjool dates.",
    primaryCrop = "Pistachios & Dates",
    normX = 0.58f,
    normY = 0.40f
  ),
  SourcingPin(
    id = "afghanistan",
    name = "Afghanistan",
    products = "Sun-Dried Afghani Figs, Black Raisins (Kishmish)",
    description = "Highland arid valleys celebrated for slow sun drying without chemical accelerators, yielding intense natural fructose and supple textures.",
    primaryCrop = "Dried Figs & Raisins",
    normX = 0.63f,
    normY = 0.38f
  ),
  SourcingPin(
    id = "turkey",
    name = "Turkey (Malatya)",
    products = "Sun-Dried Apricots (Whole & Diced), Turkish Figs, Hazelnuts",
    description = "Renowned Malatya apricot groves offering distinctive honeyed sweetness, optical color grading, and calibrated sizing from Size 1 to 4.",
    primaryCrop = "Apricots & Figs",
    normX = 0.54f,
    normY = 0.33f
  ),
  SourcingPin(
    id = "chile",
    name = "Chile (South America)",
    products = "Extra Light Walnut Halves (80%+), Pitted Prunes",
    description = "Andean glacial meltwater irrigation providing exceptionally clean, light-colored walnut meat with high Omega-3 profiles.",
    primaryCrop = "Light Walnuts & Prunes",
    normX = 0.29f,
    normY = 0.74f
  ),
  SourcingPin(
    id = "australia",
    name = "Australia",
    products = "Premium Macadamias, Nonpareil Almonds",
    description = "Advanced phytosanitary standards and Southern Hemisphere counter-cyclical harvest delivering fresh crop availability year-round.",
    primaryCrop = "Macadamias & Almonds",
    normX = 0.84f,
    normY = 0.73f
  )
)

/**
 * Interactive World Map Component for NUTURALS.
 * Visualizes global sourcing regions with clickable beacon pins,
 * landmass outlines, and an editorial origin inspector card.
 */
@Composable
fun InteractiveWorldMap(
  onOriginSelected: (SourcingPin) -> Unit,
  onExploreProductsFromOrigin: (SourcingPin) -> Unit,
  modifier: Modifier = Modifier
) {
  var selectedPin by remember { mutableStateOf<SourcingPin>(DEFAULT_SOURCING_PINS[0]) }

  // Infinite pulsing beacon animation
  val infiniteTransition = rememberInfiniteTransition(label = "pin_pulse")
  val pulseRadiusScale by infiniteTransition.animateFloat(
    initialValue = 1f,
    targetValue = 2.4f,
    animationSpec = infiniteRepeatable(
      animation = tween(1800, easing = FastOutSlowInEasing),
      repeatMode = RepeatMode.Restart
    ),
    label = "pulse_scale"
  )
  val pulseAlpha by infiniteTransition.animateFloat(
    initialValue = 0.7f,
    targetValue = 0.0f,
    animationSpec = infiniteRepeatable(
      animation = tween(1800, easing = FastOutSlowInEasing),
      repeatMode = RepeatMode.Restart
    ),
    label = "pulse_alpha"
  )

  Column(
    modifier = modifier
      .fillMaxWidth()
      .testTag("interactive_world_map_container")
  ) {
    // Map Canvas Card
    Card(
      modifier = Modifier
        .fillMaxWidth()
        .border(1.dp, BeigeBorder, RoundedCornerShape(3.dp)),
      colors = CardDefaults.cardColors(containerColor = ForestGreenDark),
      elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
      Box(
        modifier = Modifier
          .fillMaxWidth()
          .aspectRatio(1.85f)
      ) {
        Canvas(
          modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
              detectTapGestures { tapOffset ->
                val w = size.width
                val h = size.height

                // Find closest pin within touch radius (48dp equivalent)
                val hitDistanceThreshold = 44.dp.toPx()
                var closest: SourcingPin? = null
                var minDistance = Float.MAX_VALUE

                DEFAULT_SOURCING_PINS.forEach { pin ->
                  val pinX = pin.normX * w
                  val pinY = pin.normY * h
                  val dx = tapOffset.x - pinX
                  val dy = tapOffset.y - pinY
                  val dist = sqrt(dx * dx + dy * dy)
                  if (dist < hitDistanceThreshold && dist < minDistance) {
                    minDistance = dist
                    closest = pin
                  }
                }

                closest?.let {
                  selectedPin = it
                  onOriginSelected(it)
                }
              }
            }
        ) {
          val w = size.width
          val h = size.height

          // 1. Subtle Ocean Depth background gradient
          drawRect(
            brush = Brush.radialGradient(
              colors = listOf(Color(0xFF1B3B2B), ForestGreenDark),
              center = Offset(w * 0.5f, h * 0.5f),
              radius = w * 0.7f
            )
          )

          // 2. Latitude and Longitude subtle coordinate lines
          drawCoordinateGrid(w, h)

          // 3. Stylized Continents Outlines & Landmass Silhouettes
          drawContinentsArt(w, h)

          // 4. Draw Sourcing Region Pins
          DEFAULT_SOURCING_PINS.forEach { pin ->
            val px = pin.normX * w
            val py = pin.normY * h
            val isSelected = pin.id == selectedPin.id

            if (isSelected) {
              // Animated Pulsing Beacon
              drawCircle(
                color = MutedGold.copy(alpha = pulseAlpha),
                radius = 16.dp.toPx() * pulseRadiusScale,
                center = Offset(px, py)
              )
              drawCircle(
                color = MutedGoldLight,
                radius = 7.dp.toPx(),
                center = Offset(px, py)
              )
              drawCircle(
                color = ForestGreenDark,
                radius = 3.dp.toPx(),
                center = Offset(px, py)
              )
            } else {
              // Resting Gold Pin
              drawCircle(
                color = MutedGold.copy(alpha = 0.35f),
                radius = 8.dp.toPx(),
                center = Offset(px, py)
              )
              drawCircle(
                color = MutedGold,
                radius = 4.5.dp.toPx(),
                center = Offset(px, py)
              )
              drawCircle(
                color = WarmIvory,
                radius = 2.dp.toPx(),
                center = Offset(px, py)
              )
            }
          }
        }

        // Map Legend / Instructions (Top-left overlay)
        Box(
          modifier = Modifier
            .padding(10.dp)
            .align(Alignment.TopStart)
            .background(ForestGreenDark.copy(alpha = 0.85f), RoundedCornerShape(2.dp))
            .border(0.6.dp, MutedGold.copy(alpha = 0.4f), RoundedCornerShape(2.dp))
            .padding(horizontal = 8.dp, vertical = 4.dp)
        ) {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Box(modifier = Modifier.size(6.dp).clip(CircleShape).background(MutedGold))
            Spacer(modifier = Modifier.width(6.dp))
            Text(
              text = "TAP A REGION PIN TO INSPECT",
              style = MaterialTheme.typography.labelSmall.copy(
                color = WarmIvory,
                fontSize = 8.5.sp,
                letterSpacing = 1.2.sp
              )
            )
          }
        }

        // Selected Pin Label (Top-right overlay)
        Box(
          modifier = Modifier
            .padding(10.dp)
            .align(Alignment.TopEnd)
            .background(Cream, RoundedCornerShape(2.dp))
            .border(0.8.dp, MutedGold, RoundedCornerShape(2.dp))
            .padding(horizontal = 8.dp, vertical = 4.dp)
        ) {
          Text(
            text = selectedPin.name.uppercase(),
            style = MaterialTheme.typography.labelSmall.copy(
              color = ForestGreenDark,
              fontSize = 9.sp,
              fontWeight = FontWeight.Bold,
              letterSpacing = 0.8.sp
            )
          )
        }
      }
    }

    Spacer(modifier = Modifier.height(10.dp))

    // Horizontal Quick-Selector Strip for accessibility
    val scrollState = rememberScrollState()
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .horizontalScroll(scrollState)
        .padding(vertical = 4.dp),
      horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
      DEFAULT_SOURCING_PINS.forEach { pin ->
        val isSelected = pin.id == selectedPin.id
        Box(
          modifier = Modifier
            .clip(RoundedCornerShape(2.dp))
            .background(if (isSelected) ForestGreenPrimary else Color.White)
            .border(
              width = 0.8.dp,
              color = if (isSelected) ForestGreenPrimary else BeigeBorder,
              shape = RoundedCornerShape(2.dp)
            )
            .clickable {
              selectedPin = pin
              onOriginSelected(pin)
            }
            .padding(horizontal = 10.dp, vertical = 6.dp)
        ) {
          Text(
            text = pin.name,
            style = MaterialTheme.typography.labelSmall.copy(
              fontSize = 11.sp,
              fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
              color = if (isSelected) Color.White else DarkCharcoalBody
            )
          )
        }
      }
    }

    Spacer(modifier = Modifier.height(10.dp))

    // Interactive Region Information Detail Card
    Card(
      modifier = Modifier
        .fillMaxWidth()
        .border(1.dp, BeigeBorder, RoundedCornerShape(3.dp))
        .testTag("map_region_detail_card"),
      colors = CardDefaults.cardColors(containerColor = WarmIvoryLight)
    ) {
      Column(modifier = Modifier.padding(16.dp)) {
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.Top
        ) {
          Column(modifier = Modifier.weight(1f)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
              Icon(Icons.Outlined.Place, contentDescription = null, tint = MutedGoldDark, modifier = Modifier.size(16.dp))
              Spacer(modifier = Modifier.width(6.dp))
              Text(
                text = selectedPin.name,
                style = MaterialTheme.typography.titleMedium.copy(
                  fontFamily = EditorialSerif,
                  fontWeight = FontWeight.Bold,
                  fontSize = 17.sp,
                  color = ForestGreenDark
                )
              )
            }

            Spacer(modifier = Modifier.height(4.dp))

            Text(
              text = "Primary Crop: ${selectedPin.primaryCrop}",
              style = MaterialTheme.typography.labelSmall.copy(
                color = MutedGoldDark,
                fontWeight = FontWeight.SemiBold,
                fontSize = 11.5.sp
              )
            )
          }

          Box(
            modifier = Modifier
              .background(Cream, RoundedCornerShape(2.dp))
              .border(0.8.dp, MutedGold.copy(alpha = 0.5f), RoundedCornerShape(2.dp))
              .padding(horizontal = 8.dp, vertical = 4.dp)
          ) {
            Text(
              text = "VERIFIED ORIGIN",
              style = MaterialTheme.typography.labelSmall.copy(
                color = ForestGreenPrimary,
                fontSize = 9.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 1.sp
              )
            )
          }
        }

        Spacer(modifier = Modifier.height(10.dp))

        // Products sourced
        Column(
          modifier = Modifier
            .fillMaxWidth()
            .background(Cream.copy(alpha = 0.6f), RoundedCornerShape(2.dp))
            .padding(10.dp)
        ) {
          Text(
            text = "SOURCED VARIETIES:",
            style = MaterialTheme.typography.labelSmall.copy(
              color = ForestGreenDark,
              fontWeight = FontWeight.Bold,
              fontSize = 10.sp,
              letterSpacing = 1.sp
            )
          )
          Spacer(modifier = Modifier.height(2.dp))
          Text(
            text = selectedPin.products,
            style = MaterialTheme.typography.bodySmall.copy(
              color = DarkCharcoal,
              fontWeight = FontWeight.Medium,
              fontSize = 12.5.sp
            )
          )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
          text = selectedPin.description,
          style = MaterialTheme.typography.bodySmall.copy(
            color = DarkCharcoalBody,
            fontSize = 13.sp,
            lineHeight = 19.sp
          )
        )

        Spacer(modifier = Modifier.height(14.dp))

        // Action CTA
        Button(
          onClick = { onExploreProductsFromOrigin(selectedPin) },
          colors = ButtonDefaults.buttonColors(containerColor = ForestGreenPrimary),
          shape = RoundedCornerShape(2.dp),
          modifier = Modifier.fillMaxWidth()
        ) {
          Text(
            text = "View Products from ${selectedPin.name.split(" ").first()} →",
            color = Color.White,
            letterSpacing = 0.5.sp,
            fontSize = 12.5.sp
          )
        }
      }
    }
  }
}

// ----------------------------------------------------------------------------
// Canvas Map Drawing Helpers
// ----------------------------------------------------------------------------

private fun DrawScope.drawCoordinateGrid(w: Float, h: Float) {
  val gridColor = Color(0x12C5A059)
  val stroke = Stroke(width = 0.8.dp.toPx())

  // Longitude arcs
  val stepsX = 6
  for (i in 1 until stepsX) {
    val x = w * (i.toFloat() / stepsX)
    drawLine(color = gridColor, start = Offset(x, 0f), end = Offset(x, h), strokeWidth = stroke.width)
  }

  // Latitude lines
  val stepsY = 4
  for (i in 1 until stepsY) {
    val y = h * (i.toFloat() / stepsY)
    drawLine(color = gridColor, start = Offset(0f, y), end = Offset(w, y), strokeWidth = stroke.width)
  }
}

private fun DrawScope.drawContinentsArt(w: Float, h: Float) {
  val landmassFill = Color(0xFF1E3A2C)
  val landmassBorder = Color(0x35C5A059)
  val stroke = Stroke(width = 1.2.dp.toPx(), cap = StrokeCap.Round)

  // 1. North America
  val northAmerica = Path().apply {
    moveTo(w * 0.12f, h * 0.18f)
    cubicTo(w * 0.22f, h * 0.15f, w * 0.28f, h * 0.20f, w * 0.32f, h * 0.26f)
    cubicTo(w * 0.34f, h * 0.34f, w * 0.28f, h * 0.44f, w * 0.22f, h * 0.46f)
    cubicTo(w * 0.18f, h * 0.48f, w * 0.16f, h * 0.42f, w * 0.14f, h * 0.34f)
    cubicTo(w * 0.10f, h * 0.28f, w * 0.08f, h * 0.22f, w * 0.12f, h * 0.18f)
    close()
  }
  drawPath(northAmerica, color = landmassFill)
  drawPath(northAmerica, color = landmassBorder, style = stroke)

  // 2. South America
  val southAmerica = Path().apply {
    moveTo(w * 0.25f, h * 0.50f)
    cubicTo(w * 0.32f, h * 0.52f, w * 0.36f, h * 0.60f, w * 0.34f, h * 0.74f)
    cubicTo(w * 0.32f, h * 0.86f, w * 0.27f, h * 0.90f, w * 0.26f, h * 0.82f)
    cubicTo(w * 0.24f, h * 0.70f, w * 0.22f, h * 0.58f, w * 0.25f, h * 0.50f)
    close()
  }
  drawPath(southAmerica, color = landmassFill)
  drawPath(southAmerica, color = landmassBorder, style = stroke)

  // 3. Europe
  val europe = Path().apply {
    moveTo(w * 0.44f, h * 0.18f)
    cubicTo(w * 0.54f, h * 0.17f, w * 0.56f, h * 0.26f, w * 0.52f, h * 0.34f)
    cubicTo(w * 0.46f, h * 0.36f, w * 0.42f, h * 0.28f, w * 0.44f, h * 0.18f)
    close()
  }
  drawPath(europe, color = landmassFill)
  drawPath(europe, color = landmassBorder, style = stroke)

  // 4. Africa
  val africa = Path().apply {
    moveTo(w * 0.46f, h * 0.38f)
    cubicTo(w * 0.58f, h * 0.38f, w * 0.60f, h * 0.48f, w * 0.56f, h * 0.64f)
    cubicTo(w * 0.52f, h * 0.78f, w * 0.48f, h * 0.76f, w * 0.45f, h * 0.62f)
    cubicTo(w * 0.42f, h * 0.50f, w * 0.42f, h * 0.42f, w * 0.46f, h * 0.38f)
    close()
  }
  drawPath(africa, color = landmassFill)
  drawPath(africa, color = landmassBorder, style = stroke)

  // 5. Asia
  val asia = Path().apply {
    moveTo(w * 0.56f, h * 0.18f)
    cubicTo(w * 0.72f, h * 0.14f, w * 0.88f, h * 0.20f, w * 0.88f, h * 0.36f)
    cubicTo(w * 0.85f, h * 0.48f, w * 0.76f, h * 0.54f, w * 0.68f, h * 0.54f)
    cubicTo(w * 0.62f, h * 0.52f, w * 0.58f, h * 0.42f, w * 0.56f, h * 0.32f)
    close()
  }
  drawPath(asia, color = landmassFill)
  drawPath(asia, color = landmassBorder, style = stroke)

  // 6. Australia
  val australia = Path().apply {
    moveTo(w * 0.78f, h * 0.68f)
    cubicTo(w * 0.88f, h * 0.66f, w * 0.90f, h * 0.76f, w * 0.86f, h * 0.84f)
    cubicTo(w * 0.80f, h * 0.86f, w * 0.76f, h * 0.78f, w * 0.78f, h * 0.68f)
    close()
  }
  drawPath(australia, color = landmassFill)
  drawPath(australia, color = landmassBorder, style = stroke)
}
