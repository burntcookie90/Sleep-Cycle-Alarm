package io.dwak.sleepcyclealarm.ui.times

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.bindView
import io.dwak.sleepcyclealarm.R
import io.dwak.sleepcyclealarm.base.mvp.MvpFragment
import io.dwak.sleepcyclealarm.dagger.component.DaggerInteractorComponent
import io.dwak.sleepcyclealarm.dagger.module.PresenterModule
import io.dwak.sleepcyclealarm.dagger.scope.ViewScope
import io.dwak.sleepcyclealarm.model.WakeUpTime
import io.dwak.sleepcyclealarm.presenter.WakeUpTimesPresenter
import io.dwak.sleepcyclealarm.view.WakeUpTimesView
import rx.Observable
import java.util.Date

@ViewScope
public class WakeUpTimesFragment : MvpFragment<WakeUpTimesPresenter>(), WakeUpTimesView {
    override var itemClicks : Observable<Date>? = null
    val recycler : RecyclerView by bindView(R.id.recycler)
    lateinit var adapter : WakeUpTimesAdapter
    var listener : WakeUpTimesFragmentListener? = null

    companion object {
        val EXTRA_SLEEP_NOW = "SLEEP_NOW"
        val EXTRA_SLEEP_LATER_TIME = "SLEEP_LATER_TIME"

        fun newInstance() = WakeUpTimesFragment()

        fun newInstance(sleepNow : Boolean = false) : WakeUpTimesFragment {
            val extras = Bundle()
            extras.putBoolean(EXTRA_SLEEP_NOW, sleepNow)
            val fragment = WakeUpTimesFragment()
            fragment.arguments = extras
            return fragment
        }

        fun newInstance(sleepLaterTime : Date) : WakeUpTimesFragment {
            val extras = Bundle()
            extras.putSerializable(EXTRA_SLEEP_LATER_TIME, sleepLaterTime)
            val fragment = WakeUpTimesFragment()
            fragment.arguments = extras
            return fragment
        }
    }

    override fun inject() {
        presenterComponentBuilder
                .presenterModule(PresenterModule(this))
                .interactorComponent(DaggerInteractorComponent.create())
                .build()
                .inject(this)
    }

    //region lifecycle
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        with(arguments) {
            if (containsKey(EXTRA_SLEEP_NOW)) {
                presenter.isSleepNow = getBoolean(EXTRA_SLEEP_NOW, false);
            }
            else if (containsKey(EXTRA_SLEEP_LATER_TIME)) {
                presenter.sleepTime = getSerializable(EXTRA_SLEEP_LATER_TIME) as Date
            }
        }
    }

    override fun onCreateView(inflater : LayoutInflater?,
                              container : ViewGroup?,
                              savedInstanceState : Bundle?) : View? {
        return inflater?.inflate(R.layout.fragment_sleep_times, container, false);
    }

    override fun onAttach(context : Context?) {
        super.onAttach(context)
        if (activity is WakeUpTimesFragmentListener) {
            listener = activity as WakeUpTimesFragmentListener
        }
        else {
            throw RuntimeException("${activity.javaClass.simpleName} must implement WakeUpTimesListener")
        }
    }

    override fun onStart() {
        super.onStart()
        adapter = WakeUpTimesAdapter(activity)
        itemClicks = adapter.observable
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(activity)
        presenter.getTimes()
    }
    //endregion

    override fun showTimes(sleepTime : Date,
                           wakeupTimes : List<WakeUpTime>) {
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