package com.example.data.network.di

import com.example.data.network.exception.LocalExceptionImpl
import com.example.domain.exception.LocalException
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object LocalErrorModule {

    @Provides
    fun providesLocalError(): LocalException = LocalExceptionImpl()
}