package com.sanam.database.preference

import com.sanam.database.Preferences
import com.sanam.database.dto.CurrentMusicStateModelDto
import com.sanam.database.dto.MusicModelDto
import com.sanam.database.dto.PlayingMusicModelDto

interface UserPreference : Preferences {
    fun getMusicList(): Array<MusicModelDto>
    fun setMusicList(isPremium: Boolean)
    fun updateMusicList(musicList: ArrayList<MusicModelDto>)
    fun setPlayingMusic(item: Int)
    fun getPlayingMusic(): Int
    fun setCurrentMusicStateModel(item: CurrentMusicStateModelDto)
    fun getCurrentMusicStateModel(): CurrentMusicStateModelDto
}