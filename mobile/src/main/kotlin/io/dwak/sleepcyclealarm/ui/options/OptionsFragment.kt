package io.dwak.sleepcyclealarm.ui.options

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import io.dwak.sleepcyclealarm.R
import io.dwak.sleepcyclealarm.base.mvp.MvpFragment
import io.dwak.sleepcyclealarm.dagger.component.DaggerInteractorComponent
import io.dwak.sleepcyclealarm.dagger.module.PresenterModule
import io.dwak.sleepcyclealarm.dagger.scope.ViewScope
import io.dwak.sleepcyclealarm.presenter.OptionsPresenter
import io.dwak.sleepcyclealarm.view.OptionsView
import rx.Observable
import rx.subjects.PublishSubject

@ViewScope
public class OptionsFragment : MvpFragment<OptionsPresenter>(), OptionsView {
    public companion object {
        public fun newInstance() : Fragment = OptionsFragment()
    }

    lateinit var sleepNowButton : TextView
    lateinit var sleepLaterButton : TextView
    val sleepNowClicksSubject = PublishSubject.create<Unit>()
    override val sleepNowClicks : Observable<Unit> get() = sleepNowClicksSubject.asObservable()
    val sleepLaterClicksSubject = PublishSubject.create<Unit>()
    override val sleepLaterClicks : Observable<Unit> get() = sleepLaterClicksSubject.asObservable()

    var interactionListener : OptionsFragmentInteractionListener? = null

    override fun inject() {
        presenterComponentBuilder
                .presenterModule(PresenterModule(this))
                .interactorComponent(DaggerInteractorComponent.create())
                .build()
                .inject(this)
    }

    //region lifecycle
    override fun onAttach(context : Context?) {
        super.onAttach(context)
        if (activity is OptionsFragmentInteractionListener)
            interactionListener = activity as OptionsFragmentInteractionListener
        else
            throw RuntimeException("${activity.javaClass.simpleName} must implement OptionsFragmentInteractionListener")
    }

    override fun onCreateView(inflater : LayoutInflater?,
                              container : ViewGroup?,
                              savedInstanceState : Bundle?) : View? {
        val view = inflater?.inflate(R.layout.fragment_options, container, false)
        sleepNowButton = view?.findViewById(R.id.sleep_now_button) as TextView
        sleepLaterButton = view?.findViewById(R.id.sleep_later_button) as TextView
        sleepNowButton.setOnClickListener {
            sleepNowClicksSubject.onNext(null)
        }
        sleepLaterButton.setOnClickListener {
            sleepLaterClicksSubject.onNext(null)
        }
        return view
    }

    override fun onDetach() {
        super.onDetach()
        interactionListener = null
    }
    //endregion

    //region view methods
    override fun navigateToSleepNow() {
        interactionListener?.navigateToSleepTimes(sleepNow = true)
    }

    override fun navigateToSleepLater() {
        interactionListener?.navigateToSleepTimes(sleepNow = false)
    }
    //endregion

    public interface OptionsFragmentInteractionListener {
        fun navigateToSleepTimes(sleepNow : Boolean)
    }
}

