package io.dwak.sleepcyclealarm.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.ViewGroup
import io.dwak.mvp_base.AbstractPresenter
import io.dwak.mvp_base.MvpFragment

public abstract class DataBindingMvpFragment<T : AbstractPresenter<*>, V : ViewDataBinding> : MvpFragment<T>() {
    lateinit var viewBinding : V
        get

    protected fun createViewBinding(inflater : LayoutInflater,
                                    @LayoutRes layoutResId : Int,
                                    parent : ViewGroup) {
        viewBinding = DataBindingUtil.inflate<V>(inflater, layoutResId, parent, false)
    }
}