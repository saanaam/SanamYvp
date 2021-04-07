package com.nar.bimito.presentation.util

import android.text.Editable
import java.util.regex.Pattern

private val persianNumbers =
    arrayOf("۰", "۱", "۲", "۳", "۴", "۵", "۶", "۷", "۸", "۹")

private val englishNumbers =
    arrayOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9")

val String.english: String
    get() {
        if (isBlank()) return ""

        val result = StringBuilder()

        forEach {
            if (it in '۰'..'۹') {
                result.append(englishNumbers[it.toString().toInt()])
            } else if (it == ',' || it == '،') result.append('٫') else result.append(it)
        }
        return result.toString()
    }

val String.plainNumber: String
    get() = replace("[^0-9۰-۹]+".toRegex(), "").trim()

val String.toEditable: Editable
    get() = Editable.Factory.getInstance().newEditable(this)

val String.currencyFormat: String
    get() {
        if (isBlank()) return ""
        return try {
            String.format("%,d", this.plainNumber.toLong())
        } catch (exception: NumberFormatException) {
            this.substring(0, this.length - 1)
        }
    }


val String.maskEndOfCard: String
    get() {
        return if (this.length > 4) {
            this.substring(this.length - 4)
        } else {
            this
        }
    }

val String.priceRialFormat: String
    get() {
        if (isBlank()) return ""
        return "${this.currencyFormat} ریال"
    }

val String.dateDayMonthFullYearFormat: String
    get() {
        val preparedString = plainNumber.english
        val result = StringBuilder()
        for (i in preparedString.indices) {
            if (i < 7 && needSeparator(i)) {
                result.append("/")
            }
            result.append(preparedString[i])
        }
        return result.toString()

    }


fun String.format(vararg args: String): String {
    return String.format(this, args)
}

fun String?.isNotNullOrEmpty(): Boolean {
    return !this.isNullOrEmpty()
}

fun String.hexStringToByteArray() =
    ByteArray(this.length / 2) { this.substring(it * 2, it * 2 + 2).toInt(16).toByte() }

fun ByteArray.toHexString() =
    joinToString("") { (0xFF and it.toInt()).toString(16).padStart(2, '0') }

private fun needSeparator(i: Int) = i % 2 == 0 && i != 0

val String.Companion.empty: String
    get() {
        return ""
    }

fun String.Companion.formatTwoDigit(value: Int): String {
    return String.format("%02d", value)
}

fun String?.containsEnglish(withNumber: Boolean = false): Boolean {
    val pattern = if (withNumber) {
        Pattern.compile(".*[a-zA-Z-1234567890]+.*")
    } else {
        Pattern.compile(".*[a-zA-Z]+.*")
    }
    return pattern.matcher(this).matches()
}

