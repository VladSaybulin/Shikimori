package ru.ironball.shikimori.ui.theme

import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Composable
fun ShikimoriTheme(content: @Composable () -> Unit) {
    val colors = LightPalette

    MaterialTheme(
        colors = colors.getMaterialThemeColors(),
        typography = Typography,
        shapes = Shapes,
    ) {
        CompositionLocalProvider(
            LocalAppColors provides colors,
            content = content
        )
    }
}

object AppTheme {
    val colors: AppColors
        @Composable
        @ReadOnlyComposable
        get() = LocalAppColors.current
}

val LocalAppColors = staticCompositionLocalOf<AppColors> {
    error("Not colors provided")
}