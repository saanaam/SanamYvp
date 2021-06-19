package com.sanam.yavarpour.presentation.splash.main.service

import android.app.*
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.widget.RemoteViews
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import com.sanam.yavarpour.presentation.R
import com.sanam.yavarpour.presentation.splash.main.model.MusicItemModel

class NotificationManager(private val mService: MusicService) {
    private var mNotificationManager: NotificationManager? = null
    private var notificationBuilder: NotificationCompat.Builder? = null
    var mStarted = false //To check if notification manager is started or not!

    init {
        mNotificationManager =
            mService.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    }

    /**
     * To start notification and service
     */
    fun createMediaNotification() {
        if (!mStarted) {
            mStarted = true
            mService.startForeground(NOTIFICATION_ID, generateNotification())
        }
    }


    fun generateNotification(): Notification? {
        if (notificationBuilder == null) {
            notificationBuilder =
                NotificationCompat.Builder(mService.applicationContext, CHANNEL_ID)
            notificationBuilder?.setSmallIcon(R.drawable.itunes)
                ?.setContentTitle(mService.getString(R.string.playing))
                ?.setContentText(mService.getString(R.string.playing))
                ?.setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                ?.setCategory(NotificationCompat.CATEGORY_TRANSPORT)
                ?.setOnlyAlertOnce(true)

            // Notification channels are only supported on Android O+.
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                createNotificationChannel()
            }
        }

        notificationBuilder?.setContentIntent(createContentIntent())
        // To make sure that the notification can be dismissed by the user when we are not playing.
        notificationBuilder?.setOngoing(true)

        mNotificationManager?.notify(NOTIFICATION_ID, notificationBuilder?.build())
        return notificationBuilder?.build()
    }


    private fun createContentIntent(): PendingIntent {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("player://")).apply {
            flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
//            mService.getCurrentSong()?.let {
//                putExtra(MusicItemModel::class.java.name, it)
//            }

        }

        return TaskStackBuilder.create(mService).run {
            // Add the intent, which inflates the back stack
            addNextIntentWithParentStack(intent)
            // Get the PendingIntent containing the entire back stack
            getPendingIntent(NOTIFICATION_REQUEST_INTENT_CODE, PendingIntent.FLAG_UPDATE_CURRENT)
        }
    }

    /**
     * Creates Notification Channel. This is required in Android O+ to display notifications.
     */
    @RequiresApi(Build.VERSION_CODES.O)
    fun createNotificationChannel() {
        if (mNotificationManager?.getNotificationChannel(CHANNEL_ID) == null) {
            val notificationChannel = NotificationChannel(
                CHANNEL_ID,
                CHANNEL_ID_FOR_APP,
                NotificationManager.IMPORTANCE_LOW
            )
            notificationChannel.description =
                CHANNEL_ID_FOR_APP
            mNotificationManager?.createNotificationChannel(notificationChannel)
        }
    }


    companion object {
        private const val CHANNEL_ID = "app.MUSIC_CHANNEL_ID"
        private const val CHANNEL_ID_FOR_APP = "app.MUSIC_CHANNEL_ID"
        private const val NOTIFICATION_ID = 412
        private const val NOTIFICATION_REQUEST_INTENT_CODE = 125245
    }

}