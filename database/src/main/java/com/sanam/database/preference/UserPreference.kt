package com.sanam.database.preference

import com.sanam.database.Preferences
import com.sanam.database.dto.CurrentMusicStateModelDto
import com.sanam.database.dto.MusicModelDto

interface UserPreference : Preferences {
    fun getMusicList(): Array<MusicModelDto>
    fun setMusicList(musicList: ArrayList<MusicModelDto>)
    fun setPlayingMusic(playingMusicId: Int)
    fun getPlayingMusic(): Int
    fun setCurrentMusicStateModel(currentMusicStateModelDto: CurrentMusicStateModelDto)
    fun getCurrentMusicStateModel(): CurrentMusicStateModelDto
}