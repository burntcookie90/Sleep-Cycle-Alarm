package io.dwak.sleepcyclealarm.options

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import io.dwak.sleepcyclealarm.model.Option
import java.util.ArrayList

public class OptionsAdapter(context : Context, onClick : (Int) -> Unit?) : RecyclerView.Adapter<OptionViewHolder>() {
    val optionList = ArrayList<Option>()
    private val context = context;
    private val onClick = onClick

    public fun addOption(option : Option) {
        optionList.add(option)
        notifyItemInserted(optionList.size())
    }

    override fun onCreateViewHolder(parent : ViewGroup?, viewType : Int) : OptionViewHolder?
            = OptionViewHolder.Companion.create(context, parent)

    override fun onBindViewHolder(holder : OptionViewHolder?, position : Int)
            = OptionViewHolder.Companion.bind(viewHolder = holder,
                                              option = optionList.get(position),
                                              position = position,
                                              callback = onClick)

    override fun getItemCount() : Int = optionList.size()

}