package com.example.domain.repository

import com.example.common.exception.ErrorEntity

interface LocalError {
    fun mapThrowableToErrorEntity(throwable: Throwable): ErrorEntity
}