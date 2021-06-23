package com.sanam.yavarpour.local.localDataSource

import com.sanam.yavarpour.DataSource
import com.sanam.yavarpour.domain.usecase.appVersion.model.CurrentMusicStateModel
import com.sanam.yavarpour.domain.usecase.appVersion.model.MusicModel
import com.sanam.yavarpour.domain.usecase.appVersion.model.PlayingMusicModel

interface GetUserMusicListDataSource : DataSource {
    suspend fun getMusicList(): ArrayList<MusicModel>
    suspend fun updatePlayingMusic(currentMusicId: Int ): PlayingMusicModel
    suspend fun updateMusicState(item: CurrentMusicStateModel)
    suspend fun getLatestMusicStateModel(): CurrentMusicStateModel
    suspend fun getPlayingMusic(): PlayingMusicModel

}