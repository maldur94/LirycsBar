package com.maldur94.repository

import com.maldur94.database.model.Liryc

interface LirycsRepository {
    suspend fun getLirycs(): List<Liryc>
}
