package io.dwak.sleepcyclealarm.times

import io.dwak.sleepcyclealarm.base.mvp.AbstractPresenter
import io.dwak.sleepcyclealarm.extension.addHours
import io.dwak.sleepcyclealarm.extension.addMinutes
import io.dwak.sleepcyclealarm.extension.fromDate
import io.dwak.sleepcyclealarm.model.WakeUpTime
import io.dwak.sleepcyclealarm.presenter.WakeUpTimesPresenter
import io.dwak.sleepcyclealarm.view.WakeUpTimesView
import rx.Subscription
import java.util.*

class WakeUpTimesPresenterImpl(view : WakeUpTimesView) : AbstractPresenter<WakeUpTimesView>(view),
                                                         WakeUpTimesPresenter {
    lateinit override var sleepTime : Date
    override var isSleepNow : Boolean? = false
        set(value) {
            field = value
            if (field!!) {
                sleepTime = Calendar.getInstance().time
            }
        }
    var wakeupTimeList : ArrayList<WakeUpTime>? = null
    val numberOfWakeUpTimes = 7

    override fun onAttachToView() {
        super.onAttachToView()
        subscriptions.add(view.itemClicks?.subscribe { wakeUpTimeSelected(it) })
    }

    override fun getTimes() {
        when (wakeupTimeList) {
            null -> {
                val sleepTime = Calendar.getInstance().fromDate(this.sleepTime)
                sleepTime.addMinutes(14)
                wakeupTimeList = ArrayList<WakeUpTime>(numberOfWakeUpTimes)

                for (i in 0..numberOfWakeUpTimes - 1) {
                    with(sleepTime){
                        addHours(1)
                        addMinutes(30)
                    }
                    wakeupTimeList?.add(WakeUpTime(i + 1, "blah", sleepTime.time))
                }
                view.showTimes(this.sleepTime, wakeupTimeList!!)
            }
            else -> {
                return
            }
        }

    }

    override fun wakeUpTimeSelected(selectedWakeUpTime : Date) {
        view.setAlarm(selectedWakeUpTime)
    }

}