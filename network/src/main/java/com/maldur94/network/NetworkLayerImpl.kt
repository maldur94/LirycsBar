package com.maldur94.network

class NetworkLayerImpl : NetworkLayer {

    override suspend fun <R> call(call: suspend () -> R): R? {
        try {
            return call()
        } catch (e: Exception) {
            //   TODO: add some exception
        }
        return null
    }
}
