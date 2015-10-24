package io.dwak.sleepcyclealarm.base.mvp

import kotlin.properties.Delegates

public abstract class AbstractPresenter<T : PresenterView> {
    var view : T by Delegates.notNull()
}