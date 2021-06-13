package com.sanam.yavarpour.remote.data.onlineDataSource.musicList

import com.sanam.yavarpour.domain.usecase.appVersion.model.MusicListResponse
import com.sanam.yavarpour.domain.usecase.appVersion.repository.MusicListRepository
import javax.inject.Inject

class MusicListDataRepository @Inject constructor(
    private val appVersionOnlineDataSource: AppVersionOnlineDataSource
) : MusicListRepository {

    override suspend fun getMusicList(): ArrayList<MusicListResponse> =
        appVersionOnlineDataSource.getMusicList()

}