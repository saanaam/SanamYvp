package com.sanam.database.preference

import com.sanam.database.Preferences
import com.sanam.database.dto.CurrentMusicStateModelDto
import com.sanam.database.dto.PlayingMusicModelDto

interface UserPreference<T> : Preferences<T> {
    fun getMusicList(): T
    fun setMusicList(t: T, , isPremium: Boolean)
    fun setPlayingMusic(item: Int)
    fun getPlayingMusic(): PlayingMusicModelDto
    fun setCurrentMusicStateModel(item: CurrentMusicStateModelDto)
    fun getCurrentMusicStateModel(): CurrentMusicStateModelDto


}