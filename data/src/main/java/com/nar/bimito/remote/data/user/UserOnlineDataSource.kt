package com.nar.bimito.remote.data.user

import com.nar.bimito.remote.data.RemoteDataSource
import com.nar.bimito.domain.user.auth.AuthenticationRequest

interface UserOnlineDataSource : RemoteDataSource {
    suspend fun login(authenticationRequest: AuthenticationRequest): String
}