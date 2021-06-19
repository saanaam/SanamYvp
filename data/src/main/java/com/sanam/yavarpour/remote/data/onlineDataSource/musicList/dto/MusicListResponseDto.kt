package com.sanam.yavarpour.remote.data.onlineDataSource.musicList.dto

import android.content.res.AssetFileDescriptor
import com.sanam.yavarpour.remote.Dto
import com.squareup.moshi.Json

data class MusicListResponseDto(
    val id: Int? = null,
    val file: AssetFileDescriptor? = null
) : Dto