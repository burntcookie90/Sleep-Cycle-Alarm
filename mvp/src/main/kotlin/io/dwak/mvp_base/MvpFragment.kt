package io.dwak.mvp_base

import android.os.Bundle
import android.support.v4.app.Fragment

public abstract class MvpFragment<T : AbstractPresenter<*>> : Fragment() {
    val presenter : T by lazy() {
        presenterClass.newInstance()
    }

    abstract val presenterClass : Class<T>
    abstract fun setView()

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setView()
    }
}