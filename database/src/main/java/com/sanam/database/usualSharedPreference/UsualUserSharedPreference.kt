package com.sanam.database.usualSharedPreference

import android.content.Context
import com.google.gson.Gson
import com.sanam.database.AbstractSharedPreferences
import com.sanam.database.dto.MusicModelDto
import com.sanam.database.preferenceDelegation.UserPreference
import javax.inject.Inject
import kotlin.reflect.KProperty

class UsualUserSharedPreference @Inject constructor(context: Context) :
    AbstractSharedPreferences(context), UserPreference<Array<MusicModelDto>> {

    companion object {
        private const val PARAM_KEY = "premium_key"
        private const val PAUSE_KEY = "pause_key"
        private const val SHUFFLE_KEY = "shuffle_key"
        private const val PLAYING_KEY = "playing_key"
        private const val NEXT_KEY = "next_key"
        private const val PREVIOUS_KEY = "previous_key"
        private const val STOP_KEY = "stop_key"
    }

    override fun getMusicList(): Array<MusicModelDto> {
        val gson = Gson()
        val jsonText: String? = sharedPreferences.getString(PAUSE_KEY, "")
        return gson.fromJson(
            jsonText,
            Array<MusicModelDto>::class.java
        )
    }

    override fun setMusicList(value: Array<MusicModelDto>) {
        val gson = Gson()
        val json: String = gson.toJson(value)
        sharedPreferences.edit()
            .putString(PARAM_KEY, json)
            .apply()
    }

    override fun getPlayingMusic(): Int {
        return sharedPreferences.getInt(PLAYING_KEY, 0)

    }

    override fun setPlayingMusic(position: Int) {
        sharedPreferences.edit()
            .putInt(PLAYING_KEY, position)
            .apply()
    }

    override fun isShuffle(): Boolean {
        return sharedPreferences.getBoolean(SHUFFLE_KEY, true)
    }

    override fun setPausePosition(pausePos: Int) {
        sharedPreferences.edit()
            .putInt(PAUSE_KEY, pausePos)
            .apply()
    }

    override fun getPausePosition(): Int {
        return sharedPreferences.getInt(PAUSE_KEY, 0)

    }

    override fun setStop(id: Int) {
        sharedPreferences.edit()
            .putInt(STOP_KEY, id)
            .apply()
    }

    override fun getStop(): Int {
        return sharedPreferences.getInt(STOP_KEY, 0)
    }

    override fun isNextMusicEnable(): Boolean {
        return sharedPreferences.getBoolean(NEXT_KEY, false)

    }

    override fun isPreviousMusicEnable(): Boolean {
        return sharedPreferences.getBoolean(PREVIOUS_KEY, false)
    }

}