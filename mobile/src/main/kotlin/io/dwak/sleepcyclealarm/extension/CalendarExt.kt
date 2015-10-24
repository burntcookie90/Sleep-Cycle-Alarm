package io.dwak.sleepcyclealarm.extension

import java.util.Calendar
import java.util.Date

public fun Calendar.getHour() : Int{
    return get(Calendar.HOUR)
}

public fun Calendar.getMinute() : Int{
    return get(Calendar.MINUTE)
}

public fun Calendar.addHours(hour : Int){
    add(Calendar.HOUR, hour)
}

public fun Calendar.addMinutes(minute : Int){
    add(Calendar.MINUTE, minute)
}

public fun Calendar.fromDate(date : Date) : Calendar {
    this.time = date
    return this
}

