package com.sanam.yavarpour.presentation.splash.main.model

import com.sanam.yavarpour.common.PresentationModel

data class MusicListModel(
     var id: Int? = null,
     var title: String? = null,
     var Singer: String? = null,
     var time: String? = null
) : PresentationModel