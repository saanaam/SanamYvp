package com.nar.bimito.remote

import com.nar.bimito.remote.adapter.CompletableCallAdapter
import com.nar.bimito.remote.adapter.SingleCallAdapter
import com.nar.bimito.remote.response.ResponseWrapper
import com.nar.bimito.remote.response.RestResponse
import com.nar.bimito.remote.response.Result
import retrofit2.Response
import retrofit2.Retrofit
import javax.annotation.Nonnull
import javax.inject.Inject
import kotlin.reflect.KProperty

abstract class AbstractApiService<S> constructor(private val serviceClass: Class<S>) :
    API<S> {


    @Inject
    lateinit var retrofit: Retrofit

    override val apiService: S by lazy {
        create()
    }

    protected suspend fun <T> executionWithResponse(apiCall: suspend () -> Response<RestResponse<T>>): Result<T> {
        return when (val adapter = SingleCallAdapter(apiCall).execute()) {
            is ResponseWrapper.Success -> Result(
                adapter.data
            )
            is ResponseWrapper.Error -> throw  adapter.exception
            is ResponseWrapper.Complete -> Result()
            else -> throw IllegalStateException()
        }
    }

    protected suspend fun execution(apiCall: suspend () -> Response<RestResponse<Nothing>>) {
        CompletableCallAdapter(apiCall).execute()
    }

    @Nonnull
    private fun create(): S {
        return retrofit.create(serviceClass)
    }

    private operator fun <T> Lazy<T>.setValue(
        apiService: AbstractApiService<T>,
        property: KProperty<*>,
        t: T
    ) {
    }
}