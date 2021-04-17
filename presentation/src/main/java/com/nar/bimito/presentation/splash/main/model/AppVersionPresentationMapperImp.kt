package com.nar.bimito.presentation.splash.main.model

import com.nar.bimito.domain.usecase.appVersion.model.AppVersionResponse
import javax.inject.Inject

class AppVersionPresentationMapperImp @Inject constructor() :AppVersionPresentationMapper{

    override fun toPresentation(entity: AppVersionResponse): AppVersionModel {
        return AppVersionModel(entity.id , entity.androidAppVersion,
            entity.iOSAppVersion, entity.LaunchDate)
    }

}