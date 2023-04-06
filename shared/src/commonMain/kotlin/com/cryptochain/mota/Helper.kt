package com.cryptochain.mota

import com.cryptochain.mota.di.appModule
import org.koin.core.context.startKoin

class HelperKt {

    fun initKoin() {
        startKoin {
            modules(appModule())
        }
    }
}