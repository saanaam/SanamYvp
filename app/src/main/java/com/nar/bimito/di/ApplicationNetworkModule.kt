package com.nar.bimito.di

import androidx.multidex.BuildConfig
import com.nar.bimito.di.networkManager.HeaderInterceptor
import com.nar.bimito.di.networkManager.RetrofitBuilderImpl
import com.nar.bimito.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationNetworkModule {

    @Provides
    @Singleton
    fun provideRetrofitService(headerInterceptor: HeaderInterceptor): Retrofit {
        return if (BuildConfig.DEBUG) {
            RetrofitBuilderImpl(headerInterceptor).makeRetrofitService(Constants.DEBUG_BASE_URL)
        } else {
            RetrofitBuilderImpl(headerInterceptor).makeRetrofitService(Constants.BASE_URL)
        }
    }

}