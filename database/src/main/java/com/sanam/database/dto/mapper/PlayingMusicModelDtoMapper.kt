package com.sanam.database.dto.mapper

import com.sanam.database.dto.PlayingMusicModelDto
import com.sanam.yavarpour.domain.usecase.appVersion.model.PlayingMusicModel

class PlayingMusicModelDtoMapper : PlayingMusicModelDtoMapperI {
    override fun mapToData(dto: PlayingMusicModelDto?) =
        PlayingMusicModel(
            dto!!.id,
            dto.songName,
            dto.artist,
            dto.popularity,
            dto.constructorYear,
            dto.duration,
        )
}