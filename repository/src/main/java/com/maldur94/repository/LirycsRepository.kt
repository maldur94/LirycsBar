package com.maldur94.repository

import com.maldur94.database.model.Liryc

interface LirycsRepository {
    suspend fun getLirycs(): List<Liryc>
    suspend fun addLiryc(liryc: Liryc): List<Liryc>
    suspend fun editLiryc(liryc: Liryc): List<Liryc>
    suspend fun removeLiryc(liryc: Liryc): List<Liryc>
}
