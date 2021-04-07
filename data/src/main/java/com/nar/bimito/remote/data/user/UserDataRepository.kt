package com.nar.bimito.remote.data.user

import com.nar.bimito.remote.data.user.UserLocalTokenDataSource
import com.nar.bimito.remote.data.user.UserOnlineDataSource
import com.nar.bimito.domain.user.UserRepository
import com.nar.bimito.domain.user.auth.AuthenticationRequest
import javax.inject.Inject

class UserDataRepository @Inject constructor(
    private val tokenDataSource: UserLocalTokenDataSource,
    private val userOnlineDataSource: UserOnlineDataSource
) : UserRepository {
    override suspend fun login(request: AuthenticationRequest): String {
        val token = userOnlineDataSource.login(request)
        tokenDataSource.saveToken(token)
        return token
    }
}