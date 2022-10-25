package com.cryptochain.mota.android.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        darkColors(
            primary = Color(0xFF000000),
            primaryVariant = Color(0xFF7F7F7F),
            secondary = Color(0xFFF3F3F3),
            secondaryVariant = Color(0xFFECF3FD),
            surface = Color(0XFFABE230),
            error = Color(0XFFEA3326)
        )
    } else {
        lightColors(
            primary = Color(0xFFF3F3F3),
            primaryVariant = Color(0xFFECF3FD),
            secondary = Color(0xFF000000),
            secondaryVariant = Color(0xFF7F7F7F),
            surface = Color(0XFFABE230),
            error = Color(0XFFEA3326)
        )
    }
    val typography = Typography(
        body1 = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        )
    )
    val shapes = Shapes(
        small = RoundedCornerShape(4.dp),
        medium = RoundedCornerShape(4.dp),
        large = RoundedCornerShape(0.dp)
    )

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}