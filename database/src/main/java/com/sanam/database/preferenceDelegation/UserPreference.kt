package com.sanam.database.preferenceDelegation

import com.sanam.database.Preferences

interface UserPreference<T> : Preferences<T> {
    fun getMusicList(): T
    fun setMusicList(t: T)

}