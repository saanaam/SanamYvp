package com.sanam.yavarpour.presentation.splash.main.model

import com.sanam.yavarpour.common.PresentationMapper
import com.sanam.yavarpour.domain.usecase.appVersion.model.MusicModel
import org.mapstruct.Mapper

@Mapper
interface musicListPresentationMapper : PresentationMapper<MusicModel,MusicItemModel>