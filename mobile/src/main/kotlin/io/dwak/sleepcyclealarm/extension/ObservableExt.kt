@file:JvmName("ObservableUtils")

package io.dwak.sleepcyclealarm.extension

import rx.Observable
import java.util.concurrent.TimeUnit

public fun <T> Observable<T>.debounceDefault() : Observable<T> {
    return debounce(250, TimeUnit.MILLISECONDS)
}

