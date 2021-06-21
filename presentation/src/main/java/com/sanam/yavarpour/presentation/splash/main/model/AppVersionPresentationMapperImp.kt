package com.sanam.yavarpour.presentation.splash.main.model

import com.sanam.yavarpour.domain.usecase.appVersion.model.MusicModel
import javax.inject.Inject

class AppVersionPresentationMapperImp @Inject constructor() :musicListPresentationMapper{
    override fun toPresentation(entity: MusicModel): MusicItemModel {
        return MusicItemModel(entity.id , entity.file)
    }

}