package com.sanam.yavarpour.presentation.splash.main.model

import com.sanam.yavarpour.domain.usecase.appVersion.model.MusicListResponse
import javax.inject.Inject

class AppVersionPresentationMapperImp @Inject constructor() :musicListPresentationMapper{

    override fun toPresentation(entity: MusicListResponse): MusicItemModel {
        return MusicItemModel(entity.id , entity.file)
    }

}