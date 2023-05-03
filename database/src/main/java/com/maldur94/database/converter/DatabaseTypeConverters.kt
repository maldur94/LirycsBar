package com.maldur94.database.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.maldur94.database.model.Liryc
import kotlinx.datetime.LocalDateTime

class DatabaseTypeConverters {

    @TypeConverter
    fun fromLocalDateTimeToString(value: LocalDateTime): String = Gson().toJson(value)

    @TypeConverter
    fun stringToLocalDateTime(value: String): LocalDateTime =
        Gson().fromJson(value, LocalDateTime::class.java)

    @TypeConverter
    fun fromLirycToString(value: Liryc): String = Gson().toJson(value)

    @TypeConverter
    fun stringToLiryc(value: String): Liryc = Gson().fromJson(value, Liryc::class.java)
}
