package com.maldur94.database.model

import android.net.Uri
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.Gson
import com.maldur94.network.model.LirycDTO
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Parcelize
@Entity(tableName = "liryc")
data class Liryc(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "description") var description: String,
    @ColumnInfo(name = "iconUrl") val iconUrl: String? = null
) : Serializable, Parcelable {

    override fun toString(): String = Uri.encode(Gson().toJson(this))
}

fun LirycDTO.toEntity() = Liryc(
    id = id,
    title = title,
    description = description,
    iconUrl = iconUrl
)
