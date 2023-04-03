package com.cryptochain.mota.viewModel

import com.cryptochain.mota.entity.Coin

data class MarketCoinModelState(
    val coins: List<Coin> = listOf(),
    val errorMsg: String = ""
)