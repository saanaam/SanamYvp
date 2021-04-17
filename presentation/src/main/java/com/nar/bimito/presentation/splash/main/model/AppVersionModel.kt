package com.nar.bimito.presentation.splash.main.model

import com.nar.bimito.common.PresentationModel

data class AppVersionModel(
     var id: Int? = null,
     val androidAppVersion: Double? = null,
     val iOSAppVersion: Double? = null,
     var LaunchDate: String? = null
) : PresentationModel