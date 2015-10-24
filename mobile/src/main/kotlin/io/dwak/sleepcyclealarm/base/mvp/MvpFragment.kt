package io.dwak.sleepcyclealarm.base.mvp

import android.os.Bundle
import android.support.v4.app.Fragment
import io.dwak.sleepcyclealarm.dagger.component.DaggerPresenterComponent
import io.dwak.sleepcyclealarm.dagger.module.PresenterModule
import javax.inject.Inject

public abstract class MvpFragment<T : Presenter> : Fragment() {
    protected lateinit var presenter : T
        @Inject set

    protected val presenterComponentBuilder : DaggerPresenterComponent.Builder
        get() {
            return DaggerPresenterComponent.builder()
        }

    abstract fun setView()

    abstract fun inject()

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
//        setView()
    }
}