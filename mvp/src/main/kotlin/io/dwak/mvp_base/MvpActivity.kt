package io.dwak.mvp_base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.dwak.mvp_base.AbstractPresenter

public abstract class MvpActivity<T : AbstractPresenter<*>> : AppCompatActivity() {
    val presenter : T by lazy{
        presenterClass.newInstance()
    }

    abstract val presenterClass : Class<T>
    abstract fun setView()

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setView()
    }
}