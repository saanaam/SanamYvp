package com.nar.bimito.remote.data.onlineDataSource.appVersion

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface AppVersionEndpoint {

    @POST("{path}")
    suspend fun appVersion(@Path(value = "path", encoded = true) path :String)


}