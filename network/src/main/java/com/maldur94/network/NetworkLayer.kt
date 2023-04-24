package com.maldur94.network

interface NetworkLayer {
    suspend fun <R> call(call: suspend () -> R): R?
}
