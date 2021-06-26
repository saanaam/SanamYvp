package com.sanam.database.preference

import android.content.Context
import com.google.gson.Gson
import com.sanam.database.AbstractSharedPreferences
import com.sanam.database.dto.CurrentMusicStateModelDto
import com.sanam.database.dto.MusicModelDto
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class MusicListSharedPreference @Inject constructor(@ApplicationContext context: Context) :
    AbstractSharedPreferences(context), UserPreference {

    override fun getMusicList(): Array<MusicModelDto> {
        val gson = Gson()
        val jsonText: String? = sharedPreferences.getString(PARAM_KEY, "")
        return gson.fromJson(
            jsonText,
            Array<MusicModelDto>::class.java
        )
    }

    override fun setMusicList(musicList: ArrayList<MusicModelDto>) {
        val gson = Gson()
        val json = gson.toJson(musicList)
        sharedPreferences.edit()
            .putString(PARAM_KEY, json)
            .apply()
    }

    override fun setPlayingMusic(playingMusicId: Int) {
        sharedPreferences.edit()
            .putInt(CURRENT_MUSIC_KEY, playingMusicId)
            .apply()
    }

    override fun getPlayingMusic() = sharedPreferences.getInt(CURRENT_MUSIC_KEY, 0)


    override fun setCurrentMusicStateModel(currentMusicStateModelDto: CurrentMusicStateModelDto) {
        val gson = Gson()
        val json: String = gson.toJson(currentMusicStateModelDto)
        sharedPreferences.edit()
            .putString(MUSIC_STATE_KEY, json)
            .apply()
    }

    override fun getCurrentMusicStateModel(): CurrentMusicStateModelDto {
        val gson = Gson()
        val jsonText: String? = sharedPreferences.getString(CURRENT_MUSIC_KEY, "")
        return gson.fromJson(
            jsonText,
            CurrentMusicStateModelDto::class.java
        )
    }

    companion object {
        private const val PARAM_KEY = "premium_key"
        private const val CURRENT_MUSIC_KEY = "current_music_key"
        private const val MUSIC_STATE_KEY = "music_state_key"
    }


}