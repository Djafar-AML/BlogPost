package com.example.data.repository

import com.example.data.mapper.toDomain
import com.example.data.network.service.ApiClient
import com.example.domain.model.Blogs
import com.example.domain.repository.BlogDetailsRepository

class BlogDetailsRepositoryImpl(private val apiClient: ApiClient) : BlogDetailsRepository {

    override suspend fun getBlogDetails(blogId: String): Blogs.Blog {
        val response = apiClient.getBlogDetails(blogId)
        return response.body.toDomain()
    }
}
