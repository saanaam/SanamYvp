package com.sanam.yavarpour.domain.usecase.musicPlayer.model

import com.sanam.yavarpour.domain.Entity

data class PlayingMusicModel(
    val id: Int,
    val songName: String,
    val artist: String,
    val duration: Int
) : Entity