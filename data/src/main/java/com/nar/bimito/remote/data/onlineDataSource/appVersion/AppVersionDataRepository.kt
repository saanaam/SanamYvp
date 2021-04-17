package com.nar.bimito.remote.data.onlineDataSource.appVersion

import com.nar.bimito.domain.usecase.appVersion.model.AppVersionResponse
import com.nar.bimito.domain.usecase.appVersion.repository.AppVersionRepository
import javax.inject.Inject

class AppVersionDataRepository @Inject constructor(
    private val appVersionOnlineDataSource: AppVersionOnlineDataSource
) : AppVersionRepository {

    override suspend fun appVersion(): AppVersionResponse =
        appVersionOnlineDataSource.appVersion()

}