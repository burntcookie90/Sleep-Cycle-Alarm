package io.dwak.sleepcyclealarm.base.databinding

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.LayoutInflater
import android.view.ViewGroup

open class DataBindingViewHolder<T : ViewDataBinding>(itemView : View?)
: RecyclerView.ViewHolder(itemView) {
    companion object {
        fun createViewBinding(context : Context,
                                  @LayoutRes layoutResId : Int,
                                  parent : ViewGroup?) : ViewDataBinding {
            return DataBindingUtil.inflate(LayoutInflater.from(context), layoutResId, parent, false)
        }
    }

    var viewDataBinding : T? = null
        get

    constructor(viewDataBinding : T) : this(viewDataBinding.root) {
        this.viewDataBinding = viewDataBinding
    }
}