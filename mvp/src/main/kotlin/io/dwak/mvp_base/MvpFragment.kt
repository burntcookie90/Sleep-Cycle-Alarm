package io.dwak.mvp_base

import android.os.Bundle
import android.support.v4.app.Fragment
import io.dwak.meh.base.AbstractPresenter
import kotlin.properties.Delegates

public abstract class MvpFragment<T : AbstractPresenter<*>> : Fragment() {
    val presenter : T by Delegates.lazy {
        presenterClass.newInstance()
    }

    abstract val presenterClass : Class<T>
    abstract fun setView()

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setView()
    }
}