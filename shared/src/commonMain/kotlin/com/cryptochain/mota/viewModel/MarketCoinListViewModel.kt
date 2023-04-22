package com.cryptochain.mota.viewModel

import com.cryptochain.mota.db.Database
import com.cryptochain.mota.mapper.toCoin
import com.cryptochain.mota.mapper.toCoinLocal
import com.cryptochain.mota.model.Coin
import com.cryptochain.mota.repository.CoinRepository
import com.rickclephas.kmm.viewmodel.KMMViewModel
import com.rickclephas.kmm.viewmodel.MutableStateFlow
import com.rickclephas.kmm.viewmodel.coroutineScope
import com.rickclephas.kmm.viewmodel.stateIn
import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

open class MarketCoinListViewModel : KMMViewModel(), KoinComponent {

    private val coinRepository: CoinRepository by inject()
    private val database: Database by inject()

    private val _marketCoinListViewModelState = MutableStateFlow(viewModelScope, MarketCoinModelState())

    @NativeCoroutinesState
    val marketCoinListViewModelState = _marketCoinListViewModelState.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), MarketCoinModelState())

    fun fetchListingsLatestCoinList() {
        var coinList: List<Coin>
        viewModelScope.coroutineScope.launch {
            coinList = coinRepository.getListingsLatest()
            _marketCoinListViewModelState.update { it.copy(coins = coinList) }
        }
    }

    suspend fun fetchMarketCoinList(perPage: Int = 100, page: Int = 1): List<Coin> {
        return try {
            coinRepository.getCoinList(perPage, page)
        } catch (ex: Exception) {
            emptyList()
        }
    }

    open suspend fun getCoinList(): List<Coin> {
        return try {
            var coins = database.getCoins().map { it.toCoin() }

            if (coins.isNotEmpty()) {
                _marketCoinListViewModelState.update { it.copy(coins = coins) }
            } else {
                coins = coinRepository.getCoinList(100, 1)
                _marketCoinListViewModelState.update { it.copy(coins = coins) }
                database.addCoins(coins.map { it.toCoinLocal() })
            }

            coins
        } catch (ex: Exception) {
            emptyList()
        }
    }
}