package com.example.data.repository

import com.example.data.mapper.toDomain
import com.example.data.network.service.ApiClient
import com.example.domain.model.Blogs
import com.example.domain.repository.BlogsRepository

class BlogsRepositoryImpl(private val apiClient: ApiClient) : BlogsRepository {

    override suspend fun getBlogs(): List<Blogs.Blog> {

        val response = apiClient.getBlogs()

        return response.body.data.toDomain()

    }

}