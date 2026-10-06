package com.example.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Editorial serif for major headings and luxury wordmark
val EditorialSerif = FontFamily.Serif

// Modern clean sans-serif for body, specs, buttons, labels
val CleanSans = FontFamily.SansSerif

val Typography = Typography(
  displayLarge = TextStyle(
    fontFamily = EditorialSerif,
    fontWeight = FontWeight.Medium,
    fontSize = 42.sp,
    lineHeight = 48.sp,
    letterSpacing = (-0.5).sp,
    color = ForestGreenDark
  ),
  displayMedium = TextStyle(
    fontFamily = EditorialSerif,
    fontWeight = FontWeight.Medium,
    fontSize = 34.sp,
    lineHeight = 40.sp,
    letterSpacing = (-0.25).sp,
    color = ForestGreenDark
  ),
  displaySmall = TextStyle(
    fontFamily = EditorialSerif,
    fontWeight = FontWeight.Normal,
    fontSize = 28.sp,
    lineHeight = 34.sp,
    letterSpacing = 0.sp,
    color = ForestGreenDark
  ),
  headlineLarge = TextStyle(
    fontFamily = EditorialSerif,
    fontWeight = FontWeight.Medium,
    fontSize = 26.sp,
    lineHeight = 32.sp,
    letterSpacing = 0.5.sp,
    color = ForestGreenPrimary
  ),
  headlineMedium = TextStyle(
    fontFamily = EditorialSerif,
    fontWeight = FontWeight.Normal,
    fontSize = 22.sp,
    lineHeight = 28.sp,
    letterSpacing = 0.5.sp,
    color = ForestGreenPrimary
  ),
  headlineSmall = TextStyle(
    fontFamily = EditorialSerif,
    fontWeight = FontWeight.Normal,
    fontSize = 19.sp,
    lineHeight = 25.sp,
    letterSpacing = 0.25.sp,
    color = ForestGreenPrimary
  ),
  titleLarge = TextStyle(
    fontFamily = CleanSans,
    fontWeight = FontWeight.SemiBold,
    fontSize = 18.sp,
    lineHeight = 24.sp,
    letterSpacing = 0.15.sp,
    color = DarkCharcoal
  ),
  titleMedium = TextStyle(
    fontFamily = CleanSans,
    fontWeight = FontWeight.Medium,
    fontSize = 15.sp,
    lineHeight = 22.sp,
    letterSpacing = 0.15.sp,
    color = DarkCharcoal
  ),
  titleSmall = TextStyle(
    fontFamily = CleanSans,
    fontWeight = FontWeight.Medium,
    fontSize = 13.sp,
    lineHeight = 18.sp,
    letterSpacing = 0.1.sp,
    color = CharcoalMuted
  ),
  bodyLarge = TextStyle(
    fontFamily = CleanSans,
    fontWeight = FontWeight.Normal,
    fontSize = 15.sp,
    lineHeight = 24.sp,
    letterSpacing = 0.25.sp,
    color = DarkCharcoalBody
  ),
  bodyMedium = TextStyle(
    fontFamily = CleanSans,
    fontWeight = FontWeight.Normal,
    fontSize = 14.sp,
    lineHeight = 21.sp,
    letterSpacing = 0.25.sp,
    color = DarkCharcoalBody
  ),
  bodySmall = TextStyle(
    fontFamily = CleanSans,
    fontWeight = FontWeight.Normal,
    fontSize = 12.sp,
    lineHeight = 17.sp,
    letterSpacing = 0.4.sp,
    color = CharcoalMuted
  ),
  labelLarge = TextStyle(
    fontFamily = CleanSans,
    fontWeight = FontWeight.SemiBold,
    fontSize = 13.sp,
    lineHeight = 18.sp,
    letterSpacing = 1.25.sp,
    color = ForestGreenPrimary
  ),
  labelMedium = TextStyle(
    fontFamily = CleanSans,
    fontWeight = FontWeight.Medium,
    fontSize = 11.sp,
    lineHeight = 16.sp,
    letterSpacing = 1.2.sp,
    color = MutedGoldDark
  ),
  labelSmall = TextStyle(
    fontFamily = CleanSans,
    fontWeight = FontWeight.Medium,
    fontSize = 10.sp,
    lineHeight = 14.sp,
    letterSpacing = 1.5.sp,
    color = CharcoalMuted
  )
)
