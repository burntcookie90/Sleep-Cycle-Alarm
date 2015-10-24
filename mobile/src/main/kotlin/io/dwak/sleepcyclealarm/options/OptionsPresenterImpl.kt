package io.dwak.sleepcyclealarm.options

import io.dwak.sleepcyclealarm.base.mvp.AbstractPresenter
import io.dwak.sleepcyclealarm.presenter.OptionsPresenter
import io.dwak.sleepcyclealarm.view.OptionsView
import java.util.concurrent.TimeUnit

public class OptionsPresenterImpl(view : OptionsView) : AbstractPresenter<OptionsView>(view),
                                                        OptionsPresenter {

    override fun onAttachToView() {
        super.onAttachToView()
        with(subscriptions) {
            add(view.sleepLaterClicks
                        ?.debounce(250, TimeUnit.MILLISECONDS)
                        ?.subscribe { view.navigateToSleepLater() })
            add(view.sleepNowClicks
                        ?.debounce(250, TimeUnit.MILLISECONDS)
                        ?.subscribe { view.navigateToSleepNow() })
        }
    }
}