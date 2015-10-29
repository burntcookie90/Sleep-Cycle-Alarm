package io.dwak.sleepcyclealarm.dagger.component;

import dagger.Component;
import io.dwak.sleepcyclealarm.dagger.module.PresenterModule;
import io.dwak.sleepcyclealarm.dagger.scope.ViewScope;
import io.dwak.sleepcyclealarm.options.OptionsPresenterTest;
import io.dwak.sleepcyclealarm.times.WakeUpTimesViewTestImpl;

@ViewScope
@Component(modules = PresenterModule.class, dependencies = InteractorComponent.class)
public interface TestPresenterComponent extends PresenterComponent {
    void inject(WakeUpTimesViewTestImpl view);

    void inject(OptionsPresenterTest optionsViewTest);
}
