package com.cryptochain.mota.repository

import com.cryptochain.mota.entity.Coin
import com.cryptochain.mota.mapper.toCoin
import com.cryptochain.mota.service.CoinMarketCapService
import com.cryptochain.mota.service.CoingeckoService
import kotlinx.coroutines.FlowPreview

@OptIn(FlowPreview::class)
class CoinRepository(
    private val coingeckoService: CoingeckoService,
    private val coinMarketCapService: CoinMarketCapService,
) : ICoinRepository {

    override suspend fun getCoinList(perPage: Int, page: Int): List<Coin> {
        return coingeckoService.getCoinList(perPage, page).map { it.toCoin() }
    }

    override suspend fun getListingsLatest(): List<Coin> {
        return coinMarketCapService.getListingsLatest().map { it.toCoin() }
    }
}

interface ICoinRepository {
    suspend fun getCoinList(perPage: Int, page: Int): List<Coin>
    suspend fun getListingsLatest(): List<Coin>
}