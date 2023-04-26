package com.example.data.network.service

sealed class SimpleResponse<T>(
    private val data: T? = null,
    private val throwable: Throwable? = null
) {

    data class Success<T>(val data: T) : SimpleResponse<T>(data)
    data class Failure<T>(val throwable: Throwable?) : SimpleResponse<T>(throwable = throwable)

}