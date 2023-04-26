package com.cryptochain.mota.model

data class CoinListModelState(
    val coins: List<Coin> = listOf(),
    val errorMsg: String? = null
)