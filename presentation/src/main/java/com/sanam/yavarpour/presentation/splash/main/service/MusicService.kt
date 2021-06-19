package com.sanam.yavarpour.presentation.splash.main.service

import android.app.Service
import android.content.Intent
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Binder
import android.os.Build
import android.os.IBinder
import android.util.Log
import com.sanam.yavarpour.presentation.splash.main.model.MusicItemModel
import java.io.IOException

class MusicService : Service(), MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener,
    MediaPlayer.OnCompletionListener, MediaPlayer.OnSeekCompleteListener,
    AudioManager.OnAudioFocusChangeListener {
    private var mNotificationManager: NotificationManager? = null

    //media player
    private val player: MediaPlayer? by lazy { MediaPlayer() }
    private val musicBind: IBinder = MusicBinder()

    //song list
    private lateinit var songs: ArrayList<MusicItemModel?>

    override fun onCreate() {
        super.onCreate()
        mNotificationManager = NotificationManager(this)
        mNotificationManager?.createMediaNotification()
    }

    //current position
    private var songPosn = 0
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        songPosn = 0
        initMusicPlayer()
        return START_NOT_STICKY
    }

    private fun initMusicPlayer() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            player!!.setAudioAttributes(
                AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .build()
            )
        } else {
            player!!.setAudioStreamType(AudioManager.STREAM_MUSIC)
        }
        //Set up MediaPlayer event listeners
        player!!.setOnCompletionListener(this)
        player!!.setOnErrorListener(this)
        player!!.setOnPreparedListener(this)
        player!!.setOnSeekCompleteListener(this)
    }

    override fun onBind(intent: Intent?): IBinder? {
        return musicBind
    }

    class MusicBinder : Binder() {
        val service: MusicService
            get() = MusicService()
    }

    override fun onPrepared(mp: MediaPlayer?) {
        //start playback
        playMedia();
    }

    override fun onError(p0: MediaPlayer?, what: Int, extra: Int): Boolean {
        //Invoked when there has been an error during an asynchronous operation
        when (what) {
            MediaPlayer.MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK -> Log.d(
                "MediaPlayer Error",
                "MEDIA ERROR NOT VALID FOR PROGRESSIVE PLAYBACK $extra"
            )
            MediaPlayer.MEDIA_ERROR_SERVER_DIED -> Log.d(
                "MediaPlayer Error",
                "MEDIA ERROR SERVER DIED $extra"
            )
            MediaPlayer.MEDIA_ERROR_UNKNOWN -> Log.d(
                "MediaPlayer Error",
                "MEDIA ERROR UNKNOWN $extra"
            )
        }
        return false
    }

    override fun onCompletion(p0: MediaPlayer?) {

    }

    fun setList(theSongs: ArrayList<MusicItemModel?>) {
        songs = theSongs
    }

    fun setSong(songIndex: Int) {
        songPosn = songIndex
    }

    override fun onUnbind(intent: Intent?): Boolean {
        player!!.stop()
        player!!.release()
        return false
    }

    fun playSong() {
        //get song
        val playSong: MusicItemModel = songs[songPosn]!!
        val currSong: Int = playSong.id!!
        try {
            if (player!!.isPlaying) {
                player!!.stop()
                player!!.reset()
            }

            player!!.setDataSource(
                playSong.file!!.fileDescriptor,
                playSong.file.startOffset,
                playSong.file.length
            )
            player?.prepare()
            player?.start()

        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    override fun onSeekComplete(p0: MediaPlayer?) {
        TODO("Not yet implemented")
    }

    override fun onAudioFocusChange(p0: Int) {
        TODO("Not yet implemented")
    }

    private fun playMedia() {
        if (!player?.isPlaying!!) {
            player?.start()
        }
    }

    private fun stopMedia() {
        if (player?.isPlaying!!) {
            player!!.stop()
        }
    }

    private fun pauseMedia() {
        if (player?.isPlaying!!) {
            player!!.pause()
        }
    }

    private fun resumeMedia() {
        if (!player?.isPlaying!!) {
//            player.seekTo(resumePosition)
            player!!.start()
        }
    }

    fun getCurrentSong(): MusicItemModel? {
        return songs[songPosn]
    }

    fun stop() {
        stopForeground(true)
        mNotificationManager = null
        stopSelf()
    }


}