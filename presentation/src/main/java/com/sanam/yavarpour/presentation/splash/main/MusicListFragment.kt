package com.sanam.yavarpour.presentation.splash.main

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat.startForegroundService
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.sanam.yavarpour.common.AbstractFragment
import com.sanam.yavarpour.common.util.isGone
import com.sanam.yavarpour.common.util.show
import com.sanam.yavarpour.presentation.R
import com.sanam.yavarpour.presentation.splash.main.adapter.OnPlaylistAdapterListener
import com.sanam.yavarpour.presentation.splash.main.adapter.PlaylistAdapter
import com.sanam.yavarpour.presentation.splash.main.model.MusicItemModel
import com.sanam.yavarpour.presentation.splash.main.service.MusicService
import com.sanam.yavarpour.presentation.splash.main.service.NotificationReceiver
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_main.*


@AndroidEntryPoint
class MusicListFragment : AbstractFragment<MainState, MainViewModel>(), OnPlaylistAdapterListener {
    private lateinit var linearLayoutManager: LinearLayoutManager
    private var playListAdapter: PlaylistAdapter? = null
    private val mainViewModel by viewModels<MainViewModel>()
//    val musicService = MusicService()

    val args: MusicListFragmentArgs by navArgs()
    private var mReceiver: BroadcastReceiver = NotificationReceiver()

    private var playIntent: Intent? = null

    override val viewModel: MainViewModel
        get() = mainViewModel
    override val layoutResId: Int
        get() = R.layout.fragment_main

    override fun initViews(view: View, savedInstanceState: Bundle?) {
        super.initViews(view, savedInstanceState)
//        mediaController = MusicController(musicService, requireContext())
        playListAdapter = PlaylistAdapter(this)
        mainViewModel.getMusicList()
        initRecyclerview()
        initButtons()
//        if (args.stop)
//            context?.stopService(Intent(context, MusicService::class.java))

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

    private fun initButtons() {
        song_player_toggle_image_view.setOnClickListener {
            toggle()
        }
    }

    private fun toggle() {
        if (mainViewModel.isPlayData.value == true) pause()
        else mainViewModel.playerData.value?.let { it1 -> play(it1) } ?: run {
            play(0)
        }
    }


    /*
 * this method is called after observing Observable data source
 * */
    override fun renderView(state: MainState) {
        state.data?.let {
            playListAdapter!!.songs = it
//            musicService.setPlayList(playListAdapter!!.getItems() as ArrayList<MusicItemModel?>)
        }

        viewModel.isPlayData.observe(this@MusicListFragment, {
            song_player_toggle_image_view.setImageResource(if (it) R.drawable.ic_pause_vector else R.drawable.ic_play_vector)
        })

    }

    /*
 * this method is called after clicking on music Item or play music
 * */
    override fun onMusicItemClick(song: MusicItemModel, position: Int) {
        viewModel.setPauseStatus(false)
        play(position)
    }

    /*
* in case that isPauseData is true, media player resume the song
* */

    private fun play(position: Int) {
        music_name_text_view.run {
            if (this.isGone())
                this.show()
            text = playListAdapter?.getItem(position).toString()
        }
        if (mainViewModel.isPauseData.value == true) {
//            musicService.resume()
            viewModel.setPauseStatus(false)
        } else {
//            musicService.play(position)
        }
        viewModel.updateSong(position)
        viewModel.setPlayStatus(true)
        if (!MusicService.serviceIsRunning)
            registerForegroundService()

    }

    private fun pause() {
        viewModel.setPlayStatus(false)
        viewModel.setPauseStatus(true)
//        musicService.pause()
    }

    override fun onStart() {
        val filter = IntentFilter()
        filter.addAction("app.stop")
        context?.registerReceiver(mReceiver, filter)
        super.onStart()
    }

    private fun stop() {
        viewModel.setPlayStatus(false)
    }

    private fun registerForegroundService() {
        playIntent = Intent(context, MusicService::class.java)
        startForegroundService(requireContext(), playIntent!!)
    }


}