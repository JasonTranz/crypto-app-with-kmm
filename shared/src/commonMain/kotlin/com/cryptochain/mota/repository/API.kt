package com.cryptochain.mota.repository

import com.cryptochain.mota.model.Coin

interface API {
    suspend fun getCoinList(): List<Coin>
}