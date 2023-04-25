package com.cryptochain.mota.android.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.cryptochain.mota.android.feature.explore.ExploreScreen
import com.cryptochain.mota.android.feature.market.MarketCoinListScreen
import com.cryptochain.mota.android.feature.menu.MenuScreen
import com.cryptochain.mota.android.feature.portfolio.PortfolioScreen
import com.cryptochain.mota.android.feature.root.BottomNavigationBar
import com.cryptochain.mota.android.feature.root.BottomNavigationItem
import com.cryptochain.mota.android.feature.search.SearchScreen
import com.cryptochain.mota.viewModel.MarketCoinListViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeScreen(
    marketCoinListViewModel: MarketCoinListViewModel
) {
    val pagerState = rememberPagerState(initialPage = 0)

    val bottomNavigationItems = listOf(
        BottomNavigationItem.Home,
        BottomNavigationItem.Portfolio,
        BottomNavigationItem.Search,
        BottomNavigationItem.Explore,
        BottomNavigationItem.Menu
    )

    Scaffold(
        content = { paddingValues ->
            HorizontalPager(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = MaterialTheme.colors.background)
                    .statusBarsPadding()
                    .padding(paddingValues),
                count = bottomNavigationItems.size,
                state = pagerState
            ) {
                when (it) {
                    0 -> {
                        MarketCoinListScreen(marketCoinListViewModel = marketCoinListViewModel)
                    }

                    1 -> {
                        PortfolioScreen()
                    }

                    2 -> {
                        SearchScreen()
                    }

                    3 -> {
                        ExploreScreen()
                    }

                    4 -> {
                        MenuScreen()
                    }
                }
            }
        },
        bottomBar = {
            BottomNavigationBar(
                pagerState = pagerState,
                items = bottomNavigationItems
            )
        },
    )
}
