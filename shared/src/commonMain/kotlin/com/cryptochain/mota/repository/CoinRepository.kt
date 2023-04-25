package com.cryptochain.mota.repository

import com.cryptochain.mota.model.Coin
import com.cryptochain.mota.mapper.toCoin
import com.cryptochain.mota.service.CoinMarketCapService
import com.cryptochain.mota.service.CoingeckoService
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

@OptIn(FlowPreview::class)
class CoinRepository(
    private val coingeckoService: CoingeckoService,
    private val coinMarketCapService: CoinMarketCapService,
) : ICoinRepository {

    override suspend fun getCoinList(perPage: Int, page: Int): Flow<List<Coin>> {
        return flow {
            val coinResponse  = coingeckoService.getCoinList(perPage, page)
            emit(coinResponse.map { it.toCoin() })
        }
    }

    override suspend fun getListingsLatest(): List<Coin> {
        return coinMarketCapService.getListingsLatest().map { it.toCoin() }
    }
}

interface ICoinRepository {
    suspend fun getCoinList(perPage: Int, page: Int): Flow<List<Coin>>
    suspend fun getListingsLatest(): List<Coin>
}