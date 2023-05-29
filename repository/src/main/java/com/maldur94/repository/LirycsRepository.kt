package com.maldur94.repository

import com.maldur94.database.model.Liryc
import com.maldur94.database.model.Response
import kotlinx.coroutines.flow.Flow

typealias LirycsResponse = Response<List<Liryc>>
typealias StatusResponse = Response<Boolean>

interface LirycsRepository {
    suspend fun getLirycsFromFirebase(): Flow<LirycsResponse>
    suspend fun addLirycToFirebase(liryc: Liryc): StatusResponse
    suspend fun editLirycToFirebase(oldAndNewLirycs: Pair<Liryc, Liryc>): StatusResponse
    suspend fun removeLirycFromFirebase(liryc: Liryc): StatusResponse
}
