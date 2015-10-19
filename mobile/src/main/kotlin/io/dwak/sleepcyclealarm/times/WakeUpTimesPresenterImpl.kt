package io.dwak.sleepcyclealarm.times

import io.dwak.mvp_base.AbstractPresenter
import io.dwak.sleepcyclealarm.presenter.WakeUpTimesPresenter
import io.dwak.sleepcyclealarm.view.WakeUpTimesView
import java.util.*

class WakeUpTimesPresenterImpl : AbstractPresenter<WakeUpTimesView>(), WakeUpTimesPresenter {
    lateinit var sleepTime : Date
    var wakeupTimeList : ArrayList<Date>? = null
    val numberOfWakeUpTimes = 5
    var isSleepNow : Boolean? = false
        set(value) {
            field = value
            if (isSleepNow!!) {
                sleepTime = Calendar.getInstance().time
            }
        }

    override fun getTimes() {
        if(wakeupTimeList != null){
            return
        }

        val sleepTime = Calendar.getInstance()
        sleepTime.time = this.sleepTime
        sleepTime.add(Calendar.MINUTE, 14)
        wakeupTimeList = ArrayList<Date>(numberOfWakeUpTimes)

        for (i in 0..numberOfWakeUpTimes - 1) {
            sleepTime.add(Calendar.HOUR, 1)
            sleepTime.add(Calendar.MINUTE, 30)
            wakeupTimeList?.add(sleepTime.time)
        }
        view.showTimes(this.sleepTime, wakeupTimeList!!)
    }

    override fun wakeUpTimeSelected(selectedWakeUpTime : Date) {
        view.setAlarm(selectedWakeUpTime)
    }

}