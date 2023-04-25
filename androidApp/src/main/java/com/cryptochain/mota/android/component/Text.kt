package com.cryptochain.mota.android.component

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit

@Composable
fun RegularText(
    modifier: Modifier = Modifier,
    content: String,
    color: Color = MaterialTheme.colors.secondary,
    fontSize: TextUnit = getFontSize10sp()
) {
    Text(
        modifier = modifier,
        text = content,
        color = color,
        fontSize = fontSize,
        fontWeight = FontWeight.Normal,
        fontFamily = MaterialTheme.typography.body1.fontFamily
    )
}

@Composable
fun SemiBoldText(
    modifier: Modifier = Modifier,
    content: String,
    color: Color = MaterialTheme.colors.secondary,
    fontSize: TextUnit = getFontSize10sp()
) {
    Text(
        modifier = modifier,
        text = content,
        color = color,
        fontSize = fontSize,
        fontWeight = FontWeight.SemiBold,
        fontFamily = MaterialTheme.typography.body1.fontFamily
    )
}

@Composable
fun BoldText(
    modifier: Modifier = Modifier,
    content: String,
    color: Color = MaterialTheme.colors.secondary,
    fontSize: TextUnit = getFontSize10sp(),
    maxLines: Int = 2
) {
    Text(
        modifier = modifier,
        text = content,
        color = color,
        fontSize = fontSize,
        fontWeight = FontWeight.Bold,
        fontFamily = MaterialTheme.typography.body1.fontFamily,
        maxLines = maxLines
    )
}