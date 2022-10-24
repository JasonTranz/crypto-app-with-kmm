package com.cryptochain.mota.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Coin(
    @SerializedName("id") val id: String? = null,
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
)