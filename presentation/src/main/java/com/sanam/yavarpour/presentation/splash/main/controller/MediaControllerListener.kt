package com.sanam.yavarpour.presentation.splash.main.controller

import com.sanam.yavarpour.presentation.splash.main.model.MusicItemModel

interface MediaControllerListener {
    fun play(position: Int)
    fun pause()
    fun next()
    fun previous()
    fun shuffle()
     fun setPlayList(arrayList: ArrayList<MusicItemModel?>)
    fun start()
    fun getDuration(): Int
    fun getCurrentPosition(): Int
    fun seekTo(pos: Int)
    fun isPlaying(): Boolean
    fun resume()

}