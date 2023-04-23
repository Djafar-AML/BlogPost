package com.example.domain.di

import com.example.domain.repository.BlogDetailsRepository
import com.example.domain.use_cases.BlogDetailsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object BlogDetailsUseModule {

    @Provides
    fun providesBlogDetailsUseCase(blogIDetailsRepo: BlogDetailsRepository): BlogDetailsUseCase =
        BlogDetailsUseCase(blogIDetailsRepo)
}