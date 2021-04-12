package com.nar.bimito.common.util

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.google.android.material.snackbar.Snackbar
import com.nar.bimito.common.R
import com.nar.bimito.common.state.ErrorState


fun Activity.showSnackbar(message: String) {

    val view = findViewById<View>(android.R.id.content).rootView
    Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show()
}

fun Activity.hideKeyboard() {
    val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    var view = currentFocus
    if (view == null) {
        view = View(this)
    }
    imm.hideSoftInputFromWindow(view.windowToken, 0)
}

fun Activity.showKeyboard() {
    val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    var view = currentFocus
    if (view == null) {
        view = View(this)
    }
    imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
}

inline fun <reified T : Activity> Activity.startActivity() {
    val intent = Intent()
    intent.setClass(this, T::class.java)
    startActivity(intent)
}

fun Activity.showError(error: ErrorState) {
    val title = error.errorTitle?.let {
        getString(it)
    } ?: getString(R.string.all_error_happens)

    val message = error.extraInfo?.let {
        "${error.message} \n ${getString(error.extraInfo)}"
    } ?: error.message

}

inline fun <reified T : Activity> Activity.startActivity(options: Bundle?) {
    val intent = Intent()
    intent.setClass(this, T::class.java)
    startActivity(intent, options)
}


inline fun <reified T : Activity> Activity.startActivity(flags: Int) {
    val intent = Intent()
    intent.setClass(this, T::class.java)
    intent.flags = flags
    startActivity(intent)
}
