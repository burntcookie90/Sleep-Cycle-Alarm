package io.dwak.sleepcyclealarm.dagger.module;

import org.jetbrains.annotations.NotNull;

import dagger.Module;
import io.dwak.sleepcyclealarm.interactor.LoggingInteractor;
import io.dwak.sleepcyclealarm.util.TestLumberJack;

@Module
public class TestInteractorModule extends InteractorModule{
    @NotNull
    @Override
    public LoggingInteractor getLumberJack() {
        return new TestLumberJack();
    }
}
