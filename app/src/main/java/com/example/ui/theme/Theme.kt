package com.example.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val ImperialDarkColorScheme = darkColorScheme(
  primary = ImperialGoldBright,
  onPrimary = WalnutDarkest,
  primaryContainer = GoldContainerDark,
  onPrimaryContainer = ImperialGoldLight,
  secondary = ImperialGold,
  onSecondary = WalnutDarkest,
  secondaryContainer = WalnutSurfaceVariant,
  onSecondaryContainer = IvoryWarm,
  tertiary = ImperialGoldLight,
  onTertiary = WalnutDarkest,
  background = WalnutBackground,
  onBackground = IvoryWarm,
  surface = WalnutSurface,
  onSurface = IvoryWarm,
  surfaceVariant = WalnutSurfaceVariant,
  onSurfaceVariant = SandMuted,
  outline = WalnutBorder,
  outlineVariant = WalnutBorderSubtle
)

private val ImperialLightColorScheme = lightColorScheme(
  primary = ImperialGoldDark,
  onPrimary = Color.White,
  primaryContainer = IvoryCream,
  onPrimaryContainer = WalnutDarkest,
  secondary = ImperialGold,
  onSecondary = WalnutDarkest,
  secondaryContainer = IvoryCream,
  onSecondaryContainer = WalnutDarkest,
  tertiary = ImperialBronze,
  onTertiary = Color.White,
  background = IvoryWarm,
  onBackground = WalnutDarkest,
  surface = IvoryPure,
  onSurface = WalnutDarkest,
  surfaceVariant = IvoryCream,
  onSurfaceVariant = WalnutDarkest,
  outline = WalnutBorder,
  outlineVariant = SandMuted
)

@Composable
fun NuturalsTheme(
  darkTheme: Boolean = true, // Default to Sovereign Imperial Dark Walnut & Gold theme
  content: @Composable () -> Unit
) {
  val colorScheme = if (darkTheme) ImperialDarkColorScheme else ImperialLightColorScheme

  MaterialTheme(
    colorScheme = colorScheme,
    typography = Typography,
    content = content
  )
}
