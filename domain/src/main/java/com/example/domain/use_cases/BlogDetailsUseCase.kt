package com.example.domain.use_cases

import com.example.common.util.Resource
import com.example.common.util.Result
import com.example.domain.model.Blogs
import com.example.domain.repository.BlogDetailsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BlogDetailsUseCase(
    private val blogDetailsRepo: BlogDetailsRepository,
) {

    operator fun invoke(blogId: String): Flow<Resource<Blogs.Blog>> = flow {

        emit(Resource.Loading())

        when (val blogDetails = blogDetailsRepo.getBlogDetails(blogId)) {

            is Result.Success -> {
                emit(Resource.Success(blogDetails.data))
            }

            is Result.Error -> {
                emit(Resource.Error(blogDetails.errorEntity))
            }

        }

    }

}