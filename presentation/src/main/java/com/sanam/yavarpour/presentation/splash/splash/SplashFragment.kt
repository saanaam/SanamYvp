package com.sanam.yavarpour.presentation.splash.splash

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.fragment.app.viewModels
import com.sanam.yavarpour.common.AbstractFragment
import com.sanam.yavarpour.common.util.setImageResourceCompat
import com.sanam.yavarpour.presentation.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_splash.*

@AndroidEntryPoint
class SplashFragment : AbstractFragment<SplashState, SplashViewModel>() {

    private val splashViewModel: SplashViewModel by viewModels()
    override val viewModel: SplashViewModel
        get() = splashViewModel
    override val layoutResId: Int
        get() = R.layout.fragment_splash

    override fun initViews(view: View, savedInstanceState: Bundle?) {
        super.initViews(view, savedInstanceState)
        setImageResourceCompat(splash_image_view, R.drawable.splash)
        viewModel.setMusicList(true)
    }

    override fun renderView(state: SplashState) {
        state.navigation?.let { nav ->
            navController.navigate(nav)
        }
    }

}