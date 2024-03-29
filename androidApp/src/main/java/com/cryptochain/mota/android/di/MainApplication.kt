package com.cryptochain.mota.android.di

import android.app.Application
import com.cryptochain.mota.di.appModule
import com.google.firebase.FirebaseApp
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApplication)
            androidLogger()

            FirebaseApp.initializeApp(this@MainApplication)

            modules(appModule())
        }
    }
}