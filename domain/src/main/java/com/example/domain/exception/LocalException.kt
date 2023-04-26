package com.example.domain.exception

import com.example.common.exception.ErrorEntity

interface LocalException {
    fun mapThrowableToErrorEntity(throwable: Throwable): ErrorEntity
}