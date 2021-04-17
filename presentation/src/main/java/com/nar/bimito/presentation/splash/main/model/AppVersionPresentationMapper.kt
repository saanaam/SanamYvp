package com.nar.bimito.presentation.splash.main.model

import com.nar.bimito.common.PresentationMapper
import com.nar.bimito.domain.usecase.appVersion.model.AppVersionResponse
import org.mapstruct.Mapper

@Mapper
interface AppVersionPresentationMapper : PresentationMapper<AppVersionResponse,AppVersionModel>