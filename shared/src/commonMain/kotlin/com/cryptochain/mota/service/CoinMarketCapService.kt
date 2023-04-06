package com.cryptochain.mota.service

import com.cryptochain.mota.api.CoinMarketCapApi
import com.cryptochain.mota.httpClient
import com.cryptochain.mota.entity.CoinCMCResponse
import io.ktor.client.call.body
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.http.encodedPath
import io.ktor.http.takeFrom

class CoinMarketCapService : CoinMarketCapApi {
    companion object {
        private const val BASE_URL = "https://pro-api.coinmarketcap.com"

        /** API versions **/
        private const val API_V1 = "/v1/cryptocurrency"

        /** Path suffix **/
        private const val GET_COIN_MARKET_LIST = "listings/latest"

        private const val X_CMC_PRO_API_KEY = "df6433e5-38b9-456c-8059-cf15353f8e0f"
    }

    private val client = httpClient { }

    private fun HttpRequestBuilder.coin(path: String): HttpRequestBuilder {
        url {
            takeFrom(BASE_URL)
            encodedPath = "$API_V1/$path"
        }
        return this
    }

    override suspend fun getListingsLatest(): List<CoinCMCResponse> {
        return try {
            client.get {
                coin(GET_COIN_MARKET_LIST)
                header("X_CMC_PRO_API_KEY", X_CMC_PRO_API_KEY)
            }.body()
        } catch (e: Exception) {
            println("getCoinList: ${e.message}")
            emptyList()
        }
    }
}