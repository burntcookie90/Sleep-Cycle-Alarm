package io.dwak.sleepcyclealarm.base.databinding

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.ViewGroup
import io.dwak.sleepcyclealarm.dagger.scope.ViewScope
import io.dwak.sleepcyclealarm.base.mvp.MvpFragment
import io.dwak.sleepcyclealarm.base.mvp.Presenter

@ViewScope
public abstract class DataBindingMvpFragment<T : Presenter, V : ViewDataBinding> : MvpFragment<T>() {
    protected lateinit var viewBinding : V
        get

    protected fun createViewBinding(inflater : LayoutInflater?,
                                    @LayoutRes layoutResId : Int,
                                    parent : ViewGroup?) {
        viewBinding = DataBindingUtil.inflate<V>(inflater!!, layoutResId, parent!!, false)
    }
}