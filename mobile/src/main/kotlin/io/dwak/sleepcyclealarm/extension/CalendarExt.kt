package io.dwak.sleepcyclealarm.extension

import java.util.Calendar
import java.util.Date

var Calendar.hour : Int
    get() {
        return get(Calendar.HOUR)
    }
    set(value) {
        set(Calendar.HOUR, value)
    }

var Calendar.minute : Int
    get() {
        return get(Calendar.MINUTE)
    }
    set(value) {
        set(Calendar.MINUTE, value)
    }

public fun Calendar.fromDate(date : Date) : Calendar {
    this.time = date
    return this
}

