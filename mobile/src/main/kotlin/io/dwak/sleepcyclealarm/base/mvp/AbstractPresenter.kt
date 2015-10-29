package io.dwak.sleepcyclealarm.base.mvp

import io.dwak.sleepcyclealarm.dagger.component.DaggerInteractorComponent
import io.dwak.sleepcyclealarm.interactor.LoggingInteractor
import rx.Subscription
import java.util.ArrayList
import javax.inject.Inject

public abstract class AbstractPresenter<T : PresenterView>(val view : T) : DaggerPresenter{
    val subscriptions = ArrayList<Subscription?>()
    protected lateinit var logger : LoggingInteractor
        @Inject set

    abstract override fun inject()
}