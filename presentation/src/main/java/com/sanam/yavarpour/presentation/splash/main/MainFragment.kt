package com.sanam.yavarpour.presentation.splash.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.sanam.yavarpour.common.AbstractFragment
import com.sanam.yavarpour.common.util.showToast
import com.sanam.yavarpour.presentation.R
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
            showToast(it.Singer)
        }
    }


}