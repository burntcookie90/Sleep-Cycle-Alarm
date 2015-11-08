package io.dwak.sleepcyclealarm.view

import io.dwak.sleepcyclealarm.base.mvp.PresenterView
import io.dwak.sleepcyclealarm.model.WakeUpTime
import rx.Observable
import java.util.Date

public interface WakeUpTimesView : PresenterView {
    var itemClicks : Observable<Date>?
        get

    fun showTimes(sleepTime : Date,
                  wakeupTimes : List<WakeUpTime>)

    fun setAlarm(wakeUpTime : Date)
}