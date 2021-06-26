package com.sanam.database.dto.mapper

import com.sanam.database.dto.PlayingMusicModelDto
import com.sanam.yavarpour.domain.usecase.musicPlayer.usecase.playingMusicUseCase.model.PlayingMusicModel
import javax.inject.Inject

class PlayingMusicModelDtoMapper @Inject constructor(): PlayingMusicModelDtoMapperI {
    override fun mapToData(playingMusicModelDto: ArrayList<PlayingMusicModelDto>?): ArrayList<PlayingMusicModel> {
        var list = ArrayList<PlayingMusicModel>()
        for (item in playingMusicModelDto!!) {
            list = ArrayList<PlayingMusicModel>().apply {
                add(
                    PlayingMusicModel(
                        item.id,
                        item.songName,
                        item.artist,
                        item.duration,
                    )
                )
            }
        }
        return list
    }


}