package com.cryptochain.mota.android

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cryptochain.mota.model.Coin
import com.cryptochain.mota.services.CoinService
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.launch

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        darkColors(
            primary = Color(0xFFBB86FC),
            primaryVariant = Color(0xFF3700B3),
            secondary = Color(0xFF03DAC5)
        )
    } else {
        lightColors(
            primary = Color(0xFF6200EE),
            primaryVariant = Color(0xFF3700B3),
            secondary = Color(0xFF03DAC5)
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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val systemUiController: SystemUiController = rememberSystemUiController()

            systemUiController.isStatusBarVisible = false // Status bar
            systemUiController.isNavigationBarVisible = false // Navigation bar
            systemUiController.isSystemBarsVisible = false // Status & Navigation bars

            MyApplicationTheme {

                val text = remember { mutableStateOf("") }
                val coroutineScope = rememberCoroutineScope()
                val coins = remember { mutableStateOf(listOf<Coin>()) }

                LaunchedEffect(true) {
                    coroutineScope.launch {
                        text.value = try {
                            coins.value = CoinService().getCoinList()
                            ""
                        } catch (e: Exception) {
                            Log.e("HUU_CHECK", "e.message: ${e.message}")
                            "error: ${e.message} / ${e.stackTrace}"
                        }
                    }
                }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CoinList(coins = coins.value)
                }
            }
        }
    }
}

@Composable
fun CoinList(coins: List<Coin>) {
    LazyColumn {
        items(coins) {
            CoinItem(coin = it)
        }
    }
}

@Composable
private fun CoinItem(coin: Coin) {
    Box(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = coin.name.toString(),
            modifier = Modifier.align(alignment = Alignment.CenterStart)
        )
        Text(
            text = coin.symbol.toString(),
            modifier = Modifier.align(Alignment.CenterEnd)
        )
    }
}

@Composable
fun Greeting(text: String) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        item {
            Text(text = text)
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        Greeting("Hello, Android!")
    }
}
