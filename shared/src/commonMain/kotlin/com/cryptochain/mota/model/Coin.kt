package com.cryptochain.mota.model

data class Coin(
    var id: String = "",
    var name: String = "",
    var price: Double = 0.0,
    var symbol: String = "",
    var image: String = "",
    var priceChangePercentage24h: Double = 0.0
)