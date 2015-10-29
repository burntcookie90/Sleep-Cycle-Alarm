package io.dwak.sleepcyclealarm.options

import io.dwak.sleepcyclealarm.base.mvp.AbstractPresenter
import io.dwak.sleepcyclealarm.dagger.component.DaggerInteractorComponent
import io.dwak.sleepcyclealarm.dagger.component.InteractorComponent
import io.dwak.sleepcyclealarm.dagger.module.InteractorModule
import io.dwak.sleepcyclealarm.dagger.scope.PresenterScope
import io.dwak.sleepcyclealarm.extension.debounceDefault
import io.dwak.sleepcyclealarm.interactor.LoggingInteractor
import io.dwak.sleepcyclealarm.presenter.OptionsPresenter
import io.dwak.sleepcyclealarm.util.LumberJack
import io.dwak.sleepcyclealarm.view.OptionsView
import java.util.concurrent.TimeUnit

@PresenterScope
public class OptionsPresenterImpl(view : OptionsView, interactorComponent : InteractorComponent) : AbstractPresenter<OptionsView>(view, interactorComponent),
                                                        OptionsPresenter {
    override fun inject() {
        interactorComponent.inject(this)
    }

    override fun onAttachToView() {
        super.onAttachToView()
        inject()
        with(subscriptions) {
            add(view.sleepLaterClicks
                        ?.debounceDefault()
                        ?.subscribe {
                            logger.debug("Presenter", "Sleep Later")
                            view.navigateToSleepLater()
                        }
            )
            add(view.sleepNowClicks
                        ?.debounceDefault()
                        ?.subscribe {
                            logger.debug("Presenter", "Sleep Now")
                            view.navigateToSleepNow()
                        }
            )
        }
    }
}