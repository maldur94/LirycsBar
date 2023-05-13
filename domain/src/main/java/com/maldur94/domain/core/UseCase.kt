package com.maldur94.domain.core

interface UseCase<In, Out> {
    suspend fun execute(request: In): Out
}
