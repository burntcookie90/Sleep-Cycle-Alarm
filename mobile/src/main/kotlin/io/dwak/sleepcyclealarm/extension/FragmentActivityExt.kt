@file:JvmName("FragmentActivityUtils")

package io.dwak.sleepcyclealarm.extension

import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import io.dwak.sleepcyclealarm.R

fun FragmentActivity.navigateTo(fragment : Fragment,
                                tag : String = fragment.toString(),
                                addToBackStack : Boolean = true,
                                @LayoutRes container : Int = R.id.container) {
    val transaction = supportFragmentManager.beginTransaction()

    if (addToBackStack) {
        transaction.addToBackStack(tag)
    }

    transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left,
                                    R.anim.enter_from_left, R.anim.exit_to_right)
            .replace(container, fragment)
            .commit()
}

