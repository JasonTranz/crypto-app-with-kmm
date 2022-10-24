package com.cryptochain.mota

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig

interface Platform {
    val name: String
    val baseUrl: String
}

expect fun getPlatform(): Platform
expect fun httpClient(config: HttpClientConfig<*>.() -> Unit): HttpClient