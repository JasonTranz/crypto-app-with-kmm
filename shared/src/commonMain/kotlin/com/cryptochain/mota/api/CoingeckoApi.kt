package com.cryptochain.mota.api

import com.cryptochain.mota.model.CoinResponse

interface CoingeckoApi {
    suspend fun getCoinList(perPage: Int, page: Int): List<CoinResponse>
}