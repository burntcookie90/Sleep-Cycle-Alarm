package io.dwak.sleepcyclealarm.base.mvp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.dwak.sleepcyclealarm.base.mvp.AbstractPresenter
import javax.inject.Inject

public abstract class MvpActivity<T : Presenter> : AppCompatActivity(), DaggerPresenterView {
    protected lateinit var presenter : T
        @Inject set

    abstract override fun inject()

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
        presenter.prepareToAttachToView()
    }

    override fun onResume() {
        super.onResume()
        presenter.onAttachToView()
    }

    override fun onPause() {
        super.onPause()
        presenter.onDetachFromView()
    }
}