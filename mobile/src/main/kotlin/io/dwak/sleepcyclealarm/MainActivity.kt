package io.dwak.sleepcyclealarm

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.dwak.sleepcyclealarm.model.Option
import io.dwak.sleepcyclealarm.options.OptionsFragment

public class MainActivity : AppCompatActivity(), OptionsFragment.OptionsFragmentInteractionListener {
    override fun onAlarmOptionSelected(option: Option) {
        toast(option.description)
    }

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
                .replace(R.id.container, OptionsFragment.newInstance())
                .commit()

    }
}