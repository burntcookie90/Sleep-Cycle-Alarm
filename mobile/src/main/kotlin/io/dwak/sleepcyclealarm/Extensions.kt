package io.dwak.sleepcyclealarm

import android.app.Activity
import android.content.Context
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.RecyclerView
import android.widget.Toast

fun Activity.toast(message: String){
    Toast.makeText(this, message, Toast.LENGTH_SHORT);
}


