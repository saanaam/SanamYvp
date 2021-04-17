package com.nar.bimito.domain.usecase.appVersion.model

import com.nar.bimito.domain.Entity

data class AppVersionResponse(
     var id: Int? = null,
     var androidAppVersion: Double? = null,
     var iOSAppVersion: Double? = null,
     var LaunchDate: String? = null
) : Entity