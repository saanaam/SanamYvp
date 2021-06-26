package com.sanam.yavarpour.domain.usecase.musicPlayer.repository

import com.sanam.yavarpour.domain.Repository
import com.sanam.yavarpour.domain.usecase.musicPlayer.model.CurrentMusicStateModel
import com.sanam.yavarpour.domain.usecase.musicPlayer.model.MusicModel
import com.sanam.yavarpour.domain.usecase.musicPlayer.model.PlayingMusicModel

interface MusicListControllerRepository : Repository {
    suspend fun getMusicList(): ArrayList<MusicModel>
    suspend fun setMusicList(isPremium: Boolean)
    suspend fun updatePlayingMusic(currentMusicId: Int)
    suspend fun getPlayingMusic(): PlayingMusicModel?
    suspend fun nextMusic(
        isPremium: Boolean,
        currentMusicId: Int
    ): Pair<PlayingMusicModel?, String?>

    suspend fun previousMusic(
        isPremium: Boolean,
        currentMusicId: Int
    ): Pair<PlayingMusicModel?, String?>

    suspend fun updateMusicState(item: CurrentMusicStateModel)
    suspend fun getLatestMusicState(): CurrentMusicStateModel
    suspend fun addMusicToQue(musicId: Int): ArrayList<MusicModel>

}