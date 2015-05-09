package io.dwak.sleepycyclealarm.options

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.bindView
import io.dwak.sleepcyclealarm.R
import io.dwak.sleepycyclealarm.model.Option
import kotlinx.android.anko.onClick
import kotlinx.android.anko.text

public class OptionViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView : View) {
    val name : TextView by bindView(R.id.option_name)

    companion object {
        fun create(context : Context, parent : ViewGroup?) : OptionViewHolder{
            return OptionViewHolder(LayoutInflater.from(context).inflate(R.layout.item_option, parent, false))
        }

        fun bind(viewHolder : OptionViewHolder?, option : Option, position : Int, optionsAdapterListener : OptionsAdapter.OptionsAdapterListener){
            viewHolder?.name?.text = option.description
            viewHolder?.itemView?.onClick { optionsAdapterListener.onOptionItemSelected(position) }
        }
    }
}