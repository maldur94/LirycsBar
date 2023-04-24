package com.maldur94.network.model

import android.os.Parcelable
import kotlinx.datetime.LocalDateTime
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class LirycsDTO(
    val id: Int,
    val name: String,
    val createdAt: @RawValue LocalDateTime,
    val iconUrl: String
) : Parcelable
