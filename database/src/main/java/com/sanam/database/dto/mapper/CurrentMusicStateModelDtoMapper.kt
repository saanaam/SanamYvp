package com.sanam.database.dto.mapper

import com.sanam.database.dto.CurrentMusicStateModelDto
import com.sanam.yavarpour.domain.usecase.appVersion.model.CurrentMusicStateModel

class CurrentMusicStateModelDtoMapper : CurrentMusicStateModelDtoMapperI {
    override fun mapToData(dto: CurrentMusicStateModel?) =
        CurrentMusicStateModelDto(
            dto!!.id,
            dto.songTime,
            dto.status
        )

    fun mapToModel(currentMusicStateModelDto: CurrentMusicStateModelDto) =
        CurrentMusicStateModel(
            currentMusicStateModelDto!!.id,
            currentMusicStateModelDto.songTime,
            currentMusicStateModelDto.status
        )
}