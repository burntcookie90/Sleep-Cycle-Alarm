package io.dwak.sleepcyclealarm

import android.app.Activity
import android.widget.TextView

public class MainActivity : Activity() {

    private var mTextView : TextView? = null

    override fun onCreate(savedInstanceState : android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(io.dwak.sleepcyclealarm.R.layout.activity_main)
        val stub = findViewById(io.dwak.sleepcyclealarm.R.id.watch_view_stub) as android.support.wearable.view.WatchViewStub
        stub.setOnLayoutInflatedListener(object : android.support.wearable.view.WatchViewStub.OnLayoutInflatedListener {
            override fun onLayoutInflated(stub : android.support.wearable.view.WatchViewStub) {
                mTextView = stub.findViewById(io.dwak.sleepcyclealarm.R.id.text) as android.widget.TextView
            }
        })
    }
}