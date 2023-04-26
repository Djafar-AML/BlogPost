package com.example.data.repository

import com.example.common.exception.ErrorEntity
import com.example.domain.repository.LocalError
import retrofit2.HttpException
import java.io.IOException
import java.net.HttpURLConnection

class LocalErrorImpl : LocalError {

    override fun mapThrowableToErrorEntity(throwable: Throwable): ErrorEntity {

        return when (throwable) {

            is HttpException -> {

                when (throwable.code()) {

                    HttpURLConnection.HTTP_BAD_GATEWAY -> ErrorEntity.Network

                    // not found
                    HttpURLConnection.HTTP_NOT_FOUND -> ErrorEntity.NotFound

                    // access denied
                    HttpURLConnection.HTTP_FORBIDDEN -> ErrorEntity.AccessDenied

                    // unavailable service
                    HttpURLConnection.HTTP_UNAVAILABLE -> ErrorEntity.ServiceUnavailable

                    // all the others will be treated as unknown error
                    else -> ErrorEntity.Unknown
                }
            }

            is IOException -> ErrorEntity.Network

            else -> {
                ErrorEntity.Unknown
            }

        }

    }

}