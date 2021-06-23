package com.sanam.database.dto.mapper

import com.sanam.database.dto.MusicModelDto
import com.sanam.database.dto.mapper.MusicModelDtoMapperI
import com.sanam.yavarpour.domain.usecase.appVersion.model.MusicModel
import javax.inject.Inject

class MusicModelDtoMapper @Inject constructor() : MusicModelDtoMapperI {
    override fun mapToData(dto: ArrayList<MusicModelDto>?): ArrayList<MusicModel> {
        val array = ArrayList<MusicModel>()
        for (item in dto!!) {
            array.add(MusicModel(item.id))
        }
        return array
    }


}