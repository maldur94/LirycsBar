package com.maldur94.database.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.maldur94.database.model.Lirycs

class DatabaseTypeConverters {

    @TypeConverter
    fun fromLirycsToString(value: Lirycs): String = Gson().toJson(value)

    @TypeConverter
    fun stringToLirycs(value: String): Lirycs = Gson().fromJson(value, Lirycs::class.java)
}
