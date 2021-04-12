package com.nar.bimito.presentation.splash

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.nar.bimito.common.AbstractActivity
import com.nar.bimito.presentation.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
open class SplashActivity : AbstractActivity() {

    private lateinit var navController: NavController
    private val navHostFragmentId: Int get() = R.id.navHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val navHostFragment =
            supportFragmentManager.findFragmentById(navHostFragmentId) as NavHostFragment
        navController = navHostFragment.navController
    }

    override fun onSupportNavigateUp() = navController.navigateUp()

}