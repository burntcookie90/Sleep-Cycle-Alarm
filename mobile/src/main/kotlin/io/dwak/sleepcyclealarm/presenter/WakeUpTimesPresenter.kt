package io.dwak.sleepcyclealarm.presenter

import io.dwak.sleepcyclealarm.base.mvp.Presenter
import java.util.Date

public interface WakeUpTimesPresenter : Presenter {
    var isSleepNow : Boolean?
    var sleepTime : Date

    fun getTimes()

    fun wakeUpTimeSelected(selectedWakeUpTime : Date)
}