package com.nar.bimito.common.util

import android.app.Activity
import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Build
import android.util.TypedValue
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import android.widget.NumberPicker
import android.widget.TextView
import androidx.annotation.*
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method
import java.util.concurrent.atomic.AtomicBoolean

fun View.hide() {
    visibility = View.GONE
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.setVisibility(visible: Boolean) {
    if (visible) show() else hide()
}

fun View.enable() {
    isEnabled = true
}

fun View.disable() {
    isEnabled = false
}

fun View.isVisible() = visibility == View.VISIBLE

fun View.isInvisible() = visibility == View.INVISIBLE

fun View.isGone() = visibility == View.GONE

fun View.integer(@IntegerRes resId: Int) =
    resources.getInteger(resId)

fun View.dimenInPixel(@DimenRes resId: Int) =
    resources.getDimensionPixelSize(resId)

fun View.color(@ColorRes resId: Int) =
    ContextCompat.getColor(this.context, resId)

fun View.string(@StringRes resId: Int): String = resources.getString(resId)

fun View.string(@StringRes resId: Int, vararg formatArgs: Any): String =
    resources.getString(resId, *formatArgs)

fun ImageView.loadFromUrl(url: String, @DrawableRes placeholder: Int = 0) {
    Glide.with(context).load(url).placeholder(placeholder).into(this)
}

fun TextView.setTextStyle(@StyleRes resId: Int) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        setTextAppearance(resId)
    } else {
        @Suppress("DEPRECATION")
        setTextAppearance(context, resId)
    }
}

fun View.setImageResourceFromAttr(@AttrRes attr: Int) {
    setImageResourceCompat(this, getResId(attr))
}

private fun View.getResId(attr: Int): Int {
    val typedValue = TypedValue()
    context.theme.resolveAttribute(attr, typedValue, true)
    return typedValue.resourceId
}


fun setImageResourceCompat(view: View, @DrawableRes drawable: Int) {
    if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT) {
        (view as? AppCompatImageView)?.setImageResource(drawable)
    } else {
        (view as? FloatingActionButton)?.setImageResource(drawable)
    }
}

fun loadFromUrlCompat(view: View, link: String, @DrawableRes placeHolder: Int = 0) {
    if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT) {
        (view as? AppCompatImageView)?.loadFromUrl(link, placeHolder)
    } else {
        (view as? FloatingActionButton)?.loadFromUrl(link, placeHolder)
    }
}


fun View.hideKeyboard() {
    val imm = this.context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(this.windowToken, 0)
}

fun View.showKeyboard() {
    val imm = this.context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
}

fun View.toBitmap(): Bitmap {

    val bitmap = Bitmap.createBitmap(
        measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888
    )
    draw(Canvas(bitmap))

    return bitmap
}

fun NumberPicker.useTextFormat() {
    this.wrapSelectorWheel = true
    try {
        val method: Method = this.javaClass
            .getDeclaredMethod("changeValueByOne", Boolean::class.javaPrimitiveType)
        method.isAccessible = true
        method.invoke(this, true)
    } catch (e: NoSuchMethodException) {
        e.printStackTrace()
    } catch (e: IllegalArgumentException) {
        e.printStackTrace()
    } catch (e: IllegalAccessException) {
        e.printStackTrace()
    } catch (e: InvocationTargetException) {
        e.printStackTrace()
    }
}

fun EditText.onNextActionClick(onAction: () -> Unit) {
    setOnEditorActionListener { _, actionId, _ ->
        if (actionId == EditorInfo.IME_ACTION_NEXT) {
            onAction.invoke()
            return@setOnEditorActionListener true
        }
        return@setOnEditorActionListener false
    }
}

fun EditText.onDoneActionClick(onAction: () -> Unit) {
    setOnEditorActionListener { _, actionId, _ ->
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            onAction.invoke()
            return@setOnEditorActionListener true
        }
        return@setOnEditorActionListener false
    }
}

fun View.setOnSingleClickListener(clickListener: ((View) -> Unit)?) {
    clickListener?.also {
        setOnClickListener(OnSingleClickListener(it))
    } ?: setOnClickListener(null)
}

class OnSingleClickListener(
    private val clickListener: (View) -> Unit,
    private val intervalMs: Long = 1000
) : View.OnClickListener {
    private var canClick = AtomicBoolean(true)

    override fun onClick(v: View?) {
        if (canClick.getAndSet(false)) {
            v?.run {
                postDelayed({
                    canClick.set(true)
                }, intervalMs)
                clickListener.invoke(v)
            }
        }
    }
}