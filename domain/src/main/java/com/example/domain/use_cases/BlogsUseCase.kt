package com.example.domain.use_cases

import com.example.common.util.Resource
import com.example.common.util.Result.Error
import com.example.common.util.Result.Success
import com.example.domain.model.Blogs
import com.example.domain.repository.BlogsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BlogsUseCase(
    private val getBlogsRepository: BlogsRepository,
) {

    operator fun invoke(): Flow<Resource<List<Blogs.Blog>>> = flow {

        emit(Resource.Loading())

        when (val response = getBlogsRepository.getBlogs()) {

            is Success -> {
                emit(Resource.Success(response.data))
            }

            is Error -> {
                emit(Resource.Error(response.errorEntity))
            }

        }

    }

}