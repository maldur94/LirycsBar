package com.maldur94.repository

import com.maldur94.database.model.Lirycs

interface LirycsRepository {
    suspend fun getLirycs(): List<Lirycs>
}
