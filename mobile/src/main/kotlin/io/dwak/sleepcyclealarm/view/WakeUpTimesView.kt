package io.dwak.sleepcyclealarm.view

import io.dwak.sleepcyclealarm.base.mvp.PresenterView
import io.dwak.sleepcyclealarm.model.WakeUpTime
import java.util.*

public interface WakeUpTimesView : PresenterView {
    fun showTimes(sleepTime : Date,
                  wakeupTimes : ArrayList<WakeUpTime>)

    fun setAlarm(wakeUpTime : Date)
}