package com.cryptochain.mota.repository

import com.cryptochain.mota.model.CoinResponse

interface API {
    suspend fun getCoinList(perPage: Int, page: Int): List<CoinResponse>
}