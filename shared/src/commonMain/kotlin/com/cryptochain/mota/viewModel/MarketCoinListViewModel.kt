package com.cryptochain.mota.viewModel

import com.cryptochain.mota.model.CoinResponse
import com.cryptochain.mota.services.CoinService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MarketCoinListViewModel(
    private val coinService: CoinService
) : ViewModel() {

    private val _marketCoinListViewModelState: MutableStateFlow<MarketCoinModelState> = MutableStateFlow(MarketCoinModelState())
    val marketCoinListViewModelState: StateFlow<MarketCoinModelState> = _marketCoinListViewModelState.asStateFlow()

    fun fetchMarketCoinList(perPage: Int = 100, page: Int = 1) {
        var coinList: List<CoinResponse>
        viewModelScope.launch {
            coinList = coinService.getCoinList(perPage, page)
            _marketCoinListViewModelState.update { it.copy(coins = coinList) }
        }
    }
}