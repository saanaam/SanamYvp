package com.sanam.yavarpour.presentation.splash.main

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.view.View
import androidx.core.content.ContextCompat.startForegroundService
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.sanam.yavarpour.common.AbstractFragment
import com.sanam.yavarpour.common.util.isGone
import com.sanam.yavarpour.common.util.show
import com.sanam.yavarpour.presentation.R
import com.sanam.yavarpour.presentation.splash.main.adapter.OnPlaylistAdapterListener
import com.sanam.yavarpour.presentation.splash.main.adapter.PlaylistAdapter
import com.sanam.yavarpour.presentation.splash.main.model.MusicItemModel
import com.sanam.yavarpour.presentation.splash.main.service.MusicService
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_main.*


@AndroidEntryPoint
class MusicListFragment : AbstractFragment<MainState, MainViewModel>(), OnPlaylistAdapterListener {
    private lateinit var linearLayoutManager: LinearLayoutManager
    private var playListAdapter: PlaylistAdapter? = null
    private val mainViewModel by viewModels<MainViewModel>()
    private val musicSrv: MusicService by lazy{
        MusicService()
    }

    private var playIntent: Intent? = null

    override val viewModel: MainViewModel
        get() = mainViewModel
    override val layoutResId: Int
        get() = R.layout.fragment_main


    override fun initViews(view: View, savedInstanceState: Bundle?) {
        super.initViews(view, savedInstanceState)
        playListAdapter = PlaylistAdapter(this)
        mainViewModel.getMusicList()
        initRecyclerview()
    }

    /*
   * this method is called after view has been created to
   * initialized recyclerview
   * */
    private fun initRecyclerview() {
        linearLayoutManager = LinearLayoutManager(context)
        recyclerview_music_list.apply {
            this.layoutManager = linearLayoutManager
            this.adapter = playListAdapter
        }
    }

    /*
 * this method is called after observing Observable data source
 * */
    override fun renderView(state: MainState) {
        state.data?.let {
            playListAdapter!!.songs = it
            musicSrv.setList(playListAdapter!!.getItems() as ArrayList<MusicItemModel?> )
        }
    }

    /*
 * this method is called after clicking on music Item or play music
 * */
    override fun playSong(song: MusicItemModel, position: Int) {
        play(song, position)
    }

    private fun play(song: MusicItemModel, position: Int) {
        music_name_text_view.run {
            if (this.isGone())
                this.show()
            text = song.file.toString()
        }
        viewModel.setPlayStatus(true)
        musicSrv.let {
            it.setSong(position)
            it.playSong()
        }
    }

    private fun Pause(){

    }

    override fun onStart() {
        super.onStart()
        playIntent = Intent(context, MusicService::class.java)
        startForegroundService(requireContext(), playIntent!!)
    }


}