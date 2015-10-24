package io.dwak.sleepcyclealarm.base.mvp

import android.os.Bundle
import android.support.v4.app.Fragment
import io.dwak.sleepcyclealarm.dagger.component.DaggerPresenterComponent
import io.dwak.sleepcyclealarm.dagger.module.PresenterModule
import io.dwak.sleepcyclealarm.dagger.scope.ViewScope
import javax.inject.Inject

public abstract class MvpFragment<T : Presenter> : Fragment(), DaggerPresenterView{
    protected lateinit var presenter : T
        @Inject set

    abstract fun inject()

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
    }
}