package com.example.common.util

import com.example.common.exception.ErrorEntity

sealed class Result<T> {

    class Success<T>(val data: T) : Result<T>()

    class Error<T>(val errorEntity: ErrorEntity) : Result<T>()

}