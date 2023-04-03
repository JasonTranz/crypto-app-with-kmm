package com.cryptochain.mota

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

internal actual fun epochSeconds(): Long = System.currentTimeMillis() / 1_000

@RequiresApi(Build.VERSION_CODES.O)
private val timeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")

@RequiresApi(Build.VERSION_CODES.O)
internal actual fun formatTime(epochSeconds: Long): String =
    LocalDateTime.ofEpochSecond(epochSeconds, 0, ZoneOffset.UTC).format(timeFormatter)
