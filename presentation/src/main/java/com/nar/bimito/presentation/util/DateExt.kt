package com.nar.bimito.presentation.util

import android.text.format.DateUtils
import com.nar.bimito.R
import com.nar.bimito.presentation.exception.PresentationRuntimeException
import net.time4j.*
import net.time4j.calendar.PersianCalendar
import net.time4j.format.expert.ChronoFormatter
import net.time4j.format.expert.PatternType
import net.time4j.format.expert.SignPolicy
import net.time4j.tz.Timezone
import net.time4j.tz.olson.ASIA
import java.lang.Exception
import java.util.*
import kotlin.jvm.Throws


/** Glossary of Date extensions.
 * Parse : parse input to displayable string
 * Translate : translate UTC long format to some output
 * Convert : translate input to UTC in long format
 * */

fun DateUtils.nowTimestamp(): Long {
    return TemporalType.MILLIS_SINCE_UNIX.from(PlainTimestamp.nowInSystemTime().`in`(getTimeZone()))
}

fun DateUtils.getMaxValidDay(month: Int, year: Int): Int {
    val persianCalendar = PersianCalendar.of(year, month, 1)
    return when {
        persianCalendar.isLeapYear && month == 12 -> {
            30
        }
        month in 7..11 -> {
            30
        }
        month == 12 -> {
            29
        }
        else -> {
            31
        }
    }

}

fun DateUtils.parseDate(timestamp: Long = nowTimestamp(), locale: Locale = PERSIAN_LOCALE): String {
    val translate = TemporalType.MILLIS_SINCE_UNIX.translate(timestamp)
    val plainTimestamp = translate.toLocalTimestamp()
    val calendarDate = plainTimestamp.calendarDate
    val persianCalendar = calendarDate.transform(
        PersianCalendar::class.java
    )
    val formatter =
        ChronoFormatter.setUp(PersianCalendar.axis(), locale)
            .addPattern("yyyy/MM/dd", PatternType.CLDR_DATE)
            .build()
    return formatter.format(persianCalendar)
}

fun DateUtils.parseFullDate(
    timestamp: Long = nowTimestamp(),
    locale: Locale = PERSIAN_LOCALE
): String {
    val translate = TemporalType.MILLIS_SINCE_UNIX.translate(timestamp)
    val plainTimestamp = translate.toLocalTimestamp()
    val calendarDate = plainTimestamp.calendarDate
    val persianCalendar = calendarDate.transform(
        PersianCalendar::class.java
    )
    val formatter =
        ChronoFormatter.setUp(PersianCalendar.axis(), locale)
            .addInteger(PersianCalendar.DAY_OF_MONTH, 2, 3)
            .addLiteral(" ")
            .addText(PersianCalendar.MONTH_OF_YEAR)
            .addLiteral(" ")
            .addInteger(PersianCalendar.YEAR_OF_ERA, 4, 5)
            .build()
    return formatter.format(persianCalendar)
}

fun DateUtils.parseTime(timestamp: Long, locale: Locale = PERSIAN_LOCALE): String {
    val moment = TemporalType.MILLIS_SINCE_UNIX.translate(timestamp)
    val wallTime = moment.toLocalTimestamp().wallTime
    val formatter =
        ChronoFormatter.setUp(PlainTime.axis(), locale)
            .addPattern("HH:mm", PatternType.CLDR_24)
            .build()
    return formatter.format(wallTime)
}

val DateUtils.PERSIAN_LOCALE: Locale
    get() = Locale("fa")


private fun getTimeZone(): Timezone? {
    return Timezone.of(ASIA.TEHRAN.canonical())
}

fun DateUtils.translate(timestamp: Long = nowTimestamp()): Triple<Int, Int, Int> {
    val translate = TemporalType.MILLIS_SINCE_UNIX.translate(timestamp)
    val plainTimestamp = translate.toLocalTimestamp()
    val calendarDate = plainTimestamp.calendarDate
    val persianCalendar = calendarDate.transform(
        PersianCalendar::class.java
    )
    return Triple(persianCalendar.dayOfMonth, persianCalendar.month.value, persianCalendar.year)
}


@Throws(PresentationRuntimeException::class)
fun DateUtils.convert(day: Int, month: Int, year: Int): Long {
    try {
        val persianCalendar = PersianCalendar.of(year, month, day)
        val date = persianCalendar.transform(PlainDate::class.java)
        return TemporalType.MILLIS_SINCE_UNIX.from(date.atFirstMoment(ASIA.TEHRAN))
    } catch (exception: Exception) {
        throw PresentationRuntimeException(R.string.exception_invalid_perisan_date_message)
    }
}


fun DateUtils.convertGregorian(dateTime: String): Long {
    val formatter: ChronoFormatter<Moment> =
        ChronoFormatter.ofMomentPattern(
            "MM/dd/uuuu HH:mm:ss",
            PatternType.CLDR,
            Locale.US,
            ASIA.TEHRAN
        );
    val result = ZonalDateTime.parse(dateTime, formatter)
    return TemporalType.MILLIS_SINCE_UNIX.from(result.toMoment())
}




