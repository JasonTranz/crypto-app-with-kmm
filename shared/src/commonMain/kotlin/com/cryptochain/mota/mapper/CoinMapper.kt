package com.cryptochain.mota.mapper

import com.cryptochain.mota.entity.Coin
import com.cryptochain.mota.model.CoinCMCResponse
import com.cryptochain.mota.model.CoinResponse

fun CoinResponse.toCoin(): Coin {
    return Coin(
        id = this.id ?: "",
        name = this.name ?: "",
        price = this.currentPrice ?: 0.0,
        symbol = this.symbol ?: "",
        image = this.image ?: "",
        priceChangePercentage24h = this.priceChangePercentage24h ?: 0.0
    )
}

fun CoinCMCResponse.toCoin(): Coin {
    return Coin(
        id = this.id.toString(),
        name = this.name ?: "",
        price = this.quote?.usd?.price ?: 0.0,
        symbol = this.symbol ?: "",
        priceChangePercentage24h = this.quote?.usd?.percentChange24h ?: 0.0
    )
}