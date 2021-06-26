package com.sanam.yavarpour.presentation.splash.main.model

import com.sanam.yavarpour.domain.usecase.musicPlayer.usecase.musicListUseCase.model.MusicModel
import javax.inject.Inject

class AppVersionPresentationMapperImp @Inject constructor() : MusicListPresentationMapper {
    override fun toPresentation(entity: MusicModel): MusicItemModel {
        return MusicItemModel(entity.id)
    }

}