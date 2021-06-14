package com.sanam.yavarpour.presentation.splash.main

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.sanam.yavarpour.common.AbstractFragment
import com.sanam.yavarpour.common.util.isGone
import com.sanam.yavarpour.common.util.isVisible
import com.sanam.yavarpour.common.util.show
import com.sanam.yavarpour.presentation.R
import com.sanam.yavarpour.presentation.splash.main.adapter.OnPlaylistAdapterListener
import com.sanam.yavarpour.presentation.splash.main.adapter.PlaylistAdapter
import com.sanam.yavarpour.presentation.splash.main.model.MusicListModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_main.*


@AndroidEntryPoint
class MainFragment : AbstractFragment<MainState, MainViewModel>(), OnPlaylistAdapterListener {
    private lateinit var linearLayoutManager: LinearLayoutManager
    private var playListAdapter: PlaylistAdapter? = null

    private val mainViewModel by viewModels<MainViewModel>()
    override val viewModel: MainViewModel
        get() = mainViewModel
    override val layoutResId: Int
        get() = R.layout.fragment_main


    override fun initViews(view: View, savedInstanceState: Bundle?) {
        super.initViews(view, savedInstanceState)
        playListAdapter = PlaylistAdapter(this)
        mainViewModel.getAppVersion()
        initRecyclerview()
    }

    override fun playSong(song: MusicListModel, songs: ArrayList<MusicListModel>) {
        music_name_text_view.run {
            if (this.isGone())
                this.show()
            text = song.title
        }
    }

    override fun renderView(state: MainState) {
        state.data?.let {
            playListAdapter?.songs = it
        }
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

}