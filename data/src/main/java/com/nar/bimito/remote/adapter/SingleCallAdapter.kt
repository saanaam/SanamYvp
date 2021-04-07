package com.nar.bimito.remote.adapter

import com.azki.bimito.domain.exception
import com.nar.bimito.remote.response.ResponseWrapper
import com.nar.bimito.remote.response.RestResponse
import com.google.gson.Gson
import retrofit2.Response
import java.net.HttpURLConnection

class SingleCallAdapter<T>(private val apiCall: suspend () -> Response<RestResponse<T>>) :
    CallAdapter<ResponseWrapper<T>> {
    private var response: RestResponse<T>? = null
    override suspend fun execute(): ResponseWrapper<T> {
        try {
            val execute = apiCall.invoke()
            if (execute.isSuccessful) {
                response = execute.body()
                response?.let {
                    return ResponseWrapper.Success(it.data)
                }
                return ResponseWrapper.Complete()
            } else {
                if (execute.code() == HttpURLConnection.HTTP_FORBIDDEN) {
                    throw AuthorizationException()
                }

                val json = execute.errorBody()?.string()
                val response = Gson().fromJson(json, RestResponse::class.java)
                // TODO : complete with network message
                throw NetworkException(null)
            }

        } catch (exception: Exception) {
            return ResponseWrapper.Error(exception)
        }
    }
}