package com.cryptochain.mota.di

import org.koin.dsl.module
import com.cryptochain.mota.viewModel.MenuViewModel
import org.koin.core.module.dsl.singleOf
import com.cryptochain.mota.db.SharePreferences

val menuModule = module {
    singleOf(::SharePreferences)
    singleOf(::MenuViewModel)
}