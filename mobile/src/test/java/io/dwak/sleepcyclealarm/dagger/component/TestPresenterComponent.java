package io.dwak.sleepcyclealarm.dagger.component;

import dagger.Component;
import io.dwak.sleepcyclealarm.dagger.module.PresenterModule;
import io.dwak.sleepcyclealarm.dagger.scope.ViewScope;
import io.dwak.sleepcyclealarm.ui.options.OptionsPresenterTest;
import io.dwak.sleepcyclealarm.ui.times.WakeUpTimesViewTest;

@ViewScope
@Component(modules = PresenterModule.class, dependencies = InteractorComponent.class)
public interface TestPresenterComponent extends PresenterComponent {
    void inject(WakeUpTimesViewTest view);

    void inject(OptionsPresenterTest optionsViewTest);
}
