package io.dwak.sleepcyclealarm.base.mvp

import io.dwak.sleepcyclealarm.dagger.component.DaggerInteractorComponent
import io.dwak.sleepcyclealarm.dagger.component.DaggerPresenterComponent

public interface DaggerPresenter {
    val interactorComponentBuilder : DaggerInteractorComponent.Builder
        get() {
            return DaggerInteractorComponent.builder()
        }

    fun inject()
}