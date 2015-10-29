package io.dwak.sleepcyclealarm.view

import io.dwak.sleepcyclealarm.base.mvp.PresenterView

interface SleepLaterView : PresenterView {
    fun showTimePicker()

    fun navigateToSleepTimesView()
}