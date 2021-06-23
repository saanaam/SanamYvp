package com.sanam.database.preference

import android.content.Context
import com.google.gson.Gson
import com.sanam.database.AbstractSharedPreferences
import com.sanam.database.dto.CurrentMusicStateModelDto
import com.sanam.database.dto.MusicModelDto
import com.sanam.database.dto.PlayingMusicModelDto
import javax.inject.Inject

class MusicListSharedPreference @Inject constructor(context: Context) :
    AbstractSharedPreferences(context), UserPreference<Array<MusicModelDto>> {

    override fun getMusicList(): Array<MusicModelDto> {
        val gson = Gson()
        val jsonText: String? = sharedPreferences.getString(PARAM_KEY, "")
        return gson.fromJson(
            jsonText,
            Array<MusicModelDto>::class.java
        )
    }

    override fun setMusicList(value: Array<MusicModelDto>, isPremium: Boolean) {
        val gson = Gson()
        val json: String = if (isPremium) {
            gson.toJson(value)
        } else {
            //TODO Shuffle
            gson.toJson(value)
        }
        sharedPreferences.edit()
            .putString(PARAM_KEY, json)
            .apply()
    }

    override fun setPlayingMusic(currentMusicId: Int) {
        val gson = Gson()
        val json: String = gson.toJson(currentMusicId)
        sharedPreferences.edit()
            .putString(CURRENT_MUSIC_KEY, json)
            .apply()
    }

    override fun getPlayingMusic(): PlayingMusicModelDto {
        //TODO set mock data and find the data list
        val gson = Gson()
        val jsonText: String? = sharedPreferences.getString(CURRENT_MUSIC_KEY, "")
        return gson.fromJson(
            jsonText,
            PlayingMusicModelDto::class.java
        )
    }

    override fun setCurrentMusicStateModel(item: CurrentMusicStateModelDto) {
        val gson = Gson()
        val json: String = gson.toJson(item)
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