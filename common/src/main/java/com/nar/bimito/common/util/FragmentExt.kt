package com.nar.bimito.common.util

import android.app.Activity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.nar.bimito.common.state.ErrorState
import java.lang.IllegalStateException


fun Fragment.showToast(text: String?, duration: Int = Toast.LENGTH_SHORT) {
    context?.showToast(text, duration)
}

fun Fragment.showToast(@StringRes resId: Int, duration: Int = Toast.LENGTH_SHORT) {
    showToast(getString(resId), duration)
}

fun Fragment.showSnackbar(message: String) {
    this.view?.let {
        Snackbar.make(it, message, Snackbar.LENGTH_SHORT).show()
    }
}

fun Fragment.hideKeyboard() {
    val imm = context?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager?
    var view = view
    if (view == null) {
        view = View(context)
    }
    imm?.hideSoftInputFromWindow(view.windowToken, 0)
}

fun Fragment.showError(error: ErrorState, onApplyClicked: (() -> Unit)? = null) {
    throw IllegalStateException("error view not implemented")
}

fun Fragment.showKeyboard() {
    val imm = context?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager?
    var view = view
    if (view == null) {
        view = View(context)
    }
    imm?.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
}

fun Fragment.finish() {
    activity?.run { finish() }
}

fun Fragment.internetAvailable() {
    context?.internetAvailable()
}