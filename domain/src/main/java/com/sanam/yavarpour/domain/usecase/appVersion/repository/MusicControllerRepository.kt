package com.sanam.yavarpour.domain.usecase.appVersion.repository

import com.sanam.yavarpour.domain.Repository

interface MusicControllerRepository : Repository {
    suspend fun pausePlayingMusic(musicId : Int, pausePos : Int) : Pair<Int, Int>
    suspend fun resumeMusic(musicId : Int) : Int
    suspend fun stopMusic(musicId : Int)
    suspend fun next()
    suspend fun previous()
}