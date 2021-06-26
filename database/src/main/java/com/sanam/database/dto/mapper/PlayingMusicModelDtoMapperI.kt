package com.sanam.database.dto.mapper

import com.sanam.database.dto.PlayingMusicModelDto
import com.sanam.yavarpour.DtoMapper
import com.sanam.yavarpour.domain.usecase.musicPlayer.usecase.playingMusicUseCase.model.PlayingMusicModel
import org.mapstruct.Mapper

@Mapper
interface PlayingMusicModelDtoMapperI : DtoMapper<ArrayList<PlayingMusicModelDto>, ArrayList<PlayingMusicModel>>