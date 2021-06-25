package com.sanam.database.dataSource

import com.sanam.database.dto.MusicModelDto
import com.sanam.database.dto.mapper.CurrentMusicStateModelDtoMapper
import com.sanam.database.dto.mapper.MusicModelDtoMapper
import com.sanam.database.dto.mapper.PlayingMusicModelDtoMapper
import com.sanam.database.preference.MusicListMockData
import com.sanam.database.preference.MusicListSharedPreference
import com.sanam.yavarpour.domain.usecase.musicPlayer.model.CurrentMusicStateModel
import com.sanam.yavarpour.domain.usecase.musicPlayer.model.MusicModel
import com.sanam.yavarpour.domain.usecase.musicPlayer.model.PlayingMusicModel
import com.sanam.yavarpour.local.localDataSource.MusicListControllerDataSource
import javax.inject.Inject

class MusicListControllerLocalDataSource @Inject constructor(
    private val musicModelDtoMapper: MusicModelDtoMapper,
    private val currentMusicStateModelDtoMapper: CurrentMusicStateModelDtoMapper,
    private val playingMusicModelDtoMapper: PlayingMusicModelDtoMapper,
    private val preference: MusicListSharedPreference
) : MusicListControllerDataSource {

    override suspend fun getMusicList() =
        musicModelDtoMapper.mapToData(preference.getMusicList() as ArrayList<MusicModelDto>)

    override suspend fun setMusicList(isPremium: Boolean) {
        preference.setMusicList(isPremium)
    }

    override suspend fun updateMusicList(musicList: ArrayList<MusicModel>) {
        preference.updateMusicList(
            musicList = musicModelDtoMapper.mapToModel(musicList)
        )
    }

    override suspend fun updatePlayingMusic(currentMusicId: Int) {
        return preference.setPlayingMusic(currentMusicId)
    }

    override suspend fun updateMusicState(item: CurrentMusicStateModel) {
        preference.setCurrentMusicStateModel(
            currentMusicState = currentMusicStateModelDtoMapper.mapToData(item)
        )
    }

    override suspend fun getLatestMusicStateModel(): CurrentMusicStateModel {
        return currentMusicStateModelDtoMapper.mapToModel(
            currentMusicStateModelDto = preference.getCurrentMusicStateModel()
        )
    }

    override suspend fun getPlayingMusic() = preference.getPlayingMusic()

    override suspend fun getMusicListInfo(): ArrayList<PlayingMusicModel> {
        return playingMusicModelDtoMapper.mapToData(
            playingMusicModelDto = MusicListMockData().musicListInfo()
        )
    }

}