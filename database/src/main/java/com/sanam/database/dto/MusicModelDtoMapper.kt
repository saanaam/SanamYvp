package com.sanam.database.dto

import com.sanam.yavarpour.domain.usecase.appVersion.model.MusicModel
import javax.inject.Inject

class MusicModelDtoMapper @Inject constructor(): MusicModelDtoMapperI {

    override fun mapToData(dto: ArrayList<MusicModelDto>?): ArrayList<MusicModel> {
        TODO("Not yet implemented")
    }
}