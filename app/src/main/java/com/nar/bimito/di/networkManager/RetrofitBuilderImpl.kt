package com.nar.bimito.di.networkManager

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Inject

class RetrofitBuilderImpl @Inject constructor(private val headerInterceptor:HeaderInterceptor) {
    fun makeRetrofitService(url: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(url)
            .client(headerInterceptor.buildHeaderInterceptor())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
}