package com.cryptochain.mota.model

import kotlinx.serialization.SerialName

data class CoinCMCResponse(
    @SerialName("circulating_supply") val circulatingSupply: Int? = null,
    @SerialName("cmc_rank") val cmcRank: Int? = null,
    @SerialName("date_added") val dateAdded: String? = null,
    @SerialName("id") val id: Int? = null,
    @SerialName("last_updated") val lastUpdated: String? = null,
    @SerialName("max_supply") val maxSupply: Int? = null,
    @SerialName("name") val name: String? = null,
    @SerialName("num_market_pairs") val numMarketPairs: Int? = null,
    @SerialName("platform") val platform: Any? = null,
    @SerialName("quote") val quote: Quote? = null,
    @SerialName("self_reported_circulating_supply") val selfReportedCirculatingSupply: Any? = null,
    @SerialName("self_reported_market_cap") val selfReportedMarketCap: Any? = null,
    @SerialName("slug") val slug: String? = null,
    @SerialName("symbol") val symbol: String? = null,
    @SerialName("tags") val tags: List<String>? = null,
    @SerialName("total_supply") val totalSupply: Int? = null,
    @SerialName("tvl_ratio") val tvlRatio: Any? = null
)

data class Quote(
    @SerialName("USD") val usd: USD? = null
)

data class USD(
    @SerialName("fully_diluted_market_cap") val fullyDilutedMarketCap: Double? = null,
    @SerialName("last_updated") val lastUpdated: String? = null,
    @SerialName("market_cap") val marketCap: Double? = null,
    @SerialName("price") val price: Double? = null,
    @SerialName("volume_24h") val volume24h: Double? = null,
    @SerialName("volume_change_24h") val volumeChange24h: Double? = null,
    @SerialName("market_cap_dominance") val marketCapDominance: Double? = null,
    @SerialName("percent_change_1h") val percentChange1h: Double? = null,
    @SerialName("percent_change_24h") val percentChange24h: Double? = null,
    @SerialName("percent_change_7d") val percentChange7d: Double? = null,
    @SerialName("percent_change_30d") val percentChange30d: Double? = null,
    @SerialName("percent_change_60d") val percentChange60d: Double? = null,
    @SerialName("percent_change_90d") val percentChange90d: Double? = null,
    @SerialName("USD") val tvl: Any? = null
)