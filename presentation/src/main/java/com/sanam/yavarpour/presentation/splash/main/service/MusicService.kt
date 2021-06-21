package com.sanam.yavarpour.presentation.splash.main.service

import android.app.Service
import android.content.Intent
import android.content.IntentFilter
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Binder
import android.os.Build
import android.os.IBinder
import com.sanam.yavarpour.presentation.splash.main.controller.MediaControllerListener
import com.sanam.yavarpour.presentation.splash.main.model.MusicItemModel
import java.io.IOException


class MusicService : Service(),
    MediaPlayer.OnCompletionListener, MediaPlayer.OnSeekCompleteListener,
    AudioManager.OnAudioFocusChangeListener, MediaControllerListener {
    private var mNotificationManager: NotificationManager? = null

    //media player
    private val musicBind: IBinder = MusicBinder()

    //song list
    private lateinit var songs: ArrayList<MusicItemModel?>
    private val filter: IntentFilter = IntentFilter()

     companion object SERVIETTE {
        var serviceIsRunning = false
         var player = MediaPlayer()
    }

    init {
        filter.addAction("app.stop")
    }

    override fun onCreate() {
        super.onCreate()
        player = MediaPlayer()
        mNotificationManager = NotificationManager(this)
        mNotificationManager?.createMediaNotification()
    }

    //current position
    private var songPosn = 0
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        serviceIsRunning = true

        if (intent?.action == "app.stop") {
            stopSelf()
        }
        songPosn = 0
        initMusicPlayer()
        return START_NOT_STICKY
    }

    private fun initMusicPlayer() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            player?.setAudioAttributes(
                AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .build()
            )
        } else {
            player?.setAudioStreamType(AudioManager.STREAM_MUSIC)
        }
        //Set up MediaPlayer event listeners
        player?.setOnCompletionListener(this)
        player?.setOnSeekCompleteListener(this)
    }

    override fun onBind(intent: Intent?): IBinder? {
        return musicBind
    }

    class MusicBinder : Binder() {
        val service: MusicService
            get() = MusicService()
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
        player?.stop()
        player?.release()
        return false
    }

    override fun stopService(name: Intent?): Boolean {
        serviceIsRunning = false
        stop()
        return super.stopService(name)

    }

    fun playSong() {
        //get song
        val playSong: MusicItemModel = songs[songPosn]!!
        try {
            player?.stop()
            player?.reset()
            player?.setDataSource(
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

    fun stopMedia() {
        try {
            if (player?.isPlaying!!) {
                player?.pause();
                player?.seekTo(0);
                player?.stop()
                player?.release()

            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    public fun pauseMedia() {
        if (player?.isPlaying!!) {
            player?.pause()
        }
    }

    fun resumeMedia() {
        if (!player?.isPlaying!!) {
//            player.seekTo(resumePosition)
            player!!.start()
        }
    }

    fun getCurrentSong(): MusicItemModel? {
        return songs[songPosn]
    }

    private fun stop() {
        stopMedia()
        mNotificationManager = null
//        unregisterReceiver(mReceiver)
        stopForeground(true)
    }

    fun getPosn(): Int {
        return player!!.currentPosition
    }

    fun getDur(): Int {
        return player!!.duration
    }

    fun isPng(): Boolean {
        return player!!.isPlaying
    }

    fun seek(posn: Int) {
        player!!.seekTo(posn)
    }

    fun go() {
        player!!.start()
    }

    public fun playPrev() {
        songPosn--;
        if (songPosn == 0) songPosn = songs.size - 1;
        playSong();
    }

    //skip to next
    public fun playNext() {
        songPosn++;
        if (songPosn == songs.size) songPosn = 0;
        playSong();
    }

    override fun play(position: Int) {
       let {
            it.setSong(position)
            it.playSong()
        }
    }

    override fun resume() {
        let {
            it.resumeMedia()
        }
    }

    override fun pause() {
        let {
            it.pauseMedia()
        }
    }

    override fun setPlayList(arrayList: ArrayList<MusicItemModel?>) {
        setList(arrayList)

    }

    override fun start() {
        go();
    }

    override fun getDuration(): Int {
        return if (isPng()) {
            getDur();
        } else 0
    }

    override fun getCurrentPosition(): Int {
        return if (isPng()) {
           getPosn();
        } else 0
    }

    override fun seekTo(pos: Int) {
        seek(pos);
    }

    override fun isPlaying(): Boolean {
        return isPng();
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