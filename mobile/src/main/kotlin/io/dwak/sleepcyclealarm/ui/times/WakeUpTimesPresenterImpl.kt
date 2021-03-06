package io.dwak.sleepcyclealarm.ui.times

import io.dwak.sleepcyclealarm.base.mvp.AbstractPresenter
import io.dwak.sleepcyclealarm.dagger.component.InteractorComponent
import io.dwak.sleepcyclealarm.dagger.scope.PresenterScope
import io.dwak.sleepcyclealarm.extension.fromDate
import io.dwak.sleepcyclealarm.extension.hour
import io.dwak.sleepcyclealarm.extension.minute
import io.dwak.sleepcyclealarm.model.WakeUpTime
import io.dwak.sleepcyclealarm.presenter.WakeUpTimesPresenter
import io.dwak.sleepcyclealarm.view.WakeUpTimesView
import java.util.ArrayList
import java.util.Calendar
import java.util.Date

open class WakeUpTimesPresenterImpl(view : WakeUpTimesView, interactorComponent : InteractorComponent)
: AbstractPresenter<WakeUpTimesView>(view, interactorComponent), WakeUpTimesPresenter {
    override fun inject() {
        interactorComponent.inject(this)
    }

    lateinit override var sleepTime : Date
    override var isSleepNow : Boolean? = false
        set(value) {
            field = value
            logger.debug("WakeUpTimesPresenter", "isSleepNow : $field")
            if (field!!) {
                sleepTime = Calendar.getInstance().time
            }
        }
    var wakeupTimeList : ArrayList<WakeUpTime>? = null
    val numberOfWakeUpTimes = 7

    override fun onAttachToView() {
        super.onAttachToView()
        viewSubscription.add(view.itemClicks?.subscribe { wakeUpTimeSelected(it) })
    }

    override fun getTimes() {
        when (wakeupTimeList) {
            null -> {
                val sleepTime = Calendar.getInstance().fromDate(this.sleepTime)
                sleepTime.minute += 14
                wakeupTimeList = ArrayList<WakeUpTime>(numberOfWakeUpTimes)

                for (i in 0..numberOfWakeUpTimes - 1) {
                    with(sleepTime) {
                        hour += 1
                        minute += 30
                    }
                    wakeupTimeList?.add(WakeUpTime(i + 1, "Cycles", sleepTime.time))
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