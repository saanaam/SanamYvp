package com.sanam.yavarpour.presentation.splash.main.model

import com.sanam.yavarpour.common.PresentationMapper
import com.sanam.yavarpour.domain.usecase.musicPlayer.model.MusicModel
import org.mapstruct.Mapper

@Mapper
interface MusicListPresentationMapper : PresentationMapper<MusicModel,MusicItemModel>