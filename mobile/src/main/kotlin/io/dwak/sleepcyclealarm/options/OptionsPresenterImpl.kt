package io.dwak.sleepcyclealarm.options

import io.dwak.sleepcyclealarm.base.mvp.AbstractPresenter
import io.dwak.sleepcyclealarm.presenter.OptionsPresenter
import io.dwak.sleepcyclealarm.view.OptionsView

public class OptionsPresenterImpl(view : OptionsView) : AbstractPresenter<OptionsView>(view), OptionsPresenter {
    override fun sleepLaterClicked() {
        view.navigateToSleepLater()
    }

    override fun sleepNowClicked() {
        view.navigateToSleepNow()
    }
}