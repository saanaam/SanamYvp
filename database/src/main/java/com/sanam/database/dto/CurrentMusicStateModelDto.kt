package com.sanam.database.dto

import com.sanam.database.Dto

data class CurrentMusicStateModelDto(
    val id: Int,
    val songTime: Int,
    val status: String
) : Dto

