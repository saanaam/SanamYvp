package com.sanam.database.preference

import com.sanam.database.dto.MusicModelDto
import com.sanam.database.dto.PlayingMusicModelDto


class MusicListMockData {
    fun musicListInfo(): ArrayList<PlayingMusicModelDto> {
        return ArrayList<PlayingMusicModelDto>().apply {
            add(PlayingMusicModelDto(1, "Give Up", "Adel", 120))
            add(PlayingMusicModelDto(2, "The A Team", "Ed Sheeran", 140))
            add(PlayingMusicModelDto(3, "Million Reason", "Lady Gaga", 120))
            add(PlayingMusicModelDto(4, "Cool For The Summer", "Demi Lovato", 185))
            add(PlayingMusicModelDto(5, "Killing Me Softly", "Frank Sinatra", 120))
            add(PlayingMusicModelDto(6, "Years & Years", "Olly Murs", 240))
            add(PlayingMusicModelDto(7, "Unstoppable", "sia", 120))
            add(PlayingMusicModelDto(8, "Hands To Myselft", "Selena Gomez", 120))
            add(PlayingMusicModelDto(9, "You Are The Reason", "Calum Scott", 140))
            add(PlayingMusicModelDto(10, "it Aint me", "Selena", 160))
        }
    }
}
