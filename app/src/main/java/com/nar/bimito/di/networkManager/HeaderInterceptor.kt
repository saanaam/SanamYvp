package com.nar.bimito.di.networkManager

import okhttp3.OkHttpClient

interface HeaderInterceptor {
    fun buildHeaderInterceptor(): OkHttpClient
}