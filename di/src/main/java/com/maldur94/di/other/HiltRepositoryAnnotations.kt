package com.maldur94.di.other

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class UserRepositoryInject

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class NetworkLayerInject
