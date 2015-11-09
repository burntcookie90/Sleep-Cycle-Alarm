package io.dwak.sleepcyclealarm.dagger.component

import dagger.Component
import io.dwak.sleepcyclealarm.dagger.module.InteractorModule
import io.dwak.sleepcyclealarm.dagger.scope.PresenterScope
import io.dwak.sleepcyclealarm.ui.options.OptionsPresenterImpl
import io.dwak.sleepcyclealarm.ui.times.WakeUpTimesPresenterImpl
import io.dwak.sleepcyclealarm.util.PresenterCache

@Component(modules = arrayOf(InteractorModule::class))
public interface InteractorComponent {
    public fun inject(presenter : OptionsPresenterImpl)

    public fun inject(presenter : WakeUpTimesPresenterImpl)

    public fun inject(cache : PresenterCache)
}