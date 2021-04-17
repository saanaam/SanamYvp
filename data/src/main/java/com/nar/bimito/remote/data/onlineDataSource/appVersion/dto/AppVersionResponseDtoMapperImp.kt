package com.nar.bimito.remote.data.onlineDataSource.appVersion.dto

import com.nar.bimito.domain.usecase.appVersion.model.AppVersionResponse
import javax.inject.Inject

class AppVersionResponseDtoMapperImp @Inject() constructor() : AppVersionResponseDtoMapper {
    override fun mapToData(dto: AppVersionResponseDto?): AppVersionResponse {
        return AppVersionResponse(dto?.id , dto?.androidAppVersion,
        dto?.iOSAppVersion, dto?.LaunchDate)
    }

}