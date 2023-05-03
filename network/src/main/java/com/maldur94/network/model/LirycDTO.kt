package com.maldur94.network.model

import android.os.Parcelable
import kotlinx.datetime.LocalDateTime
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class LirycDTO(
    val id: Int,
    val title: String,
    val description: String,
    val createdAt: @RawValue LocalDateTime,
    val iconUrl: String
) : Parcelable
