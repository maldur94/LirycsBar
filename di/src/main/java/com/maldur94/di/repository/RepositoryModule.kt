package com.maldur94.di.repository

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.maldur94.database.model.Constants
import com.maldur94.di.other.LirycsRepositoryInject
import com.maldur94.repository.LirycsRepository
import com.maldur94.repository.LirycsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideLirycsRef() = Firebase.firestore.collection(Constants.LIRYCS)

    @LirycsRepositoryInject
    @Provides
    fun provideLirycsRepository(lirycsRef: CollectionReference): LirycsRepository =
        LirycsRepositoryImpl(lirycsRef)
}
