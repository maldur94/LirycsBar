package com.maldur94.database.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Parcelize
@Entity(tableName = "lirycs")
data class Lirycs(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String,
) : Serializable, Parcelable
