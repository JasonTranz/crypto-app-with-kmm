package com.cryptochain.mota.di

import com.cryptochain.mota.repository.CoinRepository
import com.cryptochain.mota.service.CoinMarketCapService
import com.cryptochain.mota.service.CoingeckoService
import com.cryptochain.mota.viewModel.MarketCoinListViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val coinModule = module {
    singleOf(::MarketCoinListViewModel)
    singleOf(::CoinRepository)
    singleOf(::CoingeckoService)
    singleOf(::CoinMarketCapService)
}