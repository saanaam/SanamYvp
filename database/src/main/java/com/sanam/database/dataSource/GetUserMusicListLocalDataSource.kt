package com.sanam.database.dataSource

import android.content.Context
import com.sanam.database.dto.MusicModelDto
import com.sanam.database.dto.MusicModelDtoMapper
import com.sanam.database.preferenceDelegation.PreferenceDelegation
import com.sanam.database.premiumSharePreference.PremiumUserSharedPreference
import com.sanam.database.usualSharedPreference.UsualUserSharedPreference
import com.sanam.yavarpour.domain.usecase.appVersion.model.MusicModel
import com.sanam.yavarpour.local.localDataSource.GetUserMusicListDataSource
import javax.inject.Inject

class GetUserMusicListLocalDataSource @Inject constructor(
    private val context: Context,
    private val musicModelDtoMapper: MusicModelDtoMapper
) : GetUserMusicListDataSource {

    override suspend fun getMusicList(isPremium: Boolean): ArrayList<MusicModel> {
        return if (isPremium) {
            val list = PreferenceDelegation(PremiumUserSharedPreference(context)).getMusicList()
            musicModelDtoMapper.mapToData(list as ArrayList<MusicModelDto>)
        } else {
            val list = PreferenceDelegation(UsualUserSharedPreference(context)).getMusicList()
            musicModelDtoMapper.mapToData(list as ArrayList<MusicModelDto>)
        }
    }

}