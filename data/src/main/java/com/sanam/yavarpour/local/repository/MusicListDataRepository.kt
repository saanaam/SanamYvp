package com.sanam.yavarpour.local.repository

import com.sanam.yavarpour.domain.usecase.appVersion.model.MusicModel
import com.sanam.yavarpour.domain.usecase.appVersion.repository.MusicListRepository
import com.sanam.yavarpour.local.localDataSource.GetUserMusicListDataSource
import javax.inject.Inject

class MusicListDataRepository @Inject constructor(
    private val appVersionOnlineDataSource: GetUserMusicListDataSource
) : MusicListRepository {
    override suspend fun getMusicList(isPremium: Boolean): ArrayList<MusicModel> =
        appVersionOnlineDataSource.getMusicList(isPremium)

}