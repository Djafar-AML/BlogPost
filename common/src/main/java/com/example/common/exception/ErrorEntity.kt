package com.example.common.exception

sealed class ErrorEntity {

    object Network : ErrorEntity()

    object NotFound : ErrorEntity()

    object AccessDenied : ErrorEntity()

    object ServiceUnavailable : ErrorEntity()

    object Unknown : ErrorEntity()
}