package com.cryptochain.mota.api

import com.cryptochain.mota.entity.CoinGeckoResponse

interface CoingeckoApi {
    suspend fun getCoinList(perPage: Int, page: Int): List<CoinGeckoResponse>
}