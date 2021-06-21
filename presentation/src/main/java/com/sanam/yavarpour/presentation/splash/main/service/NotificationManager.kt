package com.sanam.yavarpour.presentation.splash.main.service

import android.app.*
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.RemoteViews
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.navigation.NavDeepLinkBuilder
import com.sanam.yavarpour.presentation.R
import com.sanam.yavarpour.presentation.splash.splash.SplashActivity


class NotificationManager(private val mService: MusicService) {
    private var mNotificationManager: NotificationManager? = null
    private var notificationBuilder: NotificationCompat.Builder? = null
    private var mCollapsedRemoteViews: RemoteViews? = null
    private var mExpandedRemoteViews: RemoteViews? = null
    private val mStopIntent: PendingIntent

    private var mStarted = false //To check if notification manager is started or not!

    private fun getPackageName(): String {
        return mService.applicationContext.packageName
    }

    init {
//        mStopIntent = PendingIntent.getBroadcast(
//            mService, NOTIFICATION_REQUEST_CODE,
//            Intent(ACTION_STOP).setPackage(getPackageName()), PendingIntent.FLAG_CANCEL_CURRENT
//        )
        val intent = Intent(mService, SplashActivity::class.java)
        intent.action = ACTION_STOP
//        mStopIntent = PendingIntent.getActivity(
//            mService, NOTIFICATION_REQUEST_CODE, intent,
//            PendingIntent.FLAG_CANCEL_CURRENT
//        )

        val args = Bundle()
        args.putBoolean("stop", true)
        mStopIntent = NavDeepLinkBuilder(mService)
            .setComponentName(SplashActivity::class.java)
            .setGraph(R.navigation.splash_nav_graph)
            .setDestination(R.id.mainFragment)
            .setArguments(args)
            .createPendingIntent()
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

    private fun generateNotification(): Notification? {
        if (notificationBuilder == null) {
            notificationBuilder =
                NotificationCompat.Builder(mService.applicationContext, CHANNEL_ID)
            notificationBuilder?.setSmallIcon(R.drawable.itunes)
                ?.setContentTitle(mService.getString(R.string.playing))
                ?.setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                ?.setDeleteIntent(mStopIntent)
                ?.setCategory(NotificationCompat.CATEGORY_TRANSPORT)
            // Notification channels are only supported on Android O+.
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                createNotificationChannel()
            }
        }

        mCollapsedRemoteViews =
            RemoteViews(getPackageName(), R.layout.player_collapsed_notification)
        mCollapsedRemoteViews?.let { createCollapsedRemoteViews(it) }

        notificationBuilder?.setCustomContentView(mCollapsedRemoteViews)
        notificationBuilder?.priority = NotificationCompat.PRIORITY_DEFAULT;

        // To make sure that the notification can be dismissed by the user when we are not playing.
        notificationBuilder?.setOngoing(true)
        mNotificationManager?.notify(NOTIFICATION_ID, notificationBuilder?.build())
        return notificationBuilder?.build()
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

    private fun createCollapsedRemoteViews(collapsedRemoteViews: RemoteViews) {
        collapsedRemoteViews.setImageViewResource(
            R.id.collapsed_notification_pause_image_view,
            R.drawable.ic_stop
        )
        setListeners(collapsedRemoteViews);

    }

    private fun setListeners(view: RemoteViews) {
        view.setOnClickPendingIntent(
            R.id.collapsed_notification_pause_image_view,
            mStopIntent
        )
        mNotificationManager?.cancelAll()

    }

    companion object {
        private const val CHANNEL_ID = "app.MUSIC_CHANNEL_ID"
        private const val CHANNEL_ID_FOR_APP = "app.MUSIC_CHANNEL_ID"
        private const val NOTIFICATION_ID = 412
        private const val NOTIFICATION_REQUEST_CODE = 100
        private const val ACTION_STOP = "app.stop"
    }


}