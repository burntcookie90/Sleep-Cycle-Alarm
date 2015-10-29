package io.dwak.sleepcyclealarm.options

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.bindView
import com.jakewharton.rxbinding.view.clicks
import io.dwak.sleepcyclealarm.R
import io.dwak.sleepcyclealarm.base.mvp.MvpFragment
import io.dwak.sleepcyclealarm.dagger.component.DaggerInteractorComponent
import io.dwak.sleepcyclealarm.dagger.module.PresenterModule
import io.dwak.sleepcyclealarm.dagger.scope.ViewScope
import io.dwak.sleepcyclealarm.extension.debounceDefault
import io.dwak.sleepcyclealarm.presenter.OptionsPresenter
import io.dwak.sleepcyclealarm.view.OptionsView
import rx.Observable
import rx.Scheduler
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

@ViewScope
public class OptionsFragment : MvpFragment<OptionsPresenter>(), OptionsView {
    public companion object {
        public fun newInstance() : Fragment = OptionsFragment()
    }

    val sleepNowButton : TextView by bindView(R.id.sleep_now_button)
    val sleepLaterButton : TextView by bindView(R.id.sleep_later_button)
    override val sleepNowClicks : Observable<Unit>
        get() = sleepNowButton
                .clicks()
                .observeOn(Schedulers.immediate())
                .subscribeOn(AndroidSchedulers.mainThread())
                .debounceDefault()
    override val sleepLaterClicks : Observable<Unit>
        get() = sleepLaterButton
                .clicks()
                .observeOn(Schedulers.immediate())
                .subscribeOn(AndroidSchedulers.mainThread())
                .debounceDefault()

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
        return inflater?.inflate(R.layout.fragment_options, container, false);
    }

    override fun onDetach() {
        super.onDetach()
        interactionListener = null
    }
    //endregion

    //region view methods
    override fun navigateToSleepNow() {
        interactionListener?.navigateToSleepTimes(true)
    }

    override fun navigateToSleepLater() {
        interactionListener?.navigateToSleepLater()
    }
    //endregion

    public interface OptionsFragmentInteractionListener {
        fun navigateToSleepTimes(sleepNow : Boolean)

        fun navigateToSleepLater()
    }

}