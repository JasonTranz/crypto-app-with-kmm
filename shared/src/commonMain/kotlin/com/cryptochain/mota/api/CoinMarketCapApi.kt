package com.cryptochain.mota.api

import com.cryptochain.mota.model.CoinCMCResponse

interface CoinMarketCapApi {
    suspend fun getListingsLatest(): List<CoinCMCResponse>
}