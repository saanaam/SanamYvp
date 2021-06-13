package com.sanam.yavarpour.domain.usecase.appVersion.repository

import com.sanam.yavarpour.domain.Repository
import com.sanam.yavarpour.domain.usecase.appVersion.model.MusicListResponse

interface MusicListRepository : Repository{
    suspend fun getMusicList(): ArrayList<MusicListResponse>
}