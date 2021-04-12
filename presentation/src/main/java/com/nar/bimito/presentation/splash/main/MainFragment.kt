package com.nar.bimito.presentation.splash.main

import androidx.fragment.app.viewModels
import com.nar.bimito.common.AbstractFragment
import com.nar.bimito.presentation.R
import com.nar.bimito.presentation.splash.SplashViewModel

class MainFragment : AbstractFragment<MainState, MainViewModel>(){

    private val mainViewModel: MainViewModel by viewModels()

    override val layoutResId: Int
        get() = R.layout.fragment_main

    override val viewModel: MainViewModel
        get() = mainViewModel

    override fun renderView(state: MainState) {
        TODO("Not yet implemented")
    }

}