@file:JvmName("ContextUtils")

package io.dwak.sleepcyclealarm.extension

import android.app.Activity
import android.content.Context
import android.graphics.drawable.Drawable
import android.support.annotation.ColorInt
import android.support.annotation.ColorRes
import android.support.annotation.DrawableRes
import android.support.annotation.StringRes
import android.support.v4.content.ContextCompat
import android.widget.Toast

@ColorInt
public fun Context.getColor(@ColorRes id : Int) = ContextCompat.getColor(this, id)

public fun Context.getDrawable(@DrawableRes id : Int) = ContextCompat.getDrawable(this, id)

@JvmOverloads
fun Context.toast(message : String, length : Int = Toast.LENGTH_SHORT) = Toast.makeText(this, message, length).show()
@JvmOverloads
fun Context.toast(@StringRes message : Int, length : Int = Toast.LENGTH_SHORT) = Toast.makeText(this, message, length).show()


