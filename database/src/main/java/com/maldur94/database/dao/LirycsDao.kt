package com.maldur94.database.dao

import androidx.room.*
import androidx.room.OnConflictStrategy.Companion.REPLACE
import com.maldur94.database.model.Liryc

@Dao
interface LirycsDao {

    @Query("SELECT * FROM liryc ORDER BY title DESC")
    fun getAll(): List<Liryc>

    @Insert(onConflict = REPLACE)
    fun insertAll(lirycs: List<Liryc>)

    @Insert
    fun add(liryc: Liryc)

    @Update
    fun edit(liryc: Liryc)

    @Delete
    fun remove(liryc: Liryc)
}
