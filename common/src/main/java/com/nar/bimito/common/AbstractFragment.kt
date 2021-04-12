package com.nar.bimito.common

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.nar.bimito.common.state.ViewState
import com.nar.bimito.common.util.showError
import com.nar.bimito.common.util.showToast
import com.nar.bimito.domain.util.isNotNull


abstract class AbstractFragment<V : ViewState, T : AbstractViewModel<V>> : Fragment() {
    @get:LayoutRes
    protected abstract val layoutResId: Int
    protected abstract val  viewModel: T
    protected lateinit var navController: NavController
    protected lateinit var activity: AbstractActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity = (super.getActivity() as AbstractActivity)
    }

    final override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutResId, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        initViews(view, savedInstanceState)
        initObservers()
    }

    protected open fun initViews(view: View, savedInstanceState: Bundle?) {

    }

    open fun initObservers() {
        viewModel.viewState.observe(viewLifecycleOwner, Observer {
            it.error?.let { errorState ->
                showError(errorState)
            }
            renderView(it)
            if (it.navigation.isNotNull()) {
                navController.navigate(it.navigation!!)
            }
        })
    }


    fun onAuthenticationError() {
        activity.authenticateAgain()
    }

    abstract fun renderView(state: V)

}