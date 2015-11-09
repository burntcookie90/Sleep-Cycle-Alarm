package io.dwak.sleepcyclealarm.ui.options

import io.dwak.sleepcyclealarm.base.mvp.AbstractPresenter
import io.dwak.sleepcyclealarm.dagger.component.InteractorComponent
import io.dwak.sleepcyclealarm.dagger.scope.PresenterScope
import io.dwak.sleepcyclealarm.extension.debounceDefault
import io.dwak.sleepcyclealarm.presenter.OptionsPresenter
import io.dwak.sleepcyclealarm.view.OptionsView

@PresenterScope
public open class OptionsPresenterImpl(view : OptionsView, interactorComponent : InteractorComponent)
: AbstractPresenter<OptionsView>(view, interactorComponent), OptionsPresenter {
    override fun inject() {
        interactorComponent.inject(this)
    }

    override fun onAttachToView() {
        super.onAttachToView()
        with(viewSubscription) {
            add(view.sleepLaterClicks
                        .subscribe {
                            logger.debug("Presenter", "Sleep Later")
                            view.navigateToSleepLater()
                        }
            )
            add(view.sleepNowClicks
                        .subscribe {
                            logger.debug("Presenter", "Sleep Now")
                            view.navigateToSleepNow()
                        }
            )
        }
    }
}