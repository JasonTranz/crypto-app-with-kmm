package com.cryptochain.mota.api

import com.cryptochain.mota.entity.CoinCMCResponse

interface CoinMarketCapApi {
    suspend fun getListingsLatest(): List<CoinCMCResponse>
}