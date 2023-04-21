package com.example.data.network.service

import com.example.data.network.model.BlogsDTO
import retrofit2.Response
import javax.inject.Inject

class ApiClient @Inject constructor(
    private val blogPostAppApi: BlogPostAppApi
) {

    suspend fun getBlogs(): SimpleResponse<BlogsDTO> {
        return safeApiCall { blogPostAppApi.getBlogs() }
    }

    private inline fun <T> safeApiCall(apiCall: () -> Response<T>): SimpleResponse<T> {

        return try {
            SimpleResponse.success(apiCall.invoke())
        } catch (e: Exception) {
            SimpleResponse.failure(e)
        }
    }

}