package com.sanam.yavarpour.domain.usecase.appVersion.model

import com.sanam.yavarpour.domain.Entity

data class PlayingMusicModel(
    val id: Int,
    val songName: String,
    val artist: String,
    val popularity: Int,
    val constructorYear: Int,
    val duration: Int
) : Entity