package com.sanam.database.dto.mapper

import com.sanam.database.dto.MusicModelDto
import com.sanam.yavarpour.DtoMapper
import com.sanam.yavarpour.domain.usecase.appVersion.model.MusicModel
import org.mapstruct.Mapper

@Mapper
interface MusicModelDtoMapperI : DtoMapper<ArrayList<MusicModelDto>, ArrayList<MusicModel>>