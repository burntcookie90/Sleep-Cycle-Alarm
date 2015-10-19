package io.dwak.sleepcyclealarm.times

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import java.util.*

class WakeUpTimesAdapter(val context : Context, val onClick : (Date) -> Unit)
: RecyclerView.Adapter<WakeUpTimeViewHolder>() {
    val items = ArrayList<Date>()
    lateinit var sleepTime : Date

    fun addTime(date : Date){
        items.add(date)
        notifyItemInserted(itemCount)
    }

    override fun onCreateViewHolder(parent : ViewGroup?, viewType : Int) : WakeUpTimeViewHolder?
            = WakeUpTimeViewHolder.create(context, parent)

    override fun onBindViewHolder(holder : WakeUpTimeViewHolder?, position : Int) {
        holder?.bind(sleepTime, items[position], onClick);
    }

    override fun getItemCount() : Int = items.size()
}