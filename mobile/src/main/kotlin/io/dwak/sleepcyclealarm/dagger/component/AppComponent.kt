package io.dwak.sleepcyclealarm.dagger.component

import dagger.Component
import io.dwak.sleepcyclealarm.dagger.module.AppModule

@Component(modules = arrayOf(AppModule::class))
public interface AppComponent {
}