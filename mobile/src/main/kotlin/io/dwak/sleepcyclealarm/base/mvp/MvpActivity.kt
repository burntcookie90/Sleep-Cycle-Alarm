package io.dwak.sleepcyclealarm.base.mvp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.dwak.sleepcyclealarm.base.mvp.AbstractPresenter
import javax.inject.Inject

public abstract class MvpActivity<T : AbstractPresenter<*>> : AppCompatActivity() {
    protected lateinit var presenter : T
        @Inject set

    abstract fun setView()

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setView()
    }
}