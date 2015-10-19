package io.dwak.sleepcyclealarm.presenter

import java.util.*

public interface WakeUpTimesPresenter {
    fun getTimes()

    fun wakeUpTimeSelected(selectedWakeUpTime : Date)
}