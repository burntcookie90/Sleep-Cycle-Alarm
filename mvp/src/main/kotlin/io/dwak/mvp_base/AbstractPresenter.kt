package io.dwak.mvp_base

import kotlin.properties.Delegates

public abstract class AbstractPresenter<T : Any> {
    var view : T by Delegates.notNull()
}