package com.cryptochain.mota.service

import com.cryptochain.mota.api.CoingeckoApi
import com.cryptochain.mota.entity.CoinGeckoResponse
import com.cryptochain.mota.httpClient
import io.ktor.client.call.body
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.http.encodedPath
import io.ktor.http.takeFrom

class CoingeckoService : CoingeckoApi {
    companion object {
        private const val BASE_URL = "https://api.coingecko.com"

        /** API versions **/
        private const val API_V3 = "/api/v3"

        /** Path suffix **/
        private const val GET_COIN_MARKET_LIST = "coins/markets"

        /** Parameters **/
        private const val CURRENCY_TYPE = "vs_currency"
        private const val LIMIT = "per_page"
        private const val PAGE = "page"
    }

    private val client = httpClient { }

    private fun HttpRequestBuilder.coin(path: String): HttpRequestBuilder {
        url {
            takeFrom(BASE_URL)
            encodedPath = "$API_V3/$path"
        }
        return this
    }

    override suspend fun getCoinList(perPage: Int, page: Int): List<CoinGeckoResponse> {
        return try {
            client.get {
                coin(GET_COIN_MARKET_LIST).url {
                    parameters.append(CURRENCY_TYPE, "usd")
                    parameters.append(LIMIT, "$perPage")
                    parameters.append(PAGE, "$page")
                }
            }.body()
        } catch (e: Exception) {
            println("getCoinList exception: ${e.message}")
            emptyList()
        }
    }
}