package com.example.common.util

import com.example.common.exception.ErrorEntity

sealed class Resource<T>(val data: T? = null, val errorEntity: ErrorEntity? = null) {

    class Success<T>(data: T?) : Resource<T>(data = data)

    class Loading<T> : Resource<T>()

    class Error<T>(error: ErrorEntity?) : Resource<T>(errorEntity = error)

}