package com.sanam.yavarpour.remote.data.onlineDataSource.musicList

import com.sanam.yavarpour.domain.usecase.appVersion.model.MusicListResponse
import com.sanam.yavarpour.remote.data.RemoteDataSource

interface AppVersionOnlineDataSource : RemoteDataSource {
    suspend fun  getMusicList(): ArrayList<MusicListResponse>
}