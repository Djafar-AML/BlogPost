package com.example.domain.repository

import com.example.domain.model.Blogs

interface BlogDetailsRepository {
    suspend fun getBlogDetails(blogId: String): Blogs.Blog
}