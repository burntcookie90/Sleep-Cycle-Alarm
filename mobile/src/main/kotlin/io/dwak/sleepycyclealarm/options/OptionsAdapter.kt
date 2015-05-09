package io.dwak.sleepycyclealarm.options

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import io.dwak.sleepycyclealarm
import io.dwak.sleepycyclealarm.model.Option
import java.util.ArrayList

public class OptionsAdapter(context : Context, listener : OptionsAdapter.OptionsAdapterListener) : RecyclerView.Adapter<OptionViewHolder>() {
    val optionList = ArrayList<Option>()
    val context : Context
    val listener : OptionsAdapterListener

    init {
        this.context = context
        this.listener = listener
    }

    public fun addOption(option : Option){
        optionList.add(option)
        notifyItemInserted(optionList.size())
    }

    override fun onCreateViewHolder(parent : ViewGroup?, viewType : Int) : OptionViewHolder?
            = OptionViewHolder.Companion.create(context, parent)

    override fun onBindViewHolder(holder : OptionViewHolder?, position : Int)
            = OptionViewHolder.Companion.bind(holder, optionList.get(position), position, listener)

    override fun getItemCount() : Int = optionList.size()

    public trait OptionsAdapterListener{
        fun onOptionItemSelected(position : Int)
    }
}