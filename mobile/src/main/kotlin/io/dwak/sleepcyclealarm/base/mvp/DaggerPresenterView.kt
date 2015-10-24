package io.dwak.sleepcyclealarm.base.mvp

import io.dwak.sleepcyclealarm.dagger.component.DaggerPresenterComponent

public interface DaggerPresenterView {
    val presenterComponentBuilder : DaggerPresenterComponent.Builder
        get() {
            return DaggerPresenterComponent.builder()
        }

    fun inject()
}