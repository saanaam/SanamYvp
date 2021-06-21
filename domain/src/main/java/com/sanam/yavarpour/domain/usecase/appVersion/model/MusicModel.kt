package com.sanam.yavarpour.domain.usecase.appVersion.model

import android.content.res.AssetFileDescriptor
import com.sanam.yavarpour.domain.Entity

data class MusicModel(
     val id: Int? = null,
     val file: AssetFileDescriptor? = null
) : Entity