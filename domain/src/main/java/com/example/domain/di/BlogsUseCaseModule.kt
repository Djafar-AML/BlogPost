package com.example.domain.di

import com.example.domain.repository.BlogsRepository
import com.example.domain.use_cases.GetBlogsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object BlogsUseCaseModule {

    @Provides
    fun providesBlogsUseCase(getBlogsRepository: BlogsRepository): GetBlogsUseCase =
        GetBlogsUseCase(getBlogsRepository)

}