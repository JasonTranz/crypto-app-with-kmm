package com.cryptochain.mota.android.feature.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import com.cryptochain.mota.android.feature.market.MarketCoinListScreen
import com.cryptochain.mota.viewModel.MarketCoinListViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    marketCoinListViewModel: MarketCoinListViewModel
) {
    val marketCoinListViewModelDataState by remember { marketCoinListViewModel.marketCoinListViewModelState }.collectAsState()

    LaunchedEffect(true) {
        marketCoinListViewModel.fetchMarketCoinList()
    }
    
    MarketCoinListScreen(
        coins = marketCoinListViewModelDataState.coins,
        navController = navController
    )
}