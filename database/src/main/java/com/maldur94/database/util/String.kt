package com.maldur94.database.util

import kotlinx.datetime.toKotlinLocalDateTime
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun String.toLocalDateTime(): kotlinx.datetime.LocalDateTime {
    val localDateTime = LocalDateTime.parse(this, DateTimeFormatter.ISO_DATE_TIME)
    return localDateTime.toKotlinLocalDateTime()
}
