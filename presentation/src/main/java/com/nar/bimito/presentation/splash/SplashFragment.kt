package com.nar.bimito.presentation.splash

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.navigation.NavDirections
import com.nar.bimito.common.AbstractFragment
import com.nar.bimito.common.util.setImageResourceCompat
import com.nar.bimito.presentation.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_splash.*

@AndroidEntryPoint
class SplashFragment : AbstractFragment<SplashState, SplashViewModel>() {

    companion object {
        private const val SPLASH_DELAY = 2000L
    }

    override val layoutResId: Int
        get() = R.layout.fragment_splash

    override val viewModel: Nothing
        get() = TODO("Not yet implemented")

    override fun initViews(view: View, savedInstanceState: Bundle?) {
        super.initViews(view, savedInstanceState)
        setImageResourceCompat(splash_image_view, R.drawable.ic_splash)

    }

    override fun renderView(state: SplashState) {
        state.navigation?.let {
            navigateToMain(it)
        }
    }


    private fun navigateToMain(it: NavDirections) {
        Handler().postDelayed({
            navController.navigate(it)
        }, SPLASH_DELAY)
    }

    //TODO i have to ask about processRedirection method in SplashActivity
}