package com.example.data.repository

import com.example.common.util.Result
import com.example.data.mapper.toDomain
import com.example.data.network.model.BlogsDTO
import com.example.data.network.service.ApiClient
import com.example.data.network.service.SimpleResponse
import com.example.domain.model.Blogs
import com.example.domain.repository.BlogsRepository
import com.example.domain.repository.LocalError

class BlogsRepositoryImpl(
    private val apiClient: ApiClient,
    private val localError: LocalError
) : BlogsRepository {

    override suspend fun getBlogs(): Result<List<Blogs.Blog>> {

        return when (val response: SimpleResponse<BlogsDTO> = apiClient.getBlogs()) {

            is SimpleResponse.Success -> {
                val blogList = response.data.blogDTOList.toDomain()
                Result.Success(blogList)
            }

            is SimpleResponse.Failure -> {
                val throwable = response.throwable
                val errorEntity = localError.mapThrowableToErrorEntity(throwable)
                Result.Error(errorEntity)
            }
        }

    }

}