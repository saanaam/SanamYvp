package com.sanam.yavarpour.presentation.splash.main.model

import com.sanam.yavarpour.common.PresentationMapper
import com.sanam.yavarpour.domain.usecase.appVersion.model.MusicListResponse
import org.mapstruct.Mapper

@Mapper
interface musicListPresentationMapper : PresentationMapper<MusicListResponse,MusicItemModel>