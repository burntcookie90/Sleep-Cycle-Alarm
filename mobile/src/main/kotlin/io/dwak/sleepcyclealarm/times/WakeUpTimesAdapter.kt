package io.dwak.sleepcyclealarm.times

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import io.dwak.sleepcyclealarm.model.WakeUpTime
import rx.Observable
import rx.Subscription
import rx.subjects.PublishSubject
import java.util.ArrayList
import java.util.Date

class WakeUpTimesAdapter(val context : Context)
: RecyclerView.Adapter<WakeUpTimeViewHolder>() {
    val items = ArrayList<WakeUpTime>()
    lateinit var sleepTime : Date
    private val clicks = PublishSubject.create<Date>()
    private var clickSubscription : Subscription? = null
    val observable : Observable<Date>
        get() = clicks.asObservable()


    fun addTime(wakeUpTime : WakeUpTime) {
        items.add(wakeUpTime)
        notifyItemInserted(itemCount)
    }

    override fun onCreateViewHolder(parent : ViewGroup?, viewType : Int) : WakeUpTimeViewHolder?
            = WakeUpTimeViewHolder.create(context, parent)

    override fun onBindViewHolder(holder : WakeUpTimeViewHolder?, position : Int) {
        holder?.bind(sleepTime, items[position], clicks);
    }

    override fun getItemCount() : Int = items.size

    fun subscribe(onNext : (Date) -> Unit) {
        clickSubscription = observable.subscribe(onNext)
    }

    fun unubscribe() {
        clickSubscription?.unsubscribe()
    }
}