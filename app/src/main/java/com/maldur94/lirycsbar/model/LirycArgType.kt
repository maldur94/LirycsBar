package com.maldur94.lirycsbar.model

import com.google.gson.Gson
import com.maldur94.database.model.Liryc

class LirycArgType : JsonNavType<Liryc>() {

    override fun fromJsonParse(value: String): Liryc = Gson().fromJson(value, Liryc::class.java)

    override fun Liryc.getJsonParse(): String = Gson().toJson(this)
}
