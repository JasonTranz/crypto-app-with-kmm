package com.cryptochain.mota.android.component

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.systemBars
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun getBottomNavBarDisplayHeight(): Dp {
    return 56.dp
}

@Composable
fun getBottomNavBarHeight(): Dp {
    val insets = WindowInsets.navigationBars.asPaddingValues()
    return insets.calculateBottomPadding()
}

@Composable
fun getSystemBarHeight(): Dp {
    return WindowInsets.systemBars.asPaddingValues().calculateTopPadding()
}