package com.example.data.network.di

import com.example.data.network.service.ApiClient
import com.example.data.repository.BlogDetailsRepositoryImpl
import com.example.domain.repository.BlogDetailsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object BlogDetailsRepositoryModule {

    @Provides
    fun providesBlogDetailsRepository(apiClient: ApiClient): BlogDetailsRepository =
        BlogDetailsRepositoryImpl(apiClient)

}