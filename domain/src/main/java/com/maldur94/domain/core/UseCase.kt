package com.maldur94.domain.core

interface UseCase<out O> {
    suspend fun execute(): O
}
