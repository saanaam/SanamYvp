package com.sanam.database.dto

import com.sanam.database.Dto

data class PlayingMusicModelDto(
    val id: Int,
    val songName: String,
    val artist: String,
    val popularity: Int,
    val constructorYear : Int,
    val duration: Int
) : Dto