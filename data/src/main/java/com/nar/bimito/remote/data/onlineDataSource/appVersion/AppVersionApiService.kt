package com.nar.bimito.remote.data.onlineDataSource.appVersion

import com.nar.bimito.domain.usecase.appVersion.model.AppVersionResponse
import com.nar.bimito.remote.AbstractApiService
import com.nar.bimito.remote.data.onlineDataSource.appVersion.dto.AppVersionResponseDtoMapper
import javax.inject.Inject

class AppVersionApiService @Inject constructor(
    private val appVersionResponseDtoMapper: AppVersionResponseDtoMapper
) : AbstractApiService<AppVersionEndpoint>(AppVersionEndpoint::class.java),
    AppVersionOnlineDataSource {
    override suspend fun appVersion(): AppVersionResponse {
        val result = executionWithResponse {
            apiService.appVersion("app/user/getAppVersion")
        }
        return appVersionResponseDtoMapper.mapToData(result.data)
    }

}