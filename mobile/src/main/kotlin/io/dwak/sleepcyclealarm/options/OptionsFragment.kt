package io.dwak.sleepcyclealarm.options

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.bindView
import io.dwak.mvp_base.MvpFragment
import io.dwak.sleepcyclealarm.R
import io.dwak.sleepcyclealarm.base.DataBindingMvpFragment
import io.dwak.sleepcyclealarm.databinding.OptionsFragmentBinding
import io.dwak.sleepcyclealarm.model.Option
import io.dwak.sleepcyclealarm.view.OptionsView
import kotlin.properties.Delegates

class OptionsFragment : DataBindingMvpFragment<OptionsPresenterImpl, OptionsFragmentBinding>(), OptionsView {
    public companion object {
        public fun newInstance() : Fragment = OptionsFragment()
    }

    var interactionListener : OptionsFragmentInteractionListener? = null
    override val presenterClass : Class<OptionsPresenterImpl> = OptionsPresenterImpl::class.java

    override fun setView() {
        presenter.view = this
    }

    fun onClick(view : View) {
        when (view) {
            viewBinding.sleepNowButton   -> presenter.sleepNowClicked()
            viewBinding.sleepLaterButton -> presenter.sleepLaterClicked()
        }
    }

    override fun onAttach(activity : Activity?) {
        super.onAttach(activity)
        if (getActivity() is OptionsFragmentInteractionListener)
            interactionListener = getActivity() as OptionsFragmentInteractionListener
        else
            throw RuntimeException("${getActivity().javaClass.simpleName} must implement OptionsFragmentInteractionListener")
    }

    override fun onCreateView(inflater : LayoutInflater?,
                              container : ViewGroup?,
                              savedInstanceState : Bundle?) : View? {
        createViewBinding(inflater, R.layout.fragment_options, container)
        viewBinding.sleepNowButton.setOnClickListener { onClick(it) }
        viewBinding.sleepLaterButton.setOnClickListener { onClick(it) }
        return viewBinding.root
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