package io.dwak.sleepcyclealarm.options

import io.dwak.sleepcyclealarm.base.mvp.AbstractPresenter
import io.dwak.sleepcyclealarm.presenter.OptionsPresenter
import io.dwak.sleepcyclealarm.view.OptionsView

public class OptionsPresenterImpl(view : OptionsView) : AbstractPresenter<OptionsView>(view), OptionsPresenter {

    override fun onAttachToView() {
        super.onAttachToView()
        view.sleepLaterClicks.subscribe { view.navigateToSleepLater() }
        view.sleepNowClicks.subscribe { view.navigateToSleepNow() }
    }

}