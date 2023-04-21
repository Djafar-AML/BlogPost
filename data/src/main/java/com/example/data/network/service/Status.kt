package com.example.data.network.service

sealed class Status {
    object Success : Status()
    object Failure : Status()
}