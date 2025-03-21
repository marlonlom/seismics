/*
 * Copyright 2025 Marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */
package dev.marlonlom.seismics.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

/**
 * Branded color contrasts enum class.
 *
 * @author marlonlom
 *
 * @property light Light color scheme.
 * @property dark Dark color scheme.
 *
 */
enum class SeismicsColorContrasts(val light: ColorScheme, val dark: ColorScheme) {

  /** Default branded color contrast: Standard. */
  STANDARD(
    light = lightColorScheme(
      primary = Color(0xFF4C662B),
      onPrimary = Color(0xFFFFFFFF),
      primaryContainer = Color(0xFFCDEDA3),
      onPrimaryContainer = Color(0xFF354E16),
      secondary = Color(0xFF586249),
      onSecondary = Color(0xFFFFFFFF),
      secondaryContainer = Color(0xFFDCE7C8),
      onSecondaryContainer = Color(0xFF404A33),
      tertiary = Color(0xFF386663),
      onTertiary = Color(0xFFFFFFFF),
      tertiaryContainer = Color(0xFFBCECE7),
      onTertiaryContainer = Color(0xFF1F4E4B),
      error = Color(0xFFBA1A1A),
      onError = Color(0xFFFFFFFF),
      errorContainer = Color(0xFFFFDAD6),
      onErrorContainer = Color(0xFF93000A),
      background = Color(0xFFF9FAEF),
      onBackground = Color(0xFF1A1C16),
      surface = Color(0xFFF9FAEF),
      onSurface = Color(0xFF1A1C16),
      surfaceVariant = Color(0xFFE1E4D5),
      onSurfaceVariant = Color(0xFF44483D),
      outline = Color(0xFF75796C),
      outlineVariant = Color(0xFFC5C8BA),
      scrim = Color(0xFF000000),
      inverseSurface = Color(0xFF2F312A),
      inverseOnSurface = Color(0xFFF1F2E6),
      inversePrimary = Color(0xFFB1D18A),
      surfaceDim = Color(0xFFDADBD0),
      surfaceBright = Color(0xFFF9FAEF),
      surfaceContainerLowest = Color(0xFFFFFFFF),
      surfaceContainerLow = Color(0xFFF3F4E9),
      surfaceContainer = Color(0xFFEEEFE3),
      surfaceContainerHigh = Color(0xFFE8E9DE),
      surfaceContainerHighest = Color(0xFFE2E3D8),
    ),
    dark = darkColorScheme(
      primary = Color(0xFFB1D18A),
      onPrimary = Color(0xFF1F3701),
      primaryContainer = Color(0xFF354E16),
      onPrimaryContainer = Color(0xFFCDEDA3),
      secondary = Color(0xFFBFCBAD),
      onSecondary = Color(0xFF2A331E),
      secondaryContainer = Color(0xFF404A33),
      onSecondaryContainer = Color(0xFFDCE7C8),
      tertiary = Color(0xFFA0D0CB),
      onTertiary = Color(0xFF003735),
      tertiaryContainer = Color(0xFF1F4E4B),
      onTertiaryContainer = Color(0xFFBCECE7),
      error = Color(0xFFFFB4AB),
      onError = Color(0xFF690005),
      errorContainer = Color(0xFF93000A),
      onErrorContainer = Color(0xFFFFDAD6),
      background = Color(0xFF12140E),
      onBackground = Color(0xFFE2E3D8),
      surface = Color(0xFF12140E),
      onSurface = Color(0xFFE2E3D8),
      surfaceVariant = Color(0xFF44483D),
      onSurfaceVariant = Color(0xFFC5C8BA),
      outline = Color(0xFF8F9285),
      outlineVariant = Color(0xFF44483D),
      scrim = Color(0xFF000000),
      inverseSurface = Color(0xFFE2E3D8),
      inverseOnSurface = Color(0xFF2F312A),
      inversePrimary = Color(0xFF4C662B),
      surfaceDim = Color(0xFF12140E),
      surfaceBright = Color(0xFF383A32),
      surfaceContainerLowest = Color(0xFF0C0F09),
      surfaceContainerLow = Color(0xFF1A1C16),
      surfaceContainer = Color(0xFF1E201A),
      surfaceContainerHigh = Color(0xFF282B24),
      surfaceContainerHighest = Color(0xFF33362E),
    ),
  ),

  /** Branded color contrast: Medium. */
  MEDIUM(
    light = lightColorScheme(
      primary = Color(0xFF253D05),
      onPrimary = Color(0xFFFFFFFF),
      primaryContainer = Color(0xFF5A7539),
      onPrimaryContainer = Color(0xFFFFFFFF),
      secondary = Color(0xFF303924),
      onSecondary = Color(0xFFFFFFFF),
      secondaryContainer = Color(0xFF667157),
      onSecondaryContainer = Color(0xFFFFFFFF),
      tertiary = Color(0xFF083D3A),
      onTertiary = Color(0xFFFFFFFF),
      tertiaryContainer = Color(0xFF477572),
      onTertiaryContainer = Color(0xFFFFFFFF),
      error = Color(0xFF740006),
      onError = Color(0xFFFFFFFF),
      errorContainer = Color(0xFFCF2C27),
      onErrorContainer = Color(0xFFFFFFFF),
      background = Color(0xFFF9FAEF),
      onBackground = Color(0xFF1A1C16),
      surface = Color(0xFFF9FAEF),
      onSurface = Color(0xFF0F120C),
      surfaceVariant = Color(0xFFE1E4D5),
      onSurfaceVariant = Color(0xFF34382D),
      outline = Color(0xFF505449),
      outlineVariant = Color(0xFF6B6F62),
      scrim = Color(0xFF000000),
      inverseSurface = Color(0xFF2F312A),
      inverseOnSurface = Color(0xFFF1F2E6),
      inversePrimary = Color(0xFFB1D18A),
      surfaceDim = Color(0xFFC6C7BD),
      surfaceBright = Color(0xFFF9FAEF),
      surfaceContainerLowest = Color(0xFFFFFFFF),
      surfaceContainerLow = Color(0xFFF3F4E9),
      surfaceContainer = Color(0xFFE8E9DE),
      surfaceContainerHigh = Color(0xFFDCDED3),
      surfaceContainerHighest = Color(0xFFD1D3C8),
    ),
    dark = darkColorScheme(
      primary = Color(0xFFC7E79E),
      onPrimary = Color(0xFF172B00),
      primaryContainer = Color(0xFF7D9A59),
      onPrimaryContainer = Color(0xFF000000),
      secondary = Color(0xFFD5E1C2),
      onSecondary = Color(0xFF1F2814),
      secondaryContainer = Color(0xFF8A9579),
      onSecondaryContainer = Color(0xFF000000),
      tertiary = Color(0xFFB5E6E1),
      onTertiary = Color(0xFF002B29),
      tertiaryContainer = Color(0xFF6B9995),
      onTertiaryContainer = Color(0xFF000000),
      error = Color(0xFFFFD2CC),
      onError = Color(0xFF540003),
      errorContainer = Color(0xFFFF5449),
      onErrorContainer = Color(0xFF000000),
      background = Color(0xFF12140E),
      onBackground = Color(0xFFE2E3D8),
      surface = Color(0xFF12140E),
      onSurface = Color(0xFFFFFFFF),
      surfaceVariant = Color(0xFF44483D),
      onSurfaceVariant = Color(0xFFDBDECF),
      outline = Color(0xFFB0B3A6),
      outlineVariant = Color(0xFF8E9285),
      scrim = Color(0xFF000000),
      inverseSurface = Color(0xFFE2E3D8),
      inverseOnSurface = Color(0xFF282B24),
      inversePrimary = Color(0xFF364F17),
      surfaceDim = Color(0xFF12140E),
      surfaceBright = Color(0xFF43453D),
      surfaceContainerLowest = Color(0xFF060804),
      surfaceContainerLow = Color(0xFF1C1E18),
      surfaceContainer = Color(0xFF262922),
      surfaceContainerHigh = Color(0xFF31342C),
      surfaceContainerHighest = Color(0xFF3C3F37),
    ),
  ),

  /** Branded color contrast: Medium. */
  HIGH(
    light = lightColorScheme(
      primary = Color(0xFF1C3200),
      onPrimary = Color(0xFFFFFFFF),
      primaryContainer = Color(0xFF375018),
      onPrimaryContainer = Color(0xFFFFFFFF),
      secondary = Color(0xFF262F1A),
      onSecondary = Color(0xFFFFFFFF),
      secondaryContainer = Color(0xFF434C35),
      onSecondaryContainer = Color(0xFFFFFFFF),
      tertiary = Color(0xFF003230),
      onTertiary = Color(0xFFFFFFFF),
      tertiaryContainer = Color(0xFF21504E),
      onTertiaryContainer = Color(0xFFFFFFFF),
      error = Color(0xFF600004),
      onError = Color(0xFFFFFFFF),
      errorContainer = Color(0xFF98000A),
      onErrorContainer = Color(0xFFFFFFFF),
      background = Color(0xFFF9FAEF),
      onBackground = Color(0xFF1A1C16),
      surface = Color(0xFFF9FAEF),
      onSurface = Color(0xFF000000),
      surfaceVariant = Color(0xFFE1E4D5),
      onSurfaceVariant = Color(0xFF000000),
      outline = Color(0xFF2A2D24),
      outlineVariant = Color(0xFF474B40),
      scrim = Color(0xFF000000),
      inverseSurface = Color(0xFF2F312A),
      inverseOnSurface = Color(0xFFFFFFFF),
      inversePrimary = Color(0xFFB1D18A),
      surfaceDim = Color(0xFFB8BAAF),
      surfaceBright = Color(0xFFF9FAEF),
      surfaceContainerLowest = Color(0xFFFFFFFF),
      surfaceContainerLow = Color(0xFFF1F2E6),
      surfaceContainer = Color(0xFFE2E3D8),
      surfaceContainerHigh = Color(0xFFD4D5CA),
      surfaceContainerHighest = Color(0xFFC6C7BD),
    ),
    dark = darkColorScheme(
      primary = Color(0xFFDAFBB0),
      onPrimary = Color(0xFF000000),
      primaryContainer = Color(0xFFADCD86),
      onPrimaryContainer = Color(0xFF050E00),
      secondary = Color(0xFFE9F4D5),
      onSecondary = Color(0xFF000000),
      secondaryContainer = Color(0xFFBCC7A9),
      onSecondaryContainer = Color(0xFF060D01),
      tertiary = Color(0xFFC9F9F5),
      onTertiary = Color(0xFF000000),
      tertiaryContainer = Color(0xFF9CCCC7),
      onTertiaryContainer = Color(0xFF000E0D),
      error = Color(0xFFFFECE9),
      onError = Color(0xFF000000),
      errorContainer = Color(0xFFFFAEA4),
      onErrorContainer = Color(0xFF220001),
      background = Color(0xFF12140E),
      onBackground = Color(0xFFE2E3D8),
      surface = Color(0xFF12140E),
      onSurface = Color(0xFFFFFFFF),
      surfaceVariant = Color(0xFF44483D),
      onSurfaceVariant = Color(0xFFFFFFFF),
      outline = Color(0xFFEEF2E2),
      outlineVariant = Color(0xFFC1C4B6),
      scrim = Color(0xFF000000),
      inverseSurface = Color(0xFFE2E3D8),
      inverseOnSurface = Color(0xFF000000),
      inversePrimary = Color(0xFF364F17),
      surfaceDim = Color(0xFF12140E),
      surfaceBright = Color(0xFF4F5149),
      surfaceContainerLowest = Color(0xFF000000),
      surfaceContainerLow = Color(0xFF1E201A),
      surfaceContainer = Color(0xFF2F312A),
      surfaceContainerHigh = Color(0xFF3A3C35),
      surfaceContainerHighest = Color(0xFF454840),
    ),
  ),
  ;

  /**
   * Utility functions for enum class.
   *
   * @author marlonlom
   */
  companion object {

    /**
     * Returns the selected color contrast color scheme by name and if dark theme is applied.
     *
     * @param colorContrast Selected color contrast name.
     * @param darkTheme True/False is dark theme is applied.
     * @return Selected color contrast scheme.
     */
    fun findColorScheme(colorContrast: String, darkTheme: Boolean): ColorScheme = valueOf(colorContrast).let {
      if (darkTheme) it.dark else it.light
    }
  }
}
