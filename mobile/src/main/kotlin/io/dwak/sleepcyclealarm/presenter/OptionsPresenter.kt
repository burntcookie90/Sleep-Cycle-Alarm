package io.dwak.sleepcyclealarm.presenter

import io.dwak.sleepcyclealarm.base.mvp.Presenter
import io.dwak.sleepcyclealarm.view.OptionsView

public interface OptionsPresenter : Presenter {
    fun sleepNowClicked()

    fun sleepLaterClicked()
}