package com.nar.bimito.config

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()
//        configLogger()
    }

//    private fun configLogger() = Timber.plant(LogPlantConfig())

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

}