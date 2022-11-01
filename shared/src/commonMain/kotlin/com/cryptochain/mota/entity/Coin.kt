package com.cryptochain.mota.entity

data class Coin(
    val id: String = "",
    val name: String = "",
    val price: Double = 0.0,
    val symbol: String = "",
    val image: String = "",
    val priceChangePercentage24h: Double = 0.0
)