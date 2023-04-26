package com.example.data.network.service

import com.example.data.network.model.BlogsDTO
import retrofit2.HttpException
import retrofit2.Response
import javax.inject.Inject

class ApiClient @Inject constructor(
    private val blogPostAppApi: BlogPostAppApi,
) {

    suspend fun getBlogs(): SimpleResponse<BlogsDTO> {
        return safeApiCall { blogPostAppApi.getBlogs() }
    }

    suspend fun getBlogDetails(blogId: String): SimpleResponse<BlogsDTO.BlogDTO> {
        return safeApiCall { blogPostAppApi.getBlogDetails(blogId) }
    }

    private inline fun <T> safeApiCall(apiCall: () -> Response<T>): SimpleResponse<T> {


        return try {

            val response = apiCall.invoke()

            if (response.isSuccessful) {
                SimpleResponse.Success(response.body()!!)
            } else {
                SimpleResponse.Failure(HttpException(response))
            }

        } catch (throwable: Throwable) {
            SimpleResponse.Failure(throwable)
        }

    }

}