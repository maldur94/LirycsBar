package com.maldur94.di.database

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

private const val BASE_API_URL = "LirycsBar Database"

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

//    @Provides
//    @Singleton
//    fun provideDatabaseManager(@ApplicationContext context: Context) = Room.databaseBuilder(
//        context,
//        DatabaseManager::class.java,
//        BASE_API_URL
//    ).build()
//
//    @Provides
//    fun provideLirycsDao(databaseManager: DatabaseManager) = databaseManager.lirycsDao
}
