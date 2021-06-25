package com.sanam.yavarpour.local.localDataSource

import com.sanam.yavarpour.DataSource
import com.sanam.yavarpour.domain.usecase.musicPlayer.model.CurrentMusicStateModel
import com.sanam.yavarpour.domain.usecase.musicPlayer.model.MusicModel
import com.sanam.yavarpour.domain.usecase.musicPlayer.model.PlayingMusicModel

interface MusicListControllerDataSource : DataSource {
    suspend fun getMusicList(): ArrayList<MusicModel>
    suspend fun setMusicList(isPremium : Boolean)
    suspend fun updateMusicList(musicList : ArrayList<MusicModel>)
    suspend fun updatePlayingMusic(currentMusicId: Int )
    suspend fun updateMusicState(item: CurrentMusicStateModel)
    suspend fun getLatestMusicStateModel(): CurrentMusicStateModel
    suspend fun getPlayingMusic(): Int
    suspend fun getMusicListInfo(): ArrayList<PlayingMusicModel>


}