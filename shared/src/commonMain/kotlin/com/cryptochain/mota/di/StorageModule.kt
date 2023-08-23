package com.cryptochain.mota.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import com.cryptochain.mota.db.Database
import com.cryptochain.mota.db.SharePreferences

val storageModule = module {
    singleOf(::Database)
    singleOf(::SharePreferences)
}