package io.dwak.sleepcyclealarm.dagger.module

import dagger.Module
import dagger.Provides
import io.dwak.sleepcyclealarm.base.mvp.PresenterView
import io.dwak.sleepcyclealarm.dagger.component.DaggerInteractorComponent
import io.dwak.sleepcyclealarm.dagger.component.InteractorComponent
import io.dwak.sleepcyclealarm.options.OptionsPresenterImpl
import io.dwak.sleepcyclealarm.presenter.OptionsPresenter
import io.dwak.sleepcyclealarm.presenter.WakeUpTimesPresenter
import io.dwak.sleepcyclealarm.times.WakeUpTimesPresenterImpl
import io.dwak.sleepcyclealarm.view.OptionsView
import io.dwak.sleepcyclealarm.view.WakeUpTimesView

@Module
public class PresenterModule(val view : PresenterView) {
    @Provides
    fun providesWakeUpTimePresenter(interactorComponent : InteractorComponent) : WakeUpTimesPresenter {
        return WakeUpTimesPresenterImpl(view as WakeUpTimesView, interactorComponent)
    }

    @Provides
    fun providesOptionsPresenter(interactorComponent : InteractorComponent) : OptionsPresenter {
        return OptionsPresenterImpl(view as OptionsView, interactorComponent)
    }
}