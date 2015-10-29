package io.dwak.sleepcyclealarm.dagger.module

import dagger.Module
import dagger.Provides
import io.dwak.sleepcyclealarm.interactor.LoggingInteractor
import io.dwak.sleepcyclealarm.util.LumberJack

@Module
open class InteractorModule() {
    open val lumberJack : LoggingInteractor = LumberJack

    @Provides
    fun providesLoggingInteractor() : LoggingInteractor {
        return lumberJack
    }
}