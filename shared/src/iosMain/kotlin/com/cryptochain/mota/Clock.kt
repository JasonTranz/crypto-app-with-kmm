package com.cryptochain.mota

import platform.Foundation.NSDate
import platform.Foundation.NSDateFormatter
import platform.Foundation.date
import platform.Foundation.dateWithTimeIntervalSince1970
import platform.Foundation.timeIntervalSince1970

internal actual fun epochSeconds(): Long = NSDate.date().timeIntervalSince1970().toLong()

private val timeFormatter = NSDateFormatter().apply {
    setLocalizedDateFormatFromTemplate("dd-MM-yyyy HH:mm:ss")
}

internal actual fun formatTime(epochSeconds: Long): String =
    timeFormatter.stringFromDate(NSDate.dateWithTimeIntervalSince1970(epochSeconds.toDouble()))
