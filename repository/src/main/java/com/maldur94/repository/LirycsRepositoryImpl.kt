package com.maldur94.repository

import com.maldur94.database.dao.LirycsDao
import com.maldur94.database.model.Liryc
import com.maldur94.database.model.toEntity
import com.maldur94.network.service.LirycsService
import javax.inject.Inject

class LirycsRepositoryImpl @Inject constructor(
    private val service: LirycsService,
    private val dao: LirycsDao
) : LirycsRepository {

    override suspend fun getLirycs(): List<Liryc> {
        val lirycsDTO = service.getLirycs().body()
        val lirycs = (lirycsDTO?.map { it.toEntity() } ?: emptyList())
        if (lirycs.isNotEmpty()) dao.insertAll(lirycs)
        return lirycs
    }
}
