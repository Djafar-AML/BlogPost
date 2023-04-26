package com.example.blogpost.util

import com.example.common.exception.ErrorEntity


fun localizeErrorMessage(errorEntity: ErrorEntity) =
    when (errorEntity) {

        is ErrorEntity.AccessDenied -> {
            "Access denied!"
        }
        is ErrorEntity.Network -> {
            "Network error"
        }
        is ErrorEntity.NotFound -> {
            "Not found"
        }
        is ErrorEntity.ServiceUnavailable -> {
            "Service unavailable"
        }
        is ErrorEntity.Unknown -> {
            "Unknown error"
        }
        else -> {
            "Something went wrong"
        }
    }
