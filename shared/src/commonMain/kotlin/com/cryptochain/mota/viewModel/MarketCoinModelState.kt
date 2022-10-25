package com.cryptochain.mota.viewModel

import com.cryptochain.mota.model.CoinResponse

data class MarketCoinModelState(
    val coins: List<CoinResponse> = emptyList()
)