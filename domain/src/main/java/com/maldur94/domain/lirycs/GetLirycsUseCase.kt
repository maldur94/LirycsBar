package com.maldur94.domain.lirycs

import com.maldur94.database.model.Liryc
import com.maldur94.di.other.LirycsRepositoryInject
import com.maldur94.di.other.NetworkLayerInject
import com.maldur94.domain.core.EmptyUseCase
import com.maldur94.network.NetworkLayer
import com.maldur94.repository.LirycsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetLirycsUseCase @Inject constructor(
    @LirycsRepositoryInject private val repository: LirycsRepository,
    @NetworkLayerInject networkLayer: NetworkLayer
) : NetworkLayer by networkLayer, EmptyUseCase<List<Liryc>?> {

    override suspend fun execute(): List<Liryc>? {
        return call {
            withContext(Dispatchers.IO) {
                repository.getLirycs()
            }
        }
    }
}
