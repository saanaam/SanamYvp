package com.sanam.database.dto

import com.sanam.database.Dto

data class MusicModelDto(
    val songName: String,
    val artist: String,
    val duration: String
) : Dto {

}