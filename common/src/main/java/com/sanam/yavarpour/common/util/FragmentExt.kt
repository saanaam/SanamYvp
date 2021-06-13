package com.sanam.yavarpour.common.util

import android.app.Activity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.sanam.yavarpour.common.state.ErrorState
import java.lang.IllegalStateException


fun Fragment.showToast(text: String?, duration: Int = Toast.LENGTH_SHORT) {
    context?.showToast(text, duration)
}

fun Fragment.showSnackbar(message: String) {
    this.view?.let {
        Snackbar.make(it, message, Snackbar.LENGTH_SHORT).show()
    }
}

fun Fragment.showError(error: ErrorState, onApplyClicked: (() -> Unit)? = null) {
    showSnackbar(error.message)
}
