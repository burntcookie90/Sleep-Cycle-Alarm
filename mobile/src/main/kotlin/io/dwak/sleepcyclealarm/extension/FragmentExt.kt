package io.dwak.sleepcyclealarm.extension

import android.support.v4.app.Fragment
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty


inline fun <reified L> Fragment.bindActivity() : Lazy<Fragment, L> {
    if (activity is L) {
//        return object : ReadWriteProperty<Fragment, L> {
//            override fun setValue(thisRef : Fragment, property : KProperty<*>, value : L) {
//                throw UnsupportedOperationException()
//            }
//
//            override fun getValue(thisRef : Fragment, property : KProperty<*>) : L {
//                return activity as L
//            }
//        }

        return Lazy({ t, kProperty ->  activity as L })
    }
    else {
        throw RuntimeException("${activity.javaClass.simpleName} must implement OptionsFragmentInteractionListener")
    }
}

// Like Kotlin's lazy delegate but the initializer gets the target and metadata passed to it
class Lazy<T, V>(private val initializer : (T, KProperty<*>) -> V)
: ReadWriteProperty<T, V> {

    private object EMPTY

    private var value : Any? = EMPTY

    override fun setValue(thisRef : T, property : KProperty<*>, value : V) {
        this.value = value
    }

    override fun getValue(thisRef : T, property : KProperty<*>) : V {
        if (value == EMPTY) {
            value = initializer(thisRef, property)
        }
        @Suppress("UNCHECKED_CAST")
        return value as V
    }
}
