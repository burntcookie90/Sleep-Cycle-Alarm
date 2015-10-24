package io.dwak.sleepcyclealarm.times

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.bindView
import com.jakewharton.rxbinding.view.clicks
import io.dwak.sleepcyclealarm.R
import io.dwak.sleepcyclealarm.model.WakeUpTime
import rx.Observable
import rx.subjects.PublishSubject
import java.text.SimpleDateFormat
import java.util.*

class WakeUpTimeViewHolder(val view : View) : RecyclerView.ViewHolder(view){
    val timeFormat = SimpleDateFormat("hh:mm a")
    val differenceFormat = SimpleDateFormat("hh:mm")
    val timeText : TextView by bindView(R.id.time_text)
    val subtitle: TextView by bindView(R.id.subtitle)

    companion object {
        fun create(context : Context, parent : ViewGroup?) : WakeUpTimeViewHolder {
            return WakeUpTimeViewHolder(LayoutInflater.from(context).inflate(R.layout.item_wake_up_time, parent, false));
        }

    }

    fun bind(sleepTime : Date,
             wakeupTime : WakeUpTime,
             callBack : PublishSubject<Date>) {
        timeText.text = timeFormat.format(wakeupTime.time)
        subtitle.text = "${wakeupTime.cycles} ${wakeupTime.subtitle}"
        itemView.clicks().subscribe { callBack.onNext(wakeupTime.time) }
    }
}