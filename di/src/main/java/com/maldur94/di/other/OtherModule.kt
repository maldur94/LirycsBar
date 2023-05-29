package com.maldur94.di.other

import android.content.Context
import android.content.res.Resources
import com.google.firebase.FirebaseApp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object OtherModule {

    @Provides
    fun provideFirebase(@ApplicationContext context: Context) = FirebaseApp.getInstance()

    @Singleton
    @Provides
    fun provideResources(@ApplicationContext context: Context): Resources = context.resources
}
