package com.example.common.util

import com.example.common.exception.ErrorEntity

sealed class Result<T>(
    private val data: T? = null,
    private val errorEntity: ErrorEntity? = null
) {

    class Success<T>(val data: T) : Result<T>(data = data)

    class Error<T>(val errorEntity: ErrorEntity) : Result<T>(errorEntity = errorEntity)

}