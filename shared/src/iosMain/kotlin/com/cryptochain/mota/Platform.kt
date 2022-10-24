package com.cryptochain.mota

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.ios.Ios
import platform.UIKit.UIDevice

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
    override val baseUrl: String = "https://api.coingecko.com/api/v3"
}

actual fun getPlatform(): Platform = IOSPlatform()
actual fun httpClient(config: HttpClientConfig<*>.() -> Unit) = HttpClient(Ios) {
    config(this)

    engine {
        configureRequest {
            setAllowsCellularAccess(true)
        }
    }
}