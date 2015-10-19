package io.dwak.sleepcyclealarm

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import butterknife.bindView
import io.dwak.sleepcyclealarm.extension.navigateTo
import io.dwak.sleepcyclealarm.extension.toast
import io.dwak.sleepcyclealarm.model.Option
import io.dwak.sleepcyclealarm.times.SleepTimesFragment
import io.dwak.sleepcyclealarm.options.OptionsFragment

public class MainActivity : AppCompatActivity(), OptionsFragment.OptionsFragmentInteractionListener {

    val toolbar : Toolbar by bindView(R.id.toolbar)

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        navigateTo(OptionsFragment.newInstance(), addToBackStack = false);
    }

    override fun navigateToSleepTimes(sleepNow : Boolean) {
        navigateTo(SleepTimesFragment.newInstance(sleepNow), tag = "SleepNow")
    }

    override fun navigateToSleepLater() {
        toast("Not working")
    }
}