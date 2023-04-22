package com.cryptochain.mota.mapper

import com.cryptochain.mota.entity.CoinCMCResponse
import com.cryptochain.mota.entity.CoinGeckoResponse
import com.cryptochain.mota.model.Coin
import db.CoinLocal

fun CoinGeckoResponse.toCoin(): Coin {
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

fun CoinLocal.toCoin(): Coin {
    return Coin(
        id = this.id,
        name = this.name,
        symbol = this.symbol,
        price = this.price,
        image = this.imageUrl,
        priceChangePercentage24h = this.priceChangePercentage24h
    )
}

fun Coin.toCoinLocal(): CoinLocal {
    return CoinLocal(
        id = this.id,
        name = this.name,
        symbol = this.symbol,
        price = this.price,
        imageUrl = this.image,
        priceChangePercentage24h = this.priceChangePercentage24h
    )
}