package com.sanam.yavarpour.remote.data.onlineDataSource.musicList.dto

import com.sanam.yavarpour.domain.usecase.appVersion.model.MusicListResponse
import javax.inject.Inject

class MusicListResponseDtoMapperImp @Inject() constructor() : MusicListResponseDtoMapper {
    override fun mapToData(dto: MusicListResponseDto?): MusicListResponse {
        return MusicListResponse(dto?.id , dto?.file)
    }

}