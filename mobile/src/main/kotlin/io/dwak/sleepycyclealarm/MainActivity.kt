package io.dwak.sleepycyclealarm

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.dwak.sleepcyclealarm.R
import io.dwak.sleepycyclealarm.model.Option
import io.dwak.sleepycyclealarm.options.OptionsFragment
import kotlinx.android.anko.toast

public class MainActivity : AppCompatActivity(), OptionsFragment.OptionsFragmentInteractionListener {
    override fun onOptionSelected(option : Option) {
        toast(option.description)
    }

    override fun onCreate(savedInstanceState : Bundle?) {
        super<AppCompatActivity>.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, OptionsFragment.newInstance())
                .commit()

    }
}