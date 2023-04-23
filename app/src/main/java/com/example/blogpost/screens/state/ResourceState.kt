package com.example.blogpost.screens.state

data class ResourceState<T>(
    val isLoading: Boolean = false,
    val data: T? = null,
    val error: String = ""
)