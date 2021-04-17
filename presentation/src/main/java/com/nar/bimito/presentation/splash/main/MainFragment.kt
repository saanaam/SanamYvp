package com.nar.bimito.presentation.splash.main

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.fragment.app.viewModels
import com.nar.bimito.common.AbstractFragment
import com.nar.bimito.common.util.showToast
import com.nar.bimito.presentation.R
import com.nar.bimito.presentation.splash.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainFragment : AbstractFragment<MainState, MainViewModel>() {

    private val mainViewModel by viewModels<MainViewModel>()
    override val viewModel: MainViewModel
        get() = mainViewModel
    override val layoutResId: Int
        get() = R.layout.fragment_main


    override fun initViews(view: View, savedInstanceState: Bundle?) {
        super.initViews(view, savedInstanceState)
        mainViewModel.getAppVersion()
    }

    override fun renderView(state: MainState) {
        state.data?.let {
            showToast(it.androidAppVersion.toString())
        }
    }


}