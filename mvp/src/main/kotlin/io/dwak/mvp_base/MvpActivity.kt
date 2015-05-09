package io.dwak.meh.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlin.properties.Delegates

public abstract class MvpActivity<T : AbstractPresenter<*>> : AppCompatActivity() {
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