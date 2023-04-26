package com.example.data.repository

import com.example.common.util.Result
import com.example.data.mapper.toDomain
import com.example.data.network.service.ApiClient
import com.example.data.network.service.SimpleResponse
import com.example.domain.exception.LocalException
import com.example.domain.model.Blogs
import com.example.domain.repository.BlogDetailsRepository

class BlogDetailsRepositoryImpl(
    private val apiClient: ApiClient,
    private val localException: LocalException,
) : BlogDetailsRepository {

    override suspend fun getBlogDetails(blogId: String): Result<Blogs.Blog> {

        return when (val response = apiClient.getBlogDetails(blogId)) {

            is SimpleResponse.Success -> {
                val blogDetails: Blogs.Blog = response.data.toDomain()
                Result.Success(blogDetails)
            }

            is SimpleResponse.Failure -> {
                val throwable = response.throwable
                val errorEntity = localException.mapThrowableToErrorEntity(throwable)
                Result.Error(errorEntity)
            }

        }

    }

}
