package com.maldur94.database.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.maldur94.network.model.LirycDTO
import kotlinx.datetime.LocalDateTime
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue
import java.io.Serializable

@Parcelize
@Entity(tableName = "liryc")
data class Liryc(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "createdAt") val createdAt: @RawValue LocalDateTime,
    @ColumnInfo(name = "iconUrl") val iconUrl: String
) : Serializable, Parcelable

fun LirycDTO.toEntity() = Liryc(
    id = id,
    title = title,
    description = description,
    createdAt = createdAt,
    iconUrl = iconUrl
)
