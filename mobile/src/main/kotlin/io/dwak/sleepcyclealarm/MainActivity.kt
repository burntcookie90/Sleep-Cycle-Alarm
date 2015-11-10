package io.dwak.sleepcyclealarm

import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import butterknife.bindView
import io.dwak.sleepcyclealarm.extension.fromDate
import io.dwak.sleepcyclealarm.extension.hourOfDay
import io.dwak.sleepcyclealarm.extension.minute
import io.dwak.sleepcyclealarm.extension.navigateTo
import io.dwak.sleepcyclealarm.ui.options.OptionsFragment
import io.dwak.sleepcyclealarm.ui.times.WakeUpTimesFragment
import java.util.ArrayList
import java.util.Calendar
import java.util.Date

public class MainActivity : AppCompatActivity(),
                            OptionsFragment.OptionsFragmentInteractionListener,
                            WakeUpTimesFragment.WakeUpTimesFragmentListener {
    val toolbar : Toolbar by bindView(R.id.toolbar)

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        navigateTo(OptionsFragment.newInstance(), addToBackStack = false)
    }

    override fun navigateToWakeUpTimes(sleepNow : Boolean) {
        when {
            sleepNow -> {
                navigateTo(WakeUpTimesFragment.newInstance(sleepNow), tag = "SleepNow") {
                    setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left,
                                        R.anim.enter_from_left, R.anim.exit_to_right)
                }
            }
            else -> {
                with(Calendar.getInstance()) {
                    TimePickerDialog(this@MainActivity,
                                     { v, h, m->
                                         hourOfDay = h
                                         minute = m
                                         navigateTo(WakeUpTimesFragment.newInstance(time), tag = "SleepLater") {
                                             setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left,
                                                                 R.anim.enter_from_left, R.anim.exit_to_right)
                                         }
                                     },
                                     hourOfDay,
                                     minute,
                                     false)
                            .show()
                }
            }
        }
    }

    override fun setAlarm(wakeUpTime : Date) {
        val calendar = Calendar.getInstance().fromDate(wakeUpTime)
        with(Intent(AlarmClock.ACTION_SET_ALARM)) {
            putExtra(AlarmClock.EXTRA_MESSAGE, "");
            putExtra(AlarmClock.EXTRA_HOUR, calendar.hourOfDay);
            putExtra(AlarmClock.EXTRA_MINUTES, calendar.minute);
            startActivity(this);
        }

    }
}