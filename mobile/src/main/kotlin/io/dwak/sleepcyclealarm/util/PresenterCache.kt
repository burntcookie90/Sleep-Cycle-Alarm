package io.dwak.sleepcyclealarm.util

import io.dwak.sleepcyclealarm.base.mvp.Presenter
import io.dwak.sleepcyclealarm.base.mvp.PresenterView

object PresenterCache {
    val cache = hashMapOf<Class<PresenterView>, Presenter>()

    fun putPresenter(view : PresenterView, presenter : Presenter) {
        cache.put(view.javaClass, presenter)
    }

    fun removePresenter(view : PresenterView) {
        cache.remove(view.javaClass)
    }

    fun getPresenter(view : PresenterView) : Presenter? {
        return cache[view.javaClass]
    }
}