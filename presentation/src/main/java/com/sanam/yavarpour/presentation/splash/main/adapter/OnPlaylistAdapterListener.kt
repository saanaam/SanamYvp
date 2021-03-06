package com.sanam.yavarpour.presentation.splash.main.adapter

import com.sanam.yavarpour.presentation.splash.main.model.MusicItemModel

/**
 * To make an interaction between [MusicListFragment]
 * & [PlaylistAdapter]
 *
 * */
interface OnPlaylistAdapterListener {
    fun onMusicItemClick(song: MusicItemModel, songsPosition: Int)
}