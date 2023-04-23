package com.example.domain.use_cases

import com.example.common.util.Resource
import com.example.domain.model.Blogs
import com.example.domain.repository.BlogDetailsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BlogDetailsUseCase(private val blogDetailsRepo: BlogDetailsRepository) {

    operator fun invoke(blogId: String): Flow<Resource<Blogs.Blog>> = flow {

        emit(Resource.Loading(null))

        try {

            val blogDetails = blogDetailsRepo.getBlogDetails(blogId)
            emit(Resource.Success(blogDetails))

        } catch (e: Exception) {
            emit(Resource.Error(e.message))
        }

    }

}