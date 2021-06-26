package com.sanam.yavarpour

import com.sanam.yavarpour.domain.usecase.musicPlayer.usecase.musicListUseCase.model.MusicModel


class MusicListMock {

    fun musicList(): ArrayList<MusicModel> {
        return ArrayList<MusicModel>().apply {
            add(MusicModel(1))
            add(MusicModel(2))
            add(MusicModel(3))
            add(MusicModel(4))
            add(MusicModel(5))
            add(MusicModel(6))
            add(MusicModel(7))
            add(MusicModel(8))
            add(MusicModel(9))
            add(MusicModel(10))
        }
    }

}
