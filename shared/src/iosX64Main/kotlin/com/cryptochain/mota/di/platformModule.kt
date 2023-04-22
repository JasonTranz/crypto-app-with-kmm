package com.cryptochain.mota.di

import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import com.cryptochain.mota.db.DriverFactory

actual fun platformModule(): Module {
    return module {
        singleOf(::DriverFactory)
    }
}