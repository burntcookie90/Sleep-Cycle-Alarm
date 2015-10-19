package io.dwak.sleepcyclealarm.times

import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import io.dwak.mvp_base.MvpFragment
import io.dwak.sleepcyclealarm.R
import io.dwak.sleepcyclealarm.base.DataBindingMvpFragment
import io.dwak.sleepcyclealarm.databinding.SleepTimesFragmentBinding
import io.dwak.sleepcyclealarm.model.WakeUpTime
import io.dwak.sleepcyclealarm.view.WakeUpTimesView
import java.util.*

class WakeUpTimesFragment : DataBindingMvpFragment<WakeUpTimesPresenterImpl,
        SleepTimesFragmentBinding>(), WakeUpTimesView {

    lateinit var adapter : WakeUpTimesAdapter
    var listener : WakeUpTimesFragmentListener? = null

    companion object {
        val EXTRA_SLEEP_NOW = "SLEEP_NOW"
        val EXTRA_SLEEP_LATER_TIME = "SLEEP_LATER_TIME"

        fun newInstance() = WakeUpTimesFragment()

        fun newInstance(sleepNow : Boolean = false) : WakeUpTimesFragment{
            val extras = Bundle()
            extras.putBoolean(EXTRA_SLEEP_NOW, sleepNow)
            val fragment = WakeUpTimesFragment()
            fragment.arguments = extras
            return fragment
        }

        fun newInstance(sleepLaterTime : Date) : WakeUpTimesFragment{
            val extras = Bundle()
            extras.putSerializable(EXTRA_SLEEP_LATER_TIME, sleepLaterTime)
            val fragment = WakeUpTimesFragment()
            fragment.arguments = extras
            return fragment
        }
    }

    override val presenterClass = WakeUpTimesPresenterImpl::class.java

    override fun setView() {
        presenter.view = this
    }

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments?.containsKey(EXTRA_SLEEP_NOW)!!) {
            presenter.isSleepNow = arguments?.getBoolean(EXTRA_SLEEP_NOW, false);
        }
        else if (arguments?.containsKey(EXTRA_SLEEP_LATER_TIME)!!) {
            presenter.sleepTime = arguments?.getSerializable(EXTRA_SLEEP_LATER_TIME) as Date
        }
    }

    override fun onCreateView(inflater : LayoutInflater?,
                              container : ViewGroup?,
                              savedInstanceState : Bundle?) : View? {
        createViewBinding(inflater, R.layout.fragment_sleep_times, container)
        adapter = WakeUpTimesAdapter(activity, { presenter.wakeUpTimeSelected(it) })
        viewBinding.recycler.adapter = adapter
        viewBinding.recycler.layoutManager = LinearLayoutManager(activity)
        return viewBinding.root
    }

    override fun onAttach(activity : Activity?) {
        super.onAttach(activity)
        if(activity is WakeUpTimesFragmentListener){
            listener  = activity
        }
        else {
            throw RuntimeException("${getActivity().javaClass.simpleName} must implement WakeUpTimesListener")
        }
    }

    override fun onStart() {
        super.onStart()
        presenter.getTimes()
    }

    override fun showTimes(sleepTime : Date,
                           wakeupTimes : ArrayList<WakeUpTime>) {
        adapter.sleepTime = sleepTime
        wakeupTimes.forEach { adapter.addTime(it) }
    }

    override fun setAlarm(wakeUpTime : Date) {
        listener?.setAlarm(wakeUpTime)
    }

    public interface WakeUpTimesFragmentListener {
        fun setAlarm(wakeUpTime : Date)
    }

}