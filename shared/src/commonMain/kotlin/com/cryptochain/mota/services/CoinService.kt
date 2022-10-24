package com.cryptochain.mota.services

import com.cryptochain.mota.common.AppConstant.BASE_URL
import com.cryptochain.mota.httpClient
import com.cryptochain.mota.model.Coin
import com.cryptochain.mota.repository.API
import io.ktor.client.call.body
import io.ktor.client.request.get

class CoinService : API {
    private val httpClient = httpClient {  }

    override suspend fun getCoinList(): List<Coin> {
        val url = BASE_URL.plus("/coins/list")
        return httpClient.get(url).body()
    }
}