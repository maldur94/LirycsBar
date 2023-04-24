package com.maldur94.network.response

import timber.log.Timber

private const val RESOURCE_RESPONSE_SUCCESS = "ResponseResource.success="
private const val RESOURCE_RESPONSE_ERROR = "ResponseResource.error="
private const val RESOURCE_RESPONSE_LOADING = "ResponseResource=loading..."

data class ResponseResource<out E>(
    val status: ResourceStatus,
    val data: E? = null,
    val message: String? = null
) {

    companion object {

        fun <T> loading(): ResponseResource<T> {
            Timber.i(RESOURCE_RESPONSE_LOADING)
            return ResponseResource(status = ResourceStatus.LOADING)
        }

        fun <T> success(data: T?): ResponseResource<T> {
            Timber.i(RESOURCE_RESPONSE_SUCCESS + data)
            return ResponseResource(status = ResourceStatus.SUCCESS, data = data)
        }

        fun <T> error(message: String? = null): ResponseResource<T> {
            Timber.e(RESOURCE_RESPONSE_ERROR + message)
            return ResponseResource(status = ResourceStatus.ERROR, message = message)
        }
    }
}