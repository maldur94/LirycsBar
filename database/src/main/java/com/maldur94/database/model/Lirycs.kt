package com.maldur94.database.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.maldur94.network.model.LirycsDTO
import kotlinx.datetime.LocalDateTime
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue
import java.io.Serializable

@Parcelize
@Entity(tableName = "lirycs")
data class Lirycs(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "createdAt") val createdAt: @RawValue LocalDateTime,
    @ColumnInfo(name = "iconUrl") val iconUrl: String
) : Serializable, Parcelable

fun LirycsDTO.toEntity() = Lirycs(
    id = id,
    name = name,
    createdAt = createdAt,
    iconUrl = iconUrl
)
