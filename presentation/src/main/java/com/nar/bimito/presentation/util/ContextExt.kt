package com.nar.bimito.presentation.util

import android.app.Activity
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.graphics.Typeface
import android.net.ConnectivityManager
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.*
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.azki.bimito.presentation.R

fun Context.integer(@IntegerRes resId: Int) =
    resources.getInteger(resId)

fun Context.dimenInPixel(@DimenRes resId: Int) =
    resources.getDimensionPixelSize(resId)

fun Context.color(@ColorRes resId: Int) =
    ContextCompat.getColor(this, resId)

fun Context.colorAttr(@AttrRes attrId: Int): Int {

    val typedValue = TypedValue()
    theme.resolveAttribute(attrId, typedValue, true)
    val colorResId = typedValue.resourceId
    return color(colorResId)
}

fun Context.colorStateList(@ColorRes resId: Int) =
    ContextCompat.getColorStateList(this, resId)

fun Context.string(@StringRes resId: Int): String = resources.getString(resId)

fun Context.string(@StringRes resId: Int, vararg formatArgs: Any): String =
    resources.getString(resId, *formatArgs)

fun Context.fontAttr(@AttrRes attrId: Int): Typeface {

    val typedValue = TypedValue()
    theme.resolveAttribute(attrId, typedValue, true)
    val fontResId = typedValue.resourceId
    return ResourcesCompat.getFont(this, fontResId)!!
}

fun Context.resIdFromAttr(@AttrRes attrId: Int): Int {
    val typedValue = TypedValue()
    theme.resolveAttribute(attrId, typedValue, true)
    return typedValue.resourceId
}

fun Context.drawableResId(resId: Int): Int {
    val res = resources.getResourceTypeName(resId)
    return if (res == "drawable") {
        resId
    } else {
        resIdFromAttr(resId)
    }
}

fun Context.isActivityFinishing(): Boolean {
    return this is Activity && isFinishing
}

fun Context.isActivityDestroyed(): Boolean {
    return this is Activity && isDestroyed
}

fun Context.showToast(text: String?, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, text.orEmpty(), duration).show()
}

fun Context.showToast(@StringRes resId: Int, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, resId, duration).show()
}

fun Context.hideKeyboard(v: View?) {
    val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    var view = v
    if (view == null) {
        view = View(this)
    }
    imm.hideSoftInputFromWindow(view.windowToken, 0)
}

fun Context.showKeyboard(v: View?) {
    val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    var view = v
    if (view == null) {
        view = View(this)
    }
    imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
}

fun Context.internetAvailable(): Boolean {
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetworkInfo = connectivityManager.activeNetworkInfo
    return activeNetworkInfo != null && activeNetworkInfo.isConnected
}

val Context.windowManager
    get() = getSystemService(Context.WINDOW_SERVICE) as WindowManager

val Context.layoutInflater
    get() = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

fun Context.copyToClipBoard(label: String?, text: String?) {
    val clipboardManager =
        getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val clip = ClipData.newPlainText(label, text)
    clipboardManager.primaryClip = clip
    val message = getString(R.string.all_copy_clipboard_message, label)
    showToast(message, Toast.LENGTH_LONG)
}