package com.cryptochain.mota.viewModel

import com.cryptochain.mota.entity.Coin
import com.cryptochain.mota.repository.CoinRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MarketCoinListViewModel(
    private val coinRepository: CoinRepository
) : ViewModel() {

    private val _marketCoinListViewModelState: MutableStateFlow<MarketCoinModelState> = MutableStateFlow(MarketCoinModelState())
    val marketCoinListViewModelState: StateFlow<MarketCoinModelState> = _marketCoinListViewModelState.asStateFlow()

    fun fetchMarketCoinList(perPage: Int = 100, page: Int = 1) {
        var coinList: List<Coin>
        viewModelScope.launch {
            coinList = coinRepository.getCoinList(perPage, page)
            _marketCoinListViewModelState.update { it.copy(coins = coinList) }
        }
    }

    fun fetchListingsLatestCoinList() {
        var coinList: List<Coin>
        viewModelScope.launch {
            coinList = coinRepository.getListingsLatest()
            _marketCoinListViewModelState.update { it.copy(coins = coinList) }
        }
    }
}