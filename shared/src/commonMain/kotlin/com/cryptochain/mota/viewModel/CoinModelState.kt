package com.cryptochain.mota.viewModel

import com.cryptochain.mota.model.Coin

data class CoinListModelState(
    val coins: List<Coin> = listOf(),
    val errorMsg: String? = null
)