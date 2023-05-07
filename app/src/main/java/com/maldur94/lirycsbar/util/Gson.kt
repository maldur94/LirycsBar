package com.maldur94.lirycsbar.util

import com.google.gson.Gson

fun <T> T.toGson() = Gson().toJson(this)

inline fun <reified T> String.fromGson() = Gson().fromJson(this, T::class.java)
