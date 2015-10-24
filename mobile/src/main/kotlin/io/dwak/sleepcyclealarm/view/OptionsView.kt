package io.dwak.sleepcyclealarm.view

import io.dwak.sleepcyclealarm.base.mvp.PresenterView

public interface OptionsView : PresenterView {
    fun navigateToSleepNow()

    fun navigateToSleepLater()
}