package io.dwak.sleepcyclealarm.dagger.module

import dagger.Module
import dagger.Provides
import io.dwak.sleepcyclealarm.options.OptionsPresenterImpl
import io.dwak.sleepcyclealarm.presenter.OptionsPresenter
import io.dwak.sleepcyclealarm.presenter.WakeUpTimesPresenter
import io.dwak.sleepcyclealarm.times.WakeUpTimesPresenterImpl

@Module
class PresenterModule {
    @Provides
    fun providesWakeUpTimePresenter() : WakeUpTimesPresenter {
        return WakeUpTimesPresenterImpl()
    }

    @Provides
    fun providesOptionsPresenter(presenter : OptionsPresenterImpl) : OptionsPresenter {
        return presenter
    }
}