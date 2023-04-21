package com.example.blogpost.screens.home

import com.example.domain.model.Blogs

data class HomeState(
    val isLoading: Boolean = false,
    val data: List<Blogs.Blog>? = null,
    val error: String = ""
)
