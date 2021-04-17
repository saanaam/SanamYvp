package com.nar.bimito.di.networkManager

import android.content.Context
import android.content.Intent
import android.util.Log
import com.nar.bimito.di.accountManager.AccountManager
import com.nar.bimito.utils.Constants
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class HeaderInterceptorImpl @Inject constructor(
    private val accountManager: AccountManager,
    @ApplicationContext private val context: Context
) : HeaderInterceptor {
    override fun buildHeaderInterceptor(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.connectTimeout(Constants.CONNECT_TIME_OUT, TimeUnit.SECONDS)
        httpClient.readTimeout(Constants.READ_TIME_OUT, TimeUnit.SECONDS)
        httpClient.writeTimeout(Constants.WRITE_TIME_OUT, TimeUnit.SECONDS)
        httpClient.addInterceptor { chain: Interceptor.Chain ->
            val requestBuilder = chain.request().newBuilder()
                .addHeader(
                    "Authorization",
                    "Bearer ${accountManager.getAccount(context).token}"
                )
            val request = requestBuilder.build()
            Log.e(Constants.API_TAG, "buildHeaderInterceptor: status code: $request")
            val response = chain.proceed(request)
            Log.e(Constants.API_TAG, "buildHeaderInterceptor: status code: $response")
            if (response.code == 401 || response.code == 403) {
                if (!request.url.toString().contains("auth")) {
//                    val intent = Intent(context, AuthActivity::class.java)
//                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
//                    context.startActivity(intent)
//                    Runtime.getRuntime().exit(0)
                }
            }
            response
        }
        return httpClient.build()
    }
}