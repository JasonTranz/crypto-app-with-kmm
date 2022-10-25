package com.cryptochain.mota.di

import com.cryptochain.mota.services.CoinService
import com.cryptochain.mota.viewModel.MarketCoinListViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val marketCoinListViewModel = module {
    singleOf(::MarketCoinListViewModel)
    singleOf(::CoinService)
}