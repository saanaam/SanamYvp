package com.nar.bimito.presentation.splash

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.fragment.app.viewModels
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

    private val splashViewModel: SplashViewModel by viewModels()
    override val viewModel: SplashViewModel
        get() = splashViewModel
    override val layoutResId: Int
        get() = R.layout.fragment_splash

    override fun initViews(view: View, savedInstanceState: Bundle?) {
        super.initViews(view, savedInstanceState)
        setImageResourceCompat(splash_image_view, R.drawable.splash)
        Handler().postDelayed({
            viewModel.gotoMain()
        }, SPLASH_DELAY)
    }

    override fun renderView(state: SplashState) {

    }


    //TODO i have to ask about processRedirection method in SplashActivity
}