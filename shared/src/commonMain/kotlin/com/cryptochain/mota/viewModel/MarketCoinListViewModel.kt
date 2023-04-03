package com.cryptochain.mota.viewModel

import com.cryptochain.mota.entity.Coin
import com.cryptochain.mota.repository.CoinRepository
import com.rickclephas.kmm.viewmodel.KMMViewModel
import com.rickclephas.kmm.viewmodel.MutableStateFlow
import com.rickclephas.kmm.viewmodel.coroutineScope
import com.rickclephas.kmm.viewmodel.stateIn
import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

open class MarketCoinListViewModel : KMMViewModel(), KoinComponent {

    private val coinRepository: CoinRepository by inject()

    private val _marketCoinListViewModelState = MutableStateFlow(viewModelScope, MarketCoinModelState())

    @NativeCoroutinesState
    val marketCoinListViewModelState = _marketCoinListViewModelState.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), MarketCoinModelState())

    fun fetchMarketCoinList(perPage: Int = 100, page: Int = 1) {
        println("HUU_CHECK fetch")
        viewModelScope.coroutineScope.launch(Dispatchers.Default) {
            println("HUU_CHECK coin size 1")
            val coins = coinRepository.getCoinList(perPage, page)
            _marketCoinListViewModelState.update { it.copy(coins = coins) }
            println("HUU_CHECK coin size 2")
        }
        println("HUU_CHECK coin size 3")
    }

    fun fetchListingsLatestCoinList() {
        var coinList: List<Coin>
        viewModelScope.coroutineScope.launch {
            coinList = coinRepository.getListingsLatest()
            _marketCoinListViewModelState.update { it.copy(coins = coinList) }
        }
    }

    suspend fun fetchMarketCoinList1(perPage: Int = 100, page: Int = 1) {
        val coins = coinRepository.getCoinList(perPage, page)
        _marketCoinListViewModelState.update { it.copy(coins = coins) }
        println("HUU_CHECK coin size: ${coins.size}")
    }

    fun getText(): String {
        return "BBBBB"
    }
}