package com.maldur94.network.service

import com.maldur94.network.model.LirycsDTO
import retrofit2.Response
import retrofit2.http.GET

interface LirycsService {

    @GET("/lirycs")
    suspend fun getLirycs(): Response<List<LirycsDTO>>
}
