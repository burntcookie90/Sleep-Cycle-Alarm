package io.dwak.sleepcyclealarm.dagger.component

import com.google.repacked.antlr.v4.runtime.atn.PredictionMode
import dagger.Component
import io.dwak.sleepcyclealarm.dagger.module.PresenterModule
import io.dwak.sleepcyclealarm.dagger.scope.ViewScope
import io.dwak.sleepcyclealarm.options.OptionsFragment
import io.dwak.sleepcyclealarm.times.WakeUpTimesFragment
import io.dwak.sleepcyclealarm.view.OptionsView
import io.dwak.sleepcyclealarm.view.WakeUpTimesView

@ViewScope
@Component(modules = arrayOf(PresenterModule::class))
public interface PresenterComponent {
    fun inject(view : OptionsFragment)

    fun inject(view : WakeUpTimesFragment)
}