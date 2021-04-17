package com.nar.bimito.common

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
abstract class AbstractActivity : AppCompatActivity() {

    companion object {
        init {
            AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        }
    }


    fun authenticateAgain() {
//        if (this !is AuthenticationActivity) {

//        }
    }



}