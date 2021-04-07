package com.nar.bimito.presentation.util

import android.content.Context
import android.os.CountDownTimer
import com.nar.bimito.presentation.R

const val DEFAULT_TIME_OUT: Long = 60
const val DEFAULT_INTERVAL: Long = 1


enum class TimerState {
    FINISHED,
    STARTED
}

data class TimerConfig(val timeoutSec: Long, val intervalSec: Long)


class PutTimer(
    private val context: Context,
    private val timerConfig: TimerConfig = TimerConfig(DEFAULT_TIME_OUT, DEFAULT_INTERVAL)
) {

    var displayTime: String = ""

    private var stateChange = false

    fun start(stateListener: ((TimerState) -> Unit)? = null, onTick: ((String) -> Unit)? = null) {
        stateChange = true
        object : CountDownTimer(timerConfig.timeoutSec * 1000, timerConfig.intervalSec * 1000) {
            override fun onFinish() {
                stateChange = true
                displayTime = ""
                stateListener?.invoke(TimerState.FINISHED)
            }

            override fun onTick(millisUntilFinished: Long) {

                displayTime =
                    context.string(
                        R.string.timer_format,
                        minute(millisUntilFinished),
                        second(millisUntilFinished)
                    )
                if (stateChange) {
                    stateListener?.invoke(TimerState.STARTED)
                    stateChange = false
                }
                onTick?.invoke(displayTime)
            }
        }.start()
    }

    private fun minute(millis: Long): Long {
        return (millis / 1_000) / 60
    }

    private fun second(millis: Long): Long {
        return (millis / 1_000) % 60
    }
}