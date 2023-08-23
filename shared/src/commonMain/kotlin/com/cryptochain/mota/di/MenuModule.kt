package com.cryptochain.mota.di

import org.koin.dsl.module
import com.cryptochain.mota.viewModel.MenuKMMViewModel
import org.koin.core.module.dsl.singleOf

val menuModule = module {
    singleOf(::MenuKMMViewModel)
}