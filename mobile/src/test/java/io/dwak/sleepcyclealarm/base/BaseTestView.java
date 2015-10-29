package io.dwak.sleepcyclealarm.base;

import org.junit.Before;

import javax.inject.Inject;

import io.dwak.sleepcyclealarm.base.mvp.Presenter;
import io.dwak.sleepcyclealarm.dagger.component.DaggerTestPresenterComponent;

public abstract class BaseTestView<T extends Presenter> implements DaggerPresenterTestView{
    @Inject T presenter;

    @Before
    public void setUp() throws Exception {
        inject();
        presenter.prepareToAttachToView();
        presenter.onAttachToView();
    }

    @Override
    public DaggerTestPresenterComponent.Builder getComponentBuilder() {
        return DaggerTestPresenterComponent.builder();
    }

    public abstract void inject();
}
