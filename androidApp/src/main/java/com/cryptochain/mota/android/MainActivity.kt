package com.cryptochain.mota.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.SideEffect
import androidx.core.view.WindowCompat
import com.cryptochain.mota.android.feature.main.MainScreen
import com.cryptochain.mota.android.theme.ApplicationTheme
import com.cryptochain.mota.viewModel.MarketCoinListViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MainActivity : ComponentActivity(), KoinComponent {
    private val viewModel: MarketCoinListViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WindowCompat.setDecorFitsSystemWindows(window, false)

            ApplicationTheme {
                val systemUiController = rememberSystemUiController()
                val darkIcons = MaterialTheme.colors.isLight
                val backgroundColor = MaterialTheme.colors.background
                val navigationColor = MaterialTheme.colors.primaryVariant

                SideEffect {
                    // Update all of the system bar colors to be transparent, and use
                    // dark icons if we're in light theme
                    systemUiController.setSystemBarsColor(
                        color = backgroundColor,
                        darkIcons = darkIcons
                    )
                    systemUiController.setNavigationBarColor(
                        color = navigationColor
                    )
                }

                MainScreen(viewModel)
            }
        }
    }
}


