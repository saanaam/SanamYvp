package com.nar.bimito.remote.data.user

import com.nar.bimito.remote.data.LocalDataSource

interface UserLocalTokenDataSource : LocalDataSource {
    suspend fun saveToken(token: String)
}