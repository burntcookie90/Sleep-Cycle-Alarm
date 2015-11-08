package io.dwak.sleepcyclealarm.dagger.module;

import org.jetbrains.annotations.NotNull;
import org.mockito.Mockito;

import dagger.Module;
import io.dwak.sleepcyclealarm.base.mvp.PresenterView;
import io.dwak.sleepcyclealarm.dagger.component.InteractorComponent;
import io.dwak.sleepcyclealarm.presenter.OptionsPresenter;
import io.dwak.sleepcyclealarm.presenter.WakeUpTimesPresenter;
import io.dwak.sleepcyclealarm.view.OptionsView;
import io.dwak.sleepcyclealarm.view.WakeUpTimesView;

@Module
public class TestPresenterModule extends PresenterModule{
    public TestPresenterModule(@NotNull PresenterView view) {
        super(view);
    }

    @NotNull
    @Override
    public WakeUpTimesPresenter wakeUpTimesPresenter(@NotNull WakeUpTimesView view, @NotNull InteractorComponent interactorComponent) {
        return Mockito.spy(super.wakeUpTimesPresenter(view, interactorComponent));
    }

    @NotNull
    @Override
    public OptionsPresenter optionsPresenter(@NotNull OptionsView view, @NotNull InteractorComponent interactorComponent) {
        return Mockito.spy(super.optionsPresenter(view, interactorComponent));
    }
}
