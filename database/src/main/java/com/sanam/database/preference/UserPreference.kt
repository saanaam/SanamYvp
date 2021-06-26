package com.sanam.database.preference

import com.sanam.database.Preferences
import com.sanam.database.dto.CurrentMusicStateModelDto
import com.sanam.database.dto.MusicModelDto
import com.sanam.yavarpour.domain.usecase.musicPlayer.model.MusicModel

interface UserPreference : Preferences {
    fun getMusicList(): Array<MusicModelDto>
    fun setMusicList(musicList: ArrayList<MusicModel>)
    fun setPlayingMusic(playingMusicId: Int)
    fun getPlayingMusic(): Int
    fun setCurrentMusicStateModel(currentMusicStateModelDto: CurrentMusicStateModelDto)
    fun getCurrentMusicStateModel(): CurrentMusicStateModelDto
}