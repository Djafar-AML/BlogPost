package com.example.common.util

import com.example.common.exception.ErrorEntity

sealed class Resource<T> {

    class Success<T>(val data: T) : Resource<T>()

    class Loading<T> : Resource<T>()

    class Error<T>(val errorEntity: ErrorEntity) : Resource<T>()

}