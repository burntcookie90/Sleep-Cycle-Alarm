package io.dwak.sleepcyclealarm

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.provider.AlarmClock
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import butterknife.bindView
import io.dwak.sleepcyclealarm.databinding.MainActivityBinding
import io.dwak.sleepcyclealarm.extension.fromDate
import io.dwak.sleepcyclealarm.extension.getHour
import io.dwak.sleepcyclealarm.extension.getMinute
import io.dwak.sleepcyclealarm.extension.navigateTo
import io.dwak.sleepcyclealarm.extension.toast
import io.dwak.sleepcyclealarm.options.OptionsFragment
import io.dwak.sleepcyclealarm.times.WakeUpTimesFragment
import java.util.*

public class MainActivity : AppCompatActivity(), OptionsFragment.OptionsFragmentInteractionListener,
                            WakeUpTimesFragment.WakeUpTimesFragmentListener {
    val toolbar : Toolbar by bindView(R.id.toolbar)

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        navigateTo(OptionsFragment.newInstance(), addToBackStack = false);
    }

    override fun navigateToSleepTimes(sleepNow : Boolean) {
        navigateTo(WakeUpTimesFragment.newInstance(sleepNow), tag = "SleepNow")
    }

    override fun navigateToSleepLater() {
        toast("Not working")
    }

    override fun setAlarm(wakeUpTime : Date) {
        val calendar = Calendar.getInstance().fromDate(wakeUpTime)
        val alarmIntent = Intent(AlarmClock.ACTION_SET_ALARM)
        alarmIntent.putExtra(AlarmClock.EXTRA_MESSAGE, "");
        alarmIntent.putExtra(AlarmClock.EXTRA_HOUR, calendar.getHour());
        alarmIntent.putExtra(AlarmClock.EXTRA_MINUTES, calendar.getMinute());
        startActivity(alarmIntent);
    }
}