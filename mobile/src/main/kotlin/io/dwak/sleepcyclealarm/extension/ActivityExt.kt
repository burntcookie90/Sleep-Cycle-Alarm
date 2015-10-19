package io.dwak.sleepcyclealarm.extension

import android.app.Activity
import android.content.Context
import android.support.annotation.LayoutRes
import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import io.dwak.sleepcyclealarm.R

fun Activity.toast(message : String, length : Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, length).show();
}

fun Activity.toast(@StringRes message : Int, length : Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, length).show();
}

fun FragmentActivity.navigateTo(fragment : Fragment,
                                tag : String = fragment.toString(),
                                addToBackStack : Boolean = true,
                                @LayoutRes container : Int = R.id.container) {
    val transaction = supportFragmentManager.beginTransaction()

    if (addToBackStack) {
        transaction.addToBackStack(tag)
    }

    transaction.replace(container, fragment)
            .commit()
}

