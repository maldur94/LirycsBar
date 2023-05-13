package com.maldur94.repository

import com.maldur94.database.dao.LirycsDao
import com.maldur94.database.model.Liryc
import com.maldur94.network.service.LirycsService
import javax.inject.Inject

class LirycsRepositoryImpl @Inject constructor(
    private val service: LirycsService,
    private val dao: LirycsDao
) : LirycsRepository {

    override suspend fun getLirycs(): List<Liryc> {
        return dao.getAll()
    }

    override suspend fun addLiryc(liryc: Liryc): List<Liryc> {
        dao.add(liryc)
        return dao.getAll()
    }

    override suspend fun editLiryc(liryc: Liryc): List<Liryc> {
        dao.edit(liryc)
        return dao.getAll()
    }

    override suspend fun removeLiryc(liryc: Liryc): List<Liryc> {
        dao.remove(liryc)
        return dao.getAll()
    }
}
