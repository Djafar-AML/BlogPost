package com.example.data.network.di

import com.example.data.network.service.ApiClient
import com.example.data.repository.BlogsRepositoryImpl
import com.example.domain.repository.BlogsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object BlogsRepositoryModule {

    @Provides
    fun providesBlogsRepository(apiClient: ApiClient): BlogsRepository =
        BlogsRepositoryImpl(apiClient)
}