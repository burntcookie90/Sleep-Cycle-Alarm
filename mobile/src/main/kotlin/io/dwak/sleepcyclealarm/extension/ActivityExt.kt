@file:JvmName("ActivityUtils")

package io.dwak.sleepcyclealarm.extension

import android.app.Activity
import android.support.annotation.StringRes
import android.widget.Toast

@JvmOverloads
fun Activity.toast(message : String, length : Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, length).show();
}

@JvmOverloads
fun Activity.toast(@StringRes message : Int, length : Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, length).show();
}


