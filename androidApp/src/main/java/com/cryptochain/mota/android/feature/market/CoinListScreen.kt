package com.cryptochain.mota.android.feature.market

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.cryptochain.mota.android.component.BoldText
import com.cryptochain.mota.android.component.RegularImage
import com.cryptochain.mota.android.component.RegularText
import com.cryptochain.mota.android.component.SemiBoldText
import com.cryptochain.mota.android.component.getFontSize11sp
import com.cryptochain.mota.android.component.getFontSize12sp
import com.cryptochain.mota.android.component.getFontSize13sp
import com.cryptochain.mota.android.component.mediumSpace
import com.cryptochain.mota.android.component.smallSpace
import com.cryptochain.mota.android.component.tinySpace
import com.cryptochain.mota.android.util.UnitUtil.formatPercentage
import com.cryptochain.mota.model.Coin
import com.cryptochain.mota.viewModel.CoinListKMMViewModel

@Composable
fun CoinListScreen(
    coinListKMMViewModel: CoinListKMMViewModel
) {
    val coinListViewModelState by remember { coinListKMMViewModel.coinListViewModelState }.collectAsState()
    val coins = coinListViewModelState.coins
    val errorMsg = coinListViewModelState.errorMsg

    LaunchedEffect(true) {
        coinListKMMViewModel.getCoinList()
    }

    BackHandler(false) { }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = mediumSpace()),
        verticalArrangement = Arrangement.Top
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row(modifier = Modifier.weight(0.07f)) {
                BoldText(
                    content = "#",
                    fontSize = getFontSize13sp(),
                    color = MaterialTheme.colors.secondaryVariant
                )
            }
            Row(
                modifier = Modifier.weight(0.43f),
                horizontalArrangement = Arrangement.Start
            ) {
                Spacer(modifier = Modifier.width(35.dp + smallSpace()))

                BoldText(
                    content = "Coin",
                    fontSize = getFontSize13sp(),
                    color = MaterialTheme.colors.secondaryVariant
                )
            }
            Row(
                modifier = Modifier.weight(0.3f),
                horizontalArrangement = Arrangement.End
            ) {
                BoldText(
                    content = "Price",
                    fontSize = getFontSize13sp(),
                    color = MaterialTheme.colors.secondaryVariant
                )
            }
            Row(
                modifier = Modifier.weight(0.2f),
                horizontalArrangement = Arrangement.End
            ) {
                BoldText(
                    content = "24h",
                    fontSize = getFontSize13sp(),
                    color = MaterialTheme.colors.secondaryVariant
                )
            }
        }

        LazyColumn {
            itemsIndexed(coins) { index, item ->
                CoinItem(coin = item, index = index)
            }
        }

        errorMsg?.let { message ->
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                RegularText(content = message)
            }
        }
    }
}

@Composable
private fun CoinItem(
    modifier: Modifier = Modifier,
    coin: Coin,
    index: Int,
) {
    val height = remember { mutableStateOf(0.dp) }
    val localDensity = LocalDensity.current

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = smallSpace())
    ) {
        Row(
            modifier = Modifier
                .weight(0.07f)
                .height(height.value),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RegularText(content = "${index + 1}", fontSize = getFontSize11sp())
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .weight(0.43f)
                .onGloballyPositioned {
                    with(localDensity) { height.value = it.size.height.toDp() }
                }
        ) {
            RegularImage(data = coin.image)

            Spacer(modifier = Modifier.padding(end = smallSpace()))

            Column {
                BoldText(
                    content = coin.name,
                    fontSize = getFontSize13sp(),
                    maxLines = 1
                )

                Spacer(modifier = Modifier.height(tinySpace()))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RegularText(
                        content = coin.symbol.uppercase(),
                        fontSize = getFontSize11sp()
                    )
                }
            }
        }

        Row(
            modifier = Modifier
                .weight(0.3f)
                .height(height.value),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BoldText(
                content = coin.price.toString(),
                fontSize = getFontSize13sp()
            )
        }

        Row(
            modifier = Modifier
                .weight(0.2f)
                .height(height.value),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            SemiBoldText(
                content = coin.priceChangePercentage24h.formatPercentage(),
                color = if (coin.priceChangePercentage24h > 0.0) MaterialTheme.colors.surface else MaterialTheme.colors.error,
                fontSize = getFontSize12sp()
            )
        }
    }
}