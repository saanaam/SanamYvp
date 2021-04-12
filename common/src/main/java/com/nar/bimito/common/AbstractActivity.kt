package com.nar.bimito.common

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment


abstract class AbstractActivity : AppCompatActivity() {

    companion object {

        init {
            AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        }
    }

    @get:IdRes
    protected abstract val navHostFragmentId: Int
    protected lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val navHostFragment = supportFragmentManager.findFragmentById(navHostFragmentId) as NavHostFragment
//
//        navController = navHostFragment.navController
    }

    fun authenticateAgain() {
//        if (this !is AuthenticationActivity) {
//            startActivity<AuthenticationActivity>(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
//        }
    }

    override fun onSupportNavigateUp() = navController.navigateUp()


}