package io.dwak.sleepcyclealarm.view

import io.dwak.sleepcyclealarm.base.mvp.PresenterView
import rx.Observable

public interface OptionsView : PresenterView {

    val sleepNowClicks : Observable<Unit>

    val sleepLaterClicks : Observable<Unit>

    fun navigateToSleepNow()

    fun navigateToSleepLater()
}