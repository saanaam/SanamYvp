package com.sanam.yavarpour.common.util

import android.text.Editable
import java.util.regex.Pattern


val String.maskEndOfCard: String
    get() {
        return if (this.length > 4) {
            this.substring(this.length - 4)
        } else {
            this
        }
    }


val String.Companion.empty: String
    get() {
        return ""
    }


