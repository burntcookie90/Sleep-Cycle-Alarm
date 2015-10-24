package io.dwak.sleepcyclealarm.view

import io.dwak.sleepcyclealarm.base.mvp.PresenterView
import io.dwak.sleepcyclealarm.model.WakeUpTime
import rx.Observable
import java.util.ArrayList
import java.util.Date

public interface WakeUpTimesView : PresenterView {
    var itemClicks : Observable<Date>?
        get

    fun showTimes(sleepTime : Date,
                  wakeupTimes : ArrayList<WakeUpTime>)

    fun setAlarm(wakeUpTime : Date)
}