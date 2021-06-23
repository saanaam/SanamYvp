package com.sanam.database.dataSource

import com.sanam.database.dto.MusicModelDto
import com.sanam.database.dto.mapper.CurrentMusicStateModelDtoMapper
import com.sanam.database.dto.mapper.MusicModelDtoMapper
import com.sanam.database.dto.mapper.PlayingMusicModelDtoMapper
import com.sanam.database.preference.MusicListSharedPreference
import com.sanam.yavarpour.domain.usecase.appVersion.model.CurrentMusicStateModel
import com.sanam.yavarpour.domain.usecase.appVersion.model.MusicModel
import com.sanam.yavarpour.domain.usecase.appVersion.model.PlayingMusicModel
import com.sanam.yavarpour.local.localDataSource.GetUserMusicListDataSource
import javax.inject.Inject

class GetUserMusicListLocalDataSource @Inject constructor(
    private val musicModelDtoMapper: MusicModelDtoMapper,
    private val currentMusicStateModelDtoMapper: CurrentMusicStateModelDtoMapper,
    private val playingMusicModelDtoMapper: PlayingMusicModelDtoMapper,
    private val preference: MusicListSharedPreference
) : GetUserMusicListDataSource {

    override suspend fun getMusicList(): ArrayList<MusicModel> {
        val list = preference.getMusicList()
        return musicModelDtoMapper.mapToData(list as ArrayList<MusicModelDto>)
    }

    override suspend fun updatePlayingMusic(currentMusicId: Int): PlayingMusicModel {
        preference.setPlayingMusic(currentMusicId)
        return playingMusicModelDtoMapper.mapToData(preference.getPlayingMusic())
    }

    override suspend fun updateMusicState(item: CurrentMusicStateModel) {
        preference.setCurrentMusicStateModel(
            currentMusicStateModelDtoMapper.mapToData(item)
        )
    }

    override suspend fun getLatestMusicStateModel(): CurrentMusicStateModel {
        return currentMusicStateModelDtoMapper.mapToModel(preference.getCurrentMusicStateModel())
    }

    override suspend fun getPlayingMusic() =
        playingMusicModelDtoMapper.mapToData(preference.getPlayingMusic())

}