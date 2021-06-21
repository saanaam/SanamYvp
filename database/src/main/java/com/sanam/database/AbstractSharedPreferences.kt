package com.sanam.database

import android.content.Context
import android.content.SharedPreferences

abstract class AbstractSharedPreferences(context: Context) {
    companion object {
        const val PREFERENCES_NAME = "com._PREF"
    }
    protected val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)

}