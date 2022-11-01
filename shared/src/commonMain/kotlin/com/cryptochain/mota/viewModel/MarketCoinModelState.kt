package com.cryptochain.mota.viewModel

import com.cryptochain.mota.entity.Coin

data class MarketCoinModelState(
    val coins: List<Coin> = emptyList(),
)