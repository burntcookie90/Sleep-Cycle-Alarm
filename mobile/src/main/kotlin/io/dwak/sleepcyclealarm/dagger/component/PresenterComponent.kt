package io.dwak.sleepcyclealarm.dagger.component

import dagger.Component
import io.dwak.sleepcyclealarm.dagger.module.PresenterModule
import io.dwak.sleepcyclealarm.dagger.scope.ViewScope
import io.dwak.sleepcyclealarm.options.OptionsFragment
import io.dwak.sleepcyclealarm.times.WakeUpTimesFragment

@ViewScope
@Component(modules = arrayOf(PresenterModule::class))
public interface PresenterComponent {
    fun inject(view : OptionsFragment)

    fun inject(view : WakeUpTimesFragment)
}