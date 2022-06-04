package ru.ironball.shikimori.ui.theme

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color

class AppColors(
    val primary: Color,
    val secondary: Color,
    val borderSecondary: Color,
    val background: Color,
    val surface: Color,
    val error: Color,
    val anonsColor: Color,
    val ongoingColor: Color,
    val releasedColor: Color,
    val onPrimary: Color,
    val onSecondary: Color,
    val onBackground: Color,
    val onSurface: Color,
    val onError: Color,
    val isLight: Boolean
) {
    fun getMaterialThemeColors() = Colors(
        primary,
        primary,
        secondary,
        secondary,
        background,
        surface,
        error,
        onPrimary,
        onSecondary,
        onBackground,
        onSurface,
        onError,
        isLight,
    )
}

val LightPalette = AppColors(
    primary = Color(0xFF343434),
    secondary = Color(0xFFE8EBEF),
    borderSecondary = Color(0xFFD8DDE4),
    background = Color.White,
    surface = Color.White,
    error =  Color(0xFFB00020),
    anonsColor = Color(0xFFC44728),
    ongoingColor = Color(0xFF1D78B7),
    releasedColor = Color(0xFF419541),
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    onError = Color.White,
    isLight = true
)