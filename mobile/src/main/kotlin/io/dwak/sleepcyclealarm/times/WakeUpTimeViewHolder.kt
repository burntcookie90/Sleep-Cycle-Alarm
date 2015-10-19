package io.dwak.sleepcyclealarm.times

import android.content.Context
import android.view.ViewGroup
import io.dwak.sleepcyclealarm.R
import io.dwak.sleepcyclealarm.base.DataBindingViewHolder
import io.dwak.sleepcyclealarm.databinding.WakeUpTimeItemBinding
import io.dwak.sleepcyclealarm.model.WakeUpTime
import java.text.SimpleDateFormat
import java.util.*

class WakeUpTimeViewHolder(viewDataBinding : WakeUpTimeItemBinding)
: DataBindingViewHolder<WakeUpTimeItemBinding>(viewDataBinding) {
    val timeFormat = SimpleDateFormat("hh:mm a")
    val differenceFormat = SimpleDateFormat("hh:mm")

    companion object {
        fun create(context : Context, parent : ViewGroup?) : WakeUpTimeViewHolder
                = WakeUpTimeViewHolder(DataBindingViewHolder.createViewBinding(context,
                                                                              R.layout.item_wake_up_time,
                                                                              parent) as WakeUpTimeItemBinding)

    }

    fun bind(sleepTime : Date,
             wakeupTime : WakeUpTime,
             callBack : (Date) -> Unit) {
        viewDataBinding?.timeText?.text = timeFormat.format(wakeupTime.time)
        viewDataBinding?.subtitle?.text = "${wakeupTime.cycles} ${wakeupTime.subtitle}"
        viewDataBinding?.root?.setOnClickListener { callBack.invoke(wakeupTime.time) }
    }
}