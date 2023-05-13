package com.maldur94.domain.core

interface EmptyUseCase<Out> {
    suspend fun execute(): Out
}
