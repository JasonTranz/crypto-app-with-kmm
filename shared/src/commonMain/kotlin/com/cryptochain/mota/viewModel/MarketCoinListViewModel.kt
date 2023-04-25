package com.cryptochain.mota.viewModel

import com.cryptochain.mota.db.Database
import com.cryptochain.mota.mapper.toCoin
import com.cryptochain.mota.mapper.toCoinLocal
import com.cryptochain.mota.repository.CoinRepository
import com.rickclephas.kmm.viewmodel.KMMViewModel
import com.rickclephas.kmm.viewmodel.MutableStateFlow
import com.rickclephas.kmm.viewmodel.stateIn
import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

open class MarketCoinListViewModel : KMMViewModel(), KoinComponent {

    private val coinRepository: CoinRepository by inject()
    private val database: Database by inject()

    private val _marketCoinListViewModelState = MutableStateFlow(viewModelScope, MarketCoinModelState())

    @NativeCoroutinesState
    val marketCoinListViewModelState = _marketCoinListViewModelState.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), MarketCoinModelState())

    open suspend fun getCoinList(perPage: Int = 100, page: Int = 1) {
        coinRepository.getCoinList(perPage = perPage, page = page)
            .flowOn(Dispatchers.Default)
            .onEach { coins ->
                if (coins.isNotEmpty()) {
                    database.clearDatabase()
                }
            }
            .onEach { coins ->
                database.addCoins(coins.map { it.toCoinLocal() })
            }
            .catch { throwable ->
                _marketCoinListViewModelState.update { it.copy(errorMsg = throwable.message ?: "") }
            }
            .collect { remoteList ->
                val finalList = remoteList.ifEmpty { database.getCoins().map { it.toCoin() } }
                _marketCoinListViewModelState.update { it.copy(coins = finalList) }
            }
    }
}