package com.example.domain.repository

import com.example.common.util.Result
import com.example.domain.model.Blogs

interface BlogDetailsRepository {
    suspend fun getBlogDetails(blogId: String): Result<Blogs.Blog>
}