package com.example.data.network.service

import com.example.common.constants.APP_ID
import com.example.data.network.model.BlogsDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Path

interface BlogPostAppApi {

    @Headers("app-id: $APP_ID")
    @GET("post")
    suspend fun getBlogs(): Response<BlogsDTO>

    @GET("post/{id}")
    @Headers("app-id: $APP_ID")
    suspend fun getBlogDetails(
        @Path("id") id: String
    ): Response<BlogsDTO.BlogDTO>

}