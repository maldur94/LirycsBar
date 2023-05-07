package com.maldur94.network.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LirycDTO(
    val id: Int,
    val title: String,
    val description: String,
    val iconUrl: String? = null
) : Parcelable
