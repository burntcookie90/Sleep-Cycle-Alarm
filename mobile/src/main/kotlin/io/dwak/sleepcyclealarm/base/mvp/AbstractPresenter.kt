package io.dwak.sleepcyclealarm.base.mvp

import io.dwak.sleepcyclealarm.dagger.component.InteractorComponent
import io.dwak.sleepcyclealarm.interactor.LoggingInteractor
import rx.Subscription
import java.util.ArrayList
import javax.inject.Inject

public abstract class AbstractPresenter<T : PresenterView>(val view : T, override val interactorComponent : InteractorComponent) : DaggerPresenter {
    val subscriptions = ArrayList<Subscription?>()
    protected lateinit var logger : LoggingInteractor
        @Inject set

    abstract override fun inject()
}