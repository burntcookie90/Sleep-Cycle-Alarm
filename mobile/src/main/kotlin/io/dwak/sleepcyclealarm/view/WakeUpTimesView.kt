package io.dwak.sleepcyclealarm.view

import java.util.*

public interface WakeUpTimesView {
    fun showTimes(sleepTime : Date,
                  wakeupTimes : ArrayList<Date>)

    fun setAlarm(wakeUpTime : Date)
}