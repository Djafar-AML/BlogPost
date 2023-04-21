package com.example.domain.repository

import com.example.domain.model.Blogs

interface BlogsRepository {
    suspend fun getBlogs(): List<Blogs.Blog>
}