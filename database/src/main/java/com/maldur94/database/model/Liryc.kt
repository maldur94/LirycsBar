package com.maldur94.database.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Parcelize
data class Liryc(
    var id: String? = null,
    var title: String = "",
    var description: String = "",
    val iconUrl: String? = null
) : Serializable, Parcelable
