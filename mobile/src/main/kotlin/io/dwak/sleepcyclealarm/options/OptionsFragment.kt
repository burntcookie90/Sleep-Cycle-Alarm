package io.dwak.sleepcyclealarm.options

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.bindView
import io.dwak.sleepcyclealarm.R
import io.dwak.sleepcyclealarm.base.mvp.MvpFragment
import io.dwak.sleepcyclealarm.dagger.module.PresenterModule
import io.dwak.sleepcyclealarm.dagger.scope.ViewScope
import io.dwak.sleepcyclealarm.presenter.OptionsPresenter
import io.dwak.sleepcyclealarm.view.OptionsView

@ViewScope
public class OptionsFragment : MvpFragment<OptionsPresenter>(), OptionsView {
    val sleepNowButton : TextView by bindView(R.id.sleep_now_button)
    val sleepLaterButton : TextView by bindView(R.id.sleep_later_button)

    public companion object {
        public fun newInstance() : Fragment = OptionsFragment()
    }

    var interactionListener : OptionsFragmentInteractionListener? = null

    override fun inject() {
        presenterComponentBuilder.presenterModule(PresenterModule(this))
                .build()
                .inject(this)
    }

    fun onClick(view : View) {
        when (view) {
            sleepNowButton   -> presenter.sleepNowClicked()
            sleepLaterButton -> presenter.sleepLaterClicked()
        }
    }

    override fun onAttach(activity : Activity?) {
        super.onAttach(activity)
        if (activity is OptionsFragmentInteractionListener)
            interactionListener = activity
        else
            throw RuntimeException("${getActivity().javaClass.simpleName} must implement OptionsFragmentInteractionListener")
    }

    override fun onCreateView(inflater : LayoutInflater?,
                              container : ViewGroup?,
                              savedInstanceState : Bundle?) : View? {
        return inflater?.inflate(R.layout.fragment_options, container, false);
    }

    override fun onStart() {
        super.onStart()
        sleepNowButton.setOnClickListener { onClick(it) }
        sleepLaterButton.setOnClickListener { onClick(it) }
    }

    override fun onDetach() {
        super.onDetach()
        interactionListener = null
    }

    override fun navigateToSleepNow() {
        interactionListener?.navigateToSleepTimes(true)
    }

    override fun navigateToSleepLater() {
        interactionListener?.navigateToSleepLater()
    }

    public interface OptionsFragmentInteractionListener {
        fun navigateToSleepTimes(sleepNow : Boolean)

        fun navigateToSleepLater()
    }

}