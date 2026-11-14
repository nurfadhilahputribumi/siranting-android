package com.siranting.siranting.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable

private val ColorScheme = lightColorScheme(
    primary = MedicalPrimary,
    secondary = MedicalSecondary,
    background = MedicalBackground,
    surface = MedicalSurface,
    outline = MedicalOutline
)

@Composable
fun SirantingTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = ColorScheme,
        typography = Typography,
        content = content
    )
}