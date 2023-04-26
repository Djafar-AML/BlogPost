package com.example.common.util

import com.example.common.exception.ErrorEntity

sealed class Resource<T>(private val data: T? = null, private val errorEntity: ErrorEntity? = null) {

    class Success<T>(val data: T) : Resource<T>(data = data)

    class Loading<T> : Resource<T>()

    class Error<T>(val errorEntity: ErrorEntity) : Resource<T>(errorEntity = errorEntity)

}