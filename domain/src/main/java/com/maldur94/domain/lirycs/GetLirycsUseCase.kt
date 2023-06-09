package com.maldur94.domain.lirycs

import com.maldur94.di.other.LirycsRepositoryInject
import com.maldur94.di.other.NetworkLayerInject
import com.maldur94.domain.core.EmptyUseCase
import com.maldur94.network.NetworkLayer
import com.maldur94.repository.LirycsRepository
import com.maldur94.repository.LirycsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetLirycsUseCase @Inject constructor(
    @LirycsRepositoryInject private val repository: LirycsRepository,
    @NetworkLayerInject networkLayer: NetworkLayer
) : NetworkLayer by networkLayer, EmptyUseCase<Flow<LirycsResponse>?> {

    override suspend fun execute(): Flow<LirycsResponse>? {
        return call {
            withContext(Dispatchers.IO) {
                repository.getLirycsFromFirebase()
            }
        }
    }
}
