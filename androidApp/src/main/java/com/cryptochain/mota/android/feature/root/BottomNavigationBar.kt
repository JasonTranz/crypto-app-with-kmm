package com.cryptochain.mota.android.feature.root

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.cryptochain.mota.android.R
import com.cryptochain.mota.android.component.RegularText
import com.cryptochain.mota.android.component.getBottomNavBarDisplayHeight
import com.cryptochain.mota.android.component.getBottomNavBarHeight
import com.cryptochain.mota.android.component.tinySpace
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BottomNavigationBar(
    pagerState: PagerState,
    items: List<BottomNavigationItem>
) {
    val coroutineScope = rememberCoroutineScope()
    BottomNavigation(
        modifier = Modifier
            .height(getBottomNavBarDisplayHeight() + getBottomNavBarHeight())
            .navigationBarsPadding(),
        backgroundColor = MaterialTheme.colors.primaryVariant,
        contentColor = MaterialTheme.colors.secondary,
    ) {
        items.forEachIndexed { index, item ->
            val selected = index == pagerState.currentPage
            BottomNavigationItem(
                modifier = Modifier.padding(top = tinySpace()),
                icon = {
                    Image(
                        painter = painterResource(id = item.resIconId),
                        modifier = Modifier.size(20.dp),
                        contentScale = ContentScale.Crop,
                        contentDescription = ""
                    )
                },
                label = { RegularText(content = stringResource(id = item.resTitleId)) },
                selectedContentColor = MaterialTheme.colors.secondary,
                unselectedContentColor = MaterialTheme.colors.secondaryVariant,
                alwaysShowLabel = true,
                selected = selected,
                onClick = {
                    coroutineScope.launch {
                        pagerState.scrollToPage(index)
                    }
                }
            )
        }
    }
}

sealed class BottomNavigationItem(var route: String, var resIconId: Int, var resTitleId: Int) {
    object Home : BottomNavigationItem("home", R.drawable.ic_bottom_navigation_home, R.string.bottom_navigation_home)
    object Portfolio : BottomNavigationItem("portfolio", R.drawable.ic_bottom_navigation_portfolio, R.string.bottom_navigation_portfolio)
    object Search : BottomNavigationItem("search", R.drawable.ic_bottom_navigation_search, R.string.bottom_navigation_search)
    object Explore : BottomNavigationItem("explore", R.drawable.ic_bottom_navigation_explore, R.string.bottom_navigation_explore)
    object Menu : BottomNavigationItem("menu", R.drawable.ic_bottom_navigation_menu, R.string.bottom_navigation_menu)
}