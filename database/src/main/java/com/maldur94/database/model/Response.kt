package com.maldur94.database.model

sealed class Response<out T> {
    object Loading : Response<Nothing>()

    data class Success<out T>(val data: T) : Response<T>()

    data class Failure(val e: Exception?) : Response<Nothing>()

    fun isFailed() = this is Failure

    fun isSucceed() = this is Success && this.data != null

    fun isDataEmpty() = if (this is Success) (data as? List<*>)?.isEmpty() == true else true

    fun getItemCount() = if (this is Success) (data as List<*>).size else 0
}
