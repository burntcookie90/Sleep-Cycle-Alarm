package io.dwak.sleepcyclealarm.times

import android.os.Bundle
import io.dwak.mvp_base.MvpFragment
import io.dwak.sleepcyclealarm.view.SleepTimesView
import java.util.*

class SleepTimesFragment : MvpFragment<SleepTimesPresenterImpl>(), SleepTimesView {
    companion object {
        fun newInstance() = SleepTimesFragment()
        fun newInstance(sleepNow : Boolean = false) : SleepTimesFragment {
            val extras = Bundle()
            extras.putBoolean("SLEEP_NOW", sleepNow)
            val fragment = SleepTimesFragment()
            fragment.arguments = extras
            return fragment
        }

        fun newInstance(sleepLaterTime : Date) : SleepTimesFragment {
            val extras = Bundle()
            extras.putSerializable("SLEEP_LATER_TIME", sleepLaterTime)
            val fragment = SleepTimesFragment()
            fragment.arguments = extras
            return fragment
        }
    }

    override val presenterClass = SleepTimesPresenterImpl::class.java

    override fun setView() {
        presenter.view = this
    }

    override fun showTimes() {
        throw UnsupportedOperationException()
    }
}