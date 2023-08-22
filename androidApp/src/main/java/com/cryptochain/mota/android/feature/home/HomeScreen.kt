package com.cryptochain.mota.android.feature.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.cryptochain.mota.android.feature.explore.ExploreScreen
import com.cryptochain.mota.android.feature.market.CoinListScreen
import com.cryptochain.mota.android.feature.menu.MenuScreen
import com.cryptochain.mota.android.feature.portfolio.PortfolioScreen
import com.cryptochain.mota.android.feature.root.BottomNavigationBar
import com.cryptochain.mota.android.feature.root.BottomNavigationItem
import com.cryptochain.mota.android.feature.search.SearchScreen
import com.cryptochain.mota.viewModel.CoinListKMMViewModel
import com.cryptochain.mota.viewModel.MenuKMMViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    coinListKMMViewModel: CoinListKMMViewModel,
    menuKMMViewModel: MenuKMMViewModel
) {
    val bottomNavigationItems = listOf(
        BottomNavigationItem.Home,
        BottomNavigationItem.Portfolio,
        BottomNavigationItem.Search,
        BottomNavigationItem.Explore,
        BottomNavigationItem.Menu
    )

    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f,
        pageCount = {
            bottomNavigationItems.size
        }
    )

    Scaffold(
        content = { paddingValues ->
            HorizontalPager(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = MaterialTheme.colors.background)
                    .statusBarsPadding()
                    .padding(paddingValues),
                beyondBoundsPageCount = bottomNavigationItems.size,
                state = pagerState
            ) {
                when (it) {
                    0 -> {
                        CoinListScreen(coinListKMMViewModel = coinListKMMViewModel)
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
                        MenuScreen(menuKMMViewModel = menuKMMViewModel)
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
