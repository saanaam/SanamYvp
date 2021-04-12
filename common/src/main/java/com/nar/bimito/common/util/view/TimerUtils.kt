package com.nar.bimito.common.util.view

import android.content.Context
import android.os.CountDownTimer
import android.widget.TextView
import com.nar.bimito.common.util.empty
import com.nar.bimito.common.R
import java.util.concurrent.TimeUnit

const val DEFAULT_TIME_OUT: Long = 120_000
const val DEFAULT_INTERVAL: Long = 1_000


enum class TimerState {
    FINISHED,
    STARTED
}

data class TimerConfig(val timeout: Long, val interval: Long)


class TimerUtils(
    private val displayView: TextView,
    private val timerConfig: TimerConfig = TimerConfig(DEFAULT_TIME_OUT, DEFAULT_INTERVAL),
    private val timeStyle: Int = R.string.timer_format
) {

    var isStarted: Boolean = false
    private val context: Context = displayView.context
    private var stateChange = false
    private var counter: CountDownTimer? = null
    fun start(stateListener: ((TimerState) -> Unit)? = null) {
        stateChange = true
        counter = object : CountDownTimer(timerConfig.timeout, timerConfig.interval) {
            override fun onFinish() {
                stateChange = true
                isStarted = false
                stateListener?.invoke(TimerState.FINISHED)
                displayView.text = context.getString(timeStyle, String.empty)
            }

            override fun onTick(millisUntilFinished: Long) {
                isStarted = true
                if (stateChange) {
                    stateListener?.invoke(TimerState.STARTED)
                    stateChange = false
                }
                val minute = TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)
                val second = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - (minute * 60)
                displayView.text = context.getString(
                    timeStyle,
                    context.getString(R.string.timer_format)
                        .format(minute, second)
                )
            }
        }
        counter?.start()
    }

    fun stop() {
        counter?.cancel()
    }
}

