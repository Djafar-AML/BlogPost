package com.example.data.network.service

sealed class SimpleResponse<T> {

    data class Success<T>(val data: T) : SimpleResponse<T>()
    data class Failure<T>(val throwable: Throwable) : SimpleResponse<T>()

}