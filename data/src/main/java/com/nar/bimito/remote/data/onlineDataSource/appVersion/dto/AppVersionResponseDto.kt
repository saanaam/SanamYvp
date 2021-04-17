package com.nar.bimito.remote.data.onlineDataSource.appVersion.dto

import com.nar.bimito.remote.Dto
import com.squareup.moshi.Json

data class AppVersionResponseDto(
    @field:Json(name="id")
     val id: Int? = null,
    @field:Json(name="androidAppVersion")
    val androidAppVersion: Double? = null,
    @field:Json(name="iOSAppVersion")
    val iOSAppVersion: Double? = null,
    @field:Json(name="LaunchDate")
    val LaunchDate: String? = null
) : Dto