package com.sanam.yavarpour.presentation.splash.main.model

import com.sanam.yavarpour.domain.usecase.appVersion.model.MusicListResponse
import javax.inject.Inject

class AppVersionPresentationMapperImp @Inject constructor() :AppVersionPresentationMapper{

    override fun toPresentation(entity: MusicListResponse): MusicListModel {
        return MusicListModel(entity.id , entity.title,
            entity.Singer, entity.time)
    }

}