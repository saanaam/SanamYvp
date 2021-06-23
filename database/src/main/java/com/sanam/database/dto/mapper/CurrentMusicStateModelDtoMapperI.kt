package com.sanam.database.dto.mapper

import com.sanam.database.dto.CurrentMusicStateModelDto
import com.sanam.yavarpour.DtoMapper
import com.sanam.yavarpour.domain.usecase.appVersion.model.CurrentMusicStateModel
import org.mapstruct.Mapper

@Mapper
interface CurrentMusicStateModelDtoMapperI :
    DtoMapper<CurrentMusicStateModel, CurrentMusicStateModelDto>