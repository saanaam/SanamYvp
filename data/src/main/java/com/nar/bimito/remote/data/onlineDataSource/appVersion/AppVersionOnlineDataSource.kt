package com.nar.bimito.remote.data.onlineDataSource.appVersion

import com.nar.bimito.domain.usecase.appVersion.model.AppVersionResponse
import com.nar.bimito.remote.data.RemoteDataSource

interface AppVersionOnlineDataSource : RemoteDataSource {
    suspend fun appVersion(): AppVersionResponse
}