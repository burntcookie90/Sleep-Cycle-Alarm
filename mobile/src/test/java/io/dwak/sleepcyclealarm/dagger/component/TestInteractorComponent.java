package io.dwak.sleepcyclealarm.dagger.component;

import android.support.annotation.NonNull;

import dagger.Component;
import io.dwak.sleepcyclealarm.dagger.module.TestInteractorModule;
import io.dwak.sleepcyclealarm.dagger.scope.PresenterScope;
import io.dwak.sleepcyclealarm.options.OptionsPresenterImpl;
import io.dwak.sleepcyclealarm.times.WakeUpTimesPresenterImpl;

@PresenterScope
@Component(modules = TestInteractorModule.class)
public interface TestInteractorComponent extends InteractorComponent{
    void inject(@NonNull OptionsPresenterImpl presenter);

    void inject(@NonNull WakeUpTimesPresenterImpl presenter);
}
