package com.sanam.database.preference

import android.content.Context
import com.google.gson.Gson
import com.sanam.database.AbstractSharedPreferences
import com.sanam.database.dto.CurrentMusicStateModelDto
import com.sanam.database.dto.MusicModelDto
import com.sanam.database.dto.PlayingMusicModelDto
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

    override fun setMusicList(isPremium: Boolean) {
        val gson = Gson()
        val json: String = if (isPremium) {
            gson.toJson(MusicListMockData().musicList())
        } else {
            gson.toJson(MusicListMockData().musicList().shuffle())
        }
        sharedPreferences.edit()
            .putString(PARAM_KEY, json)
            .apply()
    }

    override fun setPlayingMusic(currentMusicId: Int) {
        sharedPreferences.edit()
            .putInt(CURRENT_MUSIC_KEY, currentMusicId)
            .apply()
    }

    override fun getPlayingMusic(): Int {
        return sharedPreferences.getInt(CURRENT_MUSIC_KEY, 0)
    }

    override fun setCurrentMusicStateModel(currentMusicState: CurrentMusicStateModelDto) {
        val gson = Gson()
        val json: String = gson.toJson(currentMusicState)
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

    override fun updateMusicList(musicList: ArrayList<MusicModelDto>) {
        val gson = Gson()
        val json: String = gson.toJson(MusicListMockData().musicList())
        sharedPreferences.edit()
            .putString(PARAM_KEY, json)
            .apply()
    }


    companion object {
        private const val PARAM_KEY = "premium_key"
        private const val CURRENT_MUSIC_KEY = "current_music_key"
        private const val MUSIC_STATE_KEY = "music_state_key"
    }


}