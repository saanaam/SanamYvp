package com.sanam.yavarpour.local.localDataSource

import com.sanam.yavarpour.DataSource
import com.sanam.yavarpour.domain.usecase.appVersion.model.MusicModel

interface GetUserMusicListDataSource : DataSource {
    suspend fun getMusicList(isPremium : Boolean): ArrayList<MusicModel>
}