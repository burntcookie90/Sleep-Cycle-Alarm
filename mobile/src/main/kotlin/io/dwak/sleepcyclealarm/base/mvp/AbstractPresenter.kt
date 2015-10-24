package io.dwak.sleepcyclealarm.base.mvp

import kotlin.properties.Delegates

public abstract class AbstractPresenter<T : Any> {
    var view : T by Delegates.notNull()
}