package com.maldur94.di.database

import android.content.Context
import androidx.room.Room
import com.maldur94.database.DatabaseManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

private const val BASE_API_URL = "LirycsBar Database"

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabaseManager(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        DatabaseManager::class.java,
        BASE_API_URL
    ).build()

    @Provides
    fun provideLirycsDao(databaseManager: DatabaseManager) = databaseManager.lirycsDao
}
