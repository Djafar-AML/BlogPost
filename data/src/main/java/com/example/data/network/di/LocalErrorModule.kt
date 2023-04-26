package com.example.data.network.di

import com.example.data.repository.LocalErrorImpl
import com.example.domain.repository.LocalError
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object LocalErrorModule {

    @Provides
    fun providesLocalError(): LocalError = LocalErrorImpl()
}