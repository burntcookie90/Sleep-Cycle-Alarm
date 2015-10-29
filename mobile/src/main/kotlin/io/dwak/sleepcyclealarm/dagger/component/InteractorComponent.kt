package io.dwak.sleepcyclealarm.dagger.component

import dagger.Component
import io.dwak.sleepcyclealarm.dagger.module.InteractorModule
import io.dwak.sleepcyclealarm.dagger.scope.PresenterScope
import io.dwak.sleepcyclealarm.options.OptionsPresenterImpl
import io.dwak.sleepcyclealarm.times.WakeUpTimesPresenterImpl

@PresenterScope
@Component(modules = arrayOf(InteractorModule::class))
public interface InteractorComponent {
    public fun inject(presenter : OptionsPresenterImpl)

    public fun inject(presenter : WakeUpTimesPresenterImpl)
}