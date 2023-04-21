package com.example.domain.use_cases

import com.example.common.util.Resource
import com.example.domain.model.Blogs
import com.example.domain.repository.BlogsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetBlogsUseCase(private val getBlogsRepository: BlogsRepository) {

    suspend operator fun invoke(): Flow<Resource<List<Blogs.Blog>>> = flow {

        emit(Resource.Loading(null))

        try {

            val response = getBlogsRepository.getBlogs()

            emit(Resource.Success(data = response))

        } catch (e: Exception) {
            emit(Resource.Error(e.message))
        }

    }

}