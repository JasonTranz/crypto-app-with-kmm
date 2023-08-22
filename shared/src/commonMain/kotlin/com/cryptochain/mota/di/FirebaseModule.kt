package com.cryptochain.mota.di

import org.koin.dsl.module
import com.cryptochain.mota.repository.FirebaseRepository
import org.koin.core.module.dsl.singleOf

val firebaseModule = module {
    singleOf(::FirebaseRepository)
}