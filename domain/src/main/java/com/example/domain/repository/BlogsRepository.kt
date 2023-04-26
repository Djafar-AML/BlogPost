package com.example.domain.repository

import com.example.domain.model.Blogs

interface BlogsRepository {
    suspend fun getBlogs(): com.example.common.util.Result<List<Blogs.Blog>>
}