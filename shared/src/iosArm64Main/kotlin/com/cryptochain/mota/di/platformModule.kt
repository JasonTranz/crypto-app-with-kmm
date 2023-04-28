package com.cryptochain.mota.di

import org.koin.core.module.Module
import org.koin.dsl.module
import com.cryptochain.mota.db.DriverFactory
import org.koin.core.module.dsl.singleOf

actual fun platformModule(): Module {
    return module {
        singleOf(::DriverFactory)
    }
}