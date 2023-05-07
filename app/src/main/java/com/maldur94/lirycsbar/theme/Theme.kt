package com.maldur94.lirycsbar.theme


import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = teal800,
    primaryVariant = teal600,
    secondary = redDark,
    background = Color.DarkGray,
    surface = Color.DarkGray,
    onPrimary = Color.White,
)

private val LightColorPalette = lightColors(
    primary = teal800,
    primaryVariant = teal600,
    secondary = red100,
    onPrimary = Color.White,
)

@Composable
fun LirycsBarTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
