package com.sanam.yavarpour.common.util

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
import com.sanam.yavarpour.common.R

fun Context.color(@ColorRes resId: Int) =
    ContextCompat.getColor(this, resId)

fun Context.colorAttr(@AttrRes attrId: Int): Int {

    val typedValue = TypedValue()
    theme.resolveAttribute(attrId, typedValue, true)
    val colorResId = typedValue.resourceId
    return color(colorResId)
}

fun Context.string(@StringRes resId: Int): String = resources.getString(resId)

fun Context.string(@StringRes resId: Int, vararg formatArgs: Any): String =
    resources.getString(resId, *formatArgs)

fun Context.showToast(text: String?, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, text.orEmpty(), duration).show()
}

