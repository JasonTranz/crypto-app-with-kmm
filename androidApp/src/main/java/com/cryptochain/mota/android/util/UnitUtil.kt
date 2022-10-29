package com.cryptochain.mota.android.util

object UnitUtil {
    fun Double?.formatPercentage(): String {
        return "${String.format("%.1f", this)}%"
    }
}