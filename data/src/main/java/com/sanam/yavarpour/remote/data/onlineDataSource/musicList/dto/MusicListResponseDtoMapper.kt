package com.sanam.yavarpour.remote.data.onlineDataSource.musicList.dto

import com.sanam.yavarpour.domain.usecase.appVersion.model.MusicListResponse
import com.sanam.yavarpour.remote.DtoMapper
import org.mapstruct.Mapper

@Mapper
interface MusicListResponseDtoMapper : DtoMapper<MusicListResponseDto,MusicListResponse >