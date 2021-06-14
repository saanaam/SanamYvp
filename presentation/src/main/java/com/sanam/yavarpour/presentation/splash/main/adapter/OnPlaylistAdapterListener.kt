package com.sanam.yavarpour.presentation.splash.main.adapter

import com.sanam.yavarpour.presentation.splash.main.model.MusicListModel

/**
 * To make an interaction between [PlaylistActivity]
 * & [PlaylistAdapter]
 *
 * @author ZARA
 * */
interface OnPlaylistAdapterListener {

    fun playSong(song: MusicListModel, songs: ArrayList<MusicListModel>)

}