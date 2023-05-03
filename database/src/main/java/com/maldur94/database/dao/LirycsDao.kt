package com.maldur94.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import com.maldur94.database.model.Liryc

@Dao
interface LirycsDao {

    @Query("SELECT * FROM liryc ORDER BY title DESC")
    fun getAll(): List<Liryc>

    @Insert(onConflict = REPLACE)
    fun insertAll(lirycs: List<Liryc>)

    @Delete
    fun delete(liryc: Liryc)
}
