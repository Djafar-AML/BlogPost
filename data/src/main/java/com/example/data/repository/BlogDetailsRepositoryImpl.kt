package com.example.data.repository

import com.example.common.util.Result
import com.example.data.mapper.toDomain
import com.example.data.network.service.ApiClient
import com.example.data.network.service.SimpleResponse
import com.example.domain.model.Blogs
import com.example.domain.repository.BlogDetailsRepository
import com.example.domain.repository.LocalError

class BlogDetailsRepositoryImpl(
    private val apiClient: ApiClient,
    private val localError: LocalError,
) : BlogDetailsRepository {

    override suspend fun getBlogDetails(blogId: String): Result<Blogs.Blog> {

        return when (val response = apiClient.getBlogDetails(blogId)) {

            is SimpleResponse.Success -> {
                val blogDetails: Blogs.Blog = response.data.toDomain()
                Result.Success(blogDetails)
            }

            is SimpleResponse.Failure -> {
                val throwable = response.throwable
                val errorEntity = localError.mapThrowableToErrorEntity(throwable)
                Result.Error(errorEntity)
            }

        }

    }

}
