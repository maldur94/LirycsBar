package com.maldur94.database.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.maldur94.database.model.Lirycs
import kotlinx.datetime.LocalDateTime

class DatabaseTypeConverters {

    @TypeConverter
    fun fromLocalDateTimeToString(value: LocalDateTime): String = Gson().toJson(value)

    @TypeConverter
    fun stringToLocalDateTime(value: String): LocalDateTime =
        Gson().fromJson(value, LocalDateTime::class.java)

    @TypeConverter
    fun fromLirycsToString(value: Lirycs): String = Gson().toJson(value)

    @TypeConverter
    fun stringToLirycs(value: String): Lirycs = Gson().fromJson(value, Lirycs::class.java)
}
