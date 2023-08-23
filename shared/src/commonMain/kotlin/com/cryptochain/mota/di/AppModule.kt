package com.cryptochain.mota.di

fun appModule() = listOf(
    platformModule(),
    coinModule,
    menuModule,
    storageModule,
    firebaseModule
)