package com.maldur94.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import com.maldur94.database.model.Lirycs

@Dao
interface LirycsDao {

    @Query("SELECT * FROM lirycs ORDER BY name DESC")
    fun getAll(): List<Lirycs>

    @Insert(onConflict = REPLACE)
    fun insertAll(lirycs: List<Lirycs>)

    @Delete
    fun delete(liryc: Lirycs)
}
