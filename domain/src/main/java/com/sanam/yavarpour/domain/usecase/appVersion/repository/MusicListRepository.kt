package com.sanam.yavarpour.domain.usecase.appVersion.repository

import com.sanam.yavarpour.domain.Repository
import com.sanam.yavarpour.domain.usecase.appVersion.model.MusicModel

interface MusicListRepository : Repository{
    suspend fun getMusicList(isPremium : Boolean): ArrayList<MusicModel>
}