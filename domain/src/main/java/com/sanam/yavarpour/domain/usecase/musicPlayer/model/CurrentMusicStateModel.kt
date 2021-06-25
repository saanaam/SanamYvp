package com.sanam.yavarpour.domain.usecase.musicPlayer.model
import com.sanam.yavarpour.domain.Entity

data class CurrentMusicStateModel(
    val id: Int,
    val songTime: Int,
    val status: String
) : Entity