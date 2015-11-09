package io.dwak.sleepcyclealarm.util

import io.dwak.sleepcyclealarm.base.mvp.DaggerPresenterView
import io.dwak.sleepcyclealarm.base.mvp.Presenter
import io.dwak.sleepcyclealarm.base.mvp.PresenterView
import io.dwak.sleepcyclealarm.dagger.component.DaggerInteractorComponent
import io.dwak.sleepcyclealarm.dagger.module.InteractorModule
import io.dwak.sleepcyclealarm.interactor.LoggingInteractor
import javax.inject.Inject

object PresenterCache {
    val cache = hashMapOf<Class<PresenterView>, Presenter>()
    lateinit var logger : LoggingInteractor
        @Inject set

    init {
        DaggerInteractorComponent.builder().interactorModule(InteractorModule()).build().inject(this)
    }

    fun putPresenter(view : PresenterView, presenter : Presenter) {
        logger.debug("Presenter Cache", "Put Presenter")
        cache.put(view.javaClass, presenter)
    }

    fun removePresenter(view : PresenterView) {
        logger.debug("Presenter Cache", "Reomve Presenter")
        cache.remove(view.javaClass)
    }

    fun getPresenter(view : PresenterView) : Presenter? {
        logger.debug("Presenter Cache", "Get Presenter")
        return cache[view.javaClass]
    }
}