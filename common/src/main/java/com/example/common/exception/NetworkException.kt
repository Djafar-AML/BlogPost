package com.example.common.exception

class NetworkException(
    val statusCode: Int?,
    val errorMessage: String?,
    val exception: Exception?
) : Exception(errorMessage, exception)