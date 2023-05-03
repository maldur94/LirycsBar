package com.maldur94.di.repository

import com.maldur94.database.dao.LirycsDao
import com.maldur94.di.other.LirycsRepositoryInject
import com.maldur94.network.service.LirycsService
import com.maldur94.repository.LirycsRepository
import com.maldur94.repository.LirycsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @LirycsRepositoryInject
    @Provides
    fun provideUserRepository(service: LirycsService, dao: LirycsDao): LirycsRepository {
        return LirycsRepositoryImpl(service = service, dao = dao)
    }
}
