package com.nar.bimito.remote.adapter

import com.nar.bimito.remote.response.RestResponse
import com.google.gson.Gson
import retrofit2.Response
import java.net.HttpURLConnection

class CompletableCallAdapter(private val apiCall: suspend () -> Response<RestResponse<Nothing>>) :
    CallAdapter<Unit> {
    override suspend fun execute() {
        val execute = apiCall.invoke()
        if (!execute.isSuccessful) {

            if (execute.code() == HttpURLConnection.HTTP_FORBIDDEN) {
                throw AuthorizationException()
            }

            val json = execute.errorBody()?.string()
            val response = Gson().fromJson(json, RestResponse::class.java)
            // TODO : complete with network message
            throw NetworkException(null)
        }
    }
}