package io.dwak.sleepcyclealarm.util

import android.util.Log
import io.dwak.sleepcyclealarm.interactor.LoggingInteractor

public class LumberJack {
    companion object : LoggingInteractor {
        override fun verbose(tag : String, message : String) {
            Log.v(tag, message)
        }

        override fun warn(tag : String, message : String) {
            Log.w(tag, message)
        }

        override fun debug(tag : String, message : String) {
            Log.d(tag, message)
        }

        override fun info(tag : String, message : String) {
            Log.i(tag, message)
        }

        override fun error(tag : String, message : String) {
            Log.e(tag, message)
        }
    }
}