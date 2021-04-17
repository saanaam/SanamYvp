package com.nar.bimito.remote.adapter

import com.nar.bimito.remote.response.RestResponse
import com.google.gson.Gson
import com.nar.bimito.domain.exception.AuthorizationException
import com.nar.bimito.domain.exception.NetworkException
import com.nar.bimito.remote.response.ResponseWrapper
import retrofit2.Response
import java.net.HttpURLConnection

class CompletableCallAdapter(private val apiCall: suspend () -> Response<RestResponse<Nothing>>) :
    CallAdapter<Unit> {
    private var response: RestResponse<Nothing>? = null
    override suspend fun execute() {
        val execute = apiCall.invoke()
        if (execute.isSuccessful) {
            response = execute.body()
            response?.let {
                it.messageCode?.let { messageCode ->
                    when (messageCode) {
                        200 -> ResponseWrapper.Complete()
                        else -> ResponseWrapper.Error(
                            NetworkException(
                                it.message,
                                it.messageCode.toString()
                            ))
                    }
                }
            }

        } else {
            if (execute.code() == HttpURLConnection.HTTP_FORBIDDEN) {
                throw AuthorizationException()
            }
            val json = execute.errorBody()?.string()
            val response = Gson().fromJson(json, RestResponse::class.java)
            throw NetworkException(response.message, response.messageCode.toString())
        }
    }
}