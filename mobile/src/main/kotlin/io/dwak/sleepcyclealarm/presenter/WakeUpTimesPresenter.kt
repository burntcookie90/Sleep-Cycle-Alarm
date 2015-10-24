package io.dwak.sleepcyclealarm.presenter

import io.dwak.sleepcyclealarm.base.mvp.Presenter
import io.dwak.sleepcyclealarm.view.WakeUpTimesView
import java.util.*

public interface WakeUpTimesPresenter : Presenter {
    var isSleepNow : Boolean?
    var sleepTime : Date

    fun getTimes()

    fun wakeUpTimeSelected(selectedWakeUpTime : Date)
}