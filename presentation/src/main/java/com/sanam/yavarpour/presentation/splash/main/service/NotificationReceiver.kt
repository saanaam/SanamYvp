package com.sanam.yavarpour.presentation.splash.main.service

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.sanam.yavarpour.presentation.splash.splash.SplashActivity

class NotificationReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val intent = Intent(context, SplashActivity::class.java)
        intent.action = "app.stop"
        intent.putExtra("app.stop" , true)
    }
}