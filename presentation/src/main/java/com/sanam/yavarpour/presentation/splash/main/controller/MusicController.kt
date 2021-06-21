package com.sanam.yavarpour.presentation.splash.main.controller

import android.content.Context
import android.content.Intent
import com.sanam.yavarpour.presentation.splash.main.model.MusicItemModel
import com.sanam.yavarpour.presentation.splash.main.service.MusicService


class MusicController constructor(private val musicService: MusicService, private val context : Context) :
    MediaControllerListener {

    override fun play(position: Int) {
        musicService.let {
            it.setSong(position)
            it.playSong()
        }
    }

    override fun resume() {
        musicService.let {
           it.resumeMedia()
        }
    }

    override fun pause() {
        musicService.let {
            it.pauseMedia()
        }
    }

    override fun setPlayList(arrayList: ArrayList<MusicItemModel?>) {
        musicService.setList(arrayList)

    }

    override fun start() {
        musicService.go();
    }

    override fun getDuration(): Int {
        return if (musicService.isPng()) {
            musicService.getDur();
        } else 0
    }

    override fun getCurrentPosition(): Int {
        return if (musicService.isPng()) {
            musicService.getPosn();
        } else 0
    }

    override fun seekTo(pos: Int) {
        musicService.seek(pos);
    }

    override fun isPlaying(): Boolean {
        return musicService.isPng();
    }

    override fun next() {
        TODO("Not yet implemented")
    }

    override fun previous() {
        TODO("Not yet implemented")
    }

    override fun shuffle() {
        TODO("Not yet implemented")
    }

}