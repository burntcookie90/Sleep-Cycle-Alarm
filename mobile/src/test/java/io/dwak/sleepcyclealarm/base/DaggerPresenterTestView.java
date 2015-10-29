package io.dwak.sleepcyclealarm.base;

import io.dwak.sleepcyclealarm.dagger.component.DaggerTestPresenterComponent;

public interface DaggerPresenterTestView {
    DaggerTestPresenterComponent.Builder getComponentBuilder();
    void inject();
}
