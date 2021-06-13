package com.sanam.yavarpour.remote.data.onlineDataSource.musicList.dto

import com.sanam.yavarpour.remote.Dto
import com.squareup.moshi.Json

data class MusicListResponseDto(
    @field:Json(name="id")
     val id: Int? = null,
    @field:Json(name="title")
    val title: String? = null,
    @field:Json(name="Singer")
    val Singer: String? = null,
    @field:Json(name="time")
    val time: String? = null
) : Dto