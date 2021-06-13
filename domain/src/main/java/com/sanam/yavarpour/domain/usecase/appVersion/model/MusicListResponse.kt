package com.sanam.yavarpour.domain.usecase.appVersion.model

import com.sanam.yavarpour.domain.Entity

data class MusicListResponse(
     var id: Int? = null,
     var title: String? = null,
     var Singer: String? = null,
     var time: String? = null
) : Entity