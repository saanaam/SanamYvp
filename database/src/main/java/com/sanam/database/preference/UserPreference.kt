package com.sanam.database.preference

import com.sanam.database.Preferences
import com.sanam.database.dto.CurrentMusicStateModelDto
import com.sanam.database.dto.MusicModelDto
import com.sanam.yavarpour.domain.usecase.musicPlayer.model.MusicModel

interface UserPreference : Preferences {
    fun getMusicList(): Array<MusicModelDto>
    fun setMusicList(musicList: ArrayList<MusicModel>)
    fun updateMusicList(musicList: ArrayList<MusicModelDto>)
    fun setPlayingMusic(item: Int)
    fun getPlayingMusic(): Int
    fun setCurrentMusicStateModel(item: CurrentMusicStateModelDto)
    fun getCurrentMusicStateModel(): CurrentMusicStateModelDto
}