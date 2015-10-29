package io.dwak.sleepcyclealarm.util;

import org.jetbrains.annotations.NotNull;

import io.dwak.sleepcyclealarm.interactor.LoggingInteractor;

public class TestLumberJack implements LoggingInteractor {

    @Override
    public void verbose(@NotNull String tag, @NotNull String message) {
        System.out.println(tag + ": " + message);
    }

    @Override
    public void warn(@NotNull String tag, @NotNull String message) {
        System.out.println(tag + ": " + message);
    }

    @Override
    public void debug(@NotNull String tag, @NotNull String message) {
        System.out.println(tag + ": " + message);
    }

    @Override
    public void info(@NotNull String tag, @NotNull String message) {
        System.out.println(tag + ": " + message);
    }

    @Override
    public void error(@NotNull String tag, @NotNull String message) {
        System.out.println(tag + ": " + message);
    }
}
