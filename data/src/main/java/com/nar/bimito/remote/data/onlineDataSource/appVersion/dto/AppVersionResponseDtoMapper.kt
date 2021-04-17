package com.nar.bimito.remote.data.onlineDataSource.appVersion.dto

import com.nar.bimito.domain.usecase.appVersion.model.AppVersionResponse
import com.nar.bimito.remote.DtoMapper
import org.mapstruct.Mapper
import javax.inject.Inject

@Mapper
interface AppVersionResponseDtoMapper : DtoMapper<AppVersionResponseDto,AppVersionResponse >