package com.nar.bimito.di

import com.nar.bimito.di.networkManager.HeaderInterceptor
import com.nar.bimito.di.networkManager.HeaderInterceptorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ApplicationHeaderModule {
    @Binds
    @Singleton
    abstract fun provideHeaderInterceptor(
        headerInterceptor: HeaderInterceptorImpl
    ): HeaderInterceptor
}