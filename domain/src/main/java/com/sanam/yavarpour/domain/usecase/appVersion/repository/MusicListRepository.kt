package com.sanam.yavarpour.domain.usecase.appVersion.repository

import com.sanam.yavarpour.domain.Repository
import com.sanam.yavarpour.domain.usecase.appVersion.model.CurrentMusicStateModel
import com.sanam.yavarpour.domain.usecase.appVersion.model.MusicModel
import com.sanam.yavarpour.domain.usecase.appVersion.model.PlayingMusicModel

interface MusicListRepository : Repository {
    suspend fun getMusicList(): ArrayList<MusicModel>
    suspend fun updatePlayingMusic(currentMusicId: Int): PlayingMusicModel
    suspend fun getPlayingMusic(): PlayingMusicModel
    suspend fun nextMusic(isPremium: Boolean, currentMusicId: Int): PlayingMusicModel
    suspend fun previousMusic(isPremium: Boolean, currentMusicId: Int): PlayingMusicModel
    suspend fun updateMusicState(item: CurrentMusicStateModel)
    suspend fun getLatestMusicStateModel(): CurrentMusicStateModel
    suspend fun addMusicToQue(musicId: Int)

}