package dev.jakubzika.worktracker.viewmodel

import android.os.Handler
import android.os.SystemClock
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TimerViewModel : ViewModel() {

    val timeLiveData = MutableLiveData<Time>()

    private var seconds: Long = 0
    private var minutes: Long = 0
    private var hours: Long = 0

    private var startTime: Long = 0
    private var millisecondTime: Long = 0
    private var updateTime: Long = 0
    private var timeBuff: Long = 0

    private val handler: Handler = Handler()
    private val runnable: Runnable = Runnable {
        millisecondTime = SystemClock.uptimeMillis() - startTime;
        updateTime = timeBuff + millisecondTime
        seconds = updateTime / 1000
        minutes = seconds / 60
        hours = minutes / 60
        seconds %= 60

        // update time
        updateTime(hours, minutes, seconds)
    }

    fun timerStart() {
        startTime = SystemClock.uptimeMillis()
        handler.postDelayed(runnable, 0)
    }

    fun timerStop() {
        timeBuff += millisecondTime
        handler.removeCallbacks(runnable)
    }

    fun timerReset() {
        millisecondTime = 0L
        startTime = 0L
        timeBuff = 0L
        updateTime = 0L
        seconds = 0
        minutes = 0
        hours = 0

        setTime(hours, minutes, seconds)
    }

    private fun updateTime(hours: Long, minutes: Long, seconds: Long) {
        setTime(hours, minutes, seconds)
        handler.postDelayed(runnable, 0)
    }

    private fun setTime(hours: Long, minutes: Long, seconds: Long) {
        timeLiveData.value = Time(hours, minutes, seconds)
    }

}

data class Time (
    var hours: Long,
    var minutes: Long,
    var seconds: Long
)