package com.example.blogpost.screens.state

data class UiResourceState<T>(
    val isLoading: Boolean = false,
    val data: T? = null,
    val error: String = ""
)