package com.sanam.yavarpour.local.repository

import com.sanam.yavarpour.domain.usecase.appVersion.model.CurrentMusicStateModel
import com.sanam.yavarpour.domain.usecase.appVersion.model.MusicModel
import com.sanam.yavarpour.domain.usecase.appVersion.model.PlayingMusicModel
import com.sanam.yavarpour.domain.usecase.appVersion.repository.MusicListRepository
import com.sanam.yavarpour.local.localDataSource.GetUserMusicListDataSource
import javax.inject.Inject

class MusicListDataRepository @Inject constructor(
    private val getUserMusicListDataSource: GetUserMusicListDataSource
) : MusicListRepository {
    override suspend fun getMusicList() =
        getUserMusicListDataSource.getMusicList()

    override suspend fun updatePlayingMusic(currentMusicId: Int) =
        getUserMusicListDataSource.updatePlayingMusic(currentMusicId)

    override suspend fun getPlayingMusic(): PlayingMusicModel {
        getUserMusicListDataSource.getPlayingMusic()
    }

    override suspend fun updateMusicState(item: CurrentMusicStateModel) =
        getUserMusicListDataSource.updateMusicState(item)

    override suspend fun getLatestMusicStateModel() =
        getUserMusicListDataSource.getLatestMusicStateModel()

    override suspend fun nextMusic(isPremium: Boolean, currentMusicId: Int): PlayingMusicModel {
        if (isPremium) {
            //TODO go to next song
            getMusicList()
        } else {
            //TODO return Error
        }
    }

    override suspend fun previousMusic(isPremium: Boolean, currentMusicId: Int): PlayingMusicModel {
        if (isPremium) {
            //TODO go to next song and update current playing song
            getMusicList()
        } else {
            //TODO return Error
        }
    }

    override suspend fun addMusicToQue(musicId: Int) {
        //TODO find the playing music indext into list and add it to que
        getPlayingMusic()
        getMusicList()
    }


}