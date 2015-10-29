@file:JvmName("CalendarUtils")

package io.dwak.sleepcyclealarm.extension

import java.util.Calendar
import java.util.Date

/**
 * Extension for {@link Calendar.AM_PM}
 */
var Calendar.amPm : Int
    get() = get(Calendar.AM_PM)
    set(value) = set(Calendar.AM_PM, value)

/**
 * Extension for {@link Calendar.MILLISECOND}
 */
var Calendar.millisecond : Int
    get() = get(Calendar.MILLISECOND)
    set(value) = set(Calendar.MILLISECOND, value)

/**
 * Extension for {@link Calendar.SECOND}
 */
var Calendar.second : Int
    get() = get(Calendar.SECOND)
    set(value) = set(Calendar.SECOND, value)

/**
 * Extension for {@link Calendar.MINUTE}
 */
var Calendar.minute : Int
    get() = get(Calendar.MINUTE)
    set(value) = set(Calendar.MINUTE, value)

/**
 * Extension for {@link Calendar.HOUR}
 */
var Calendar.hour : Int
    get() = get(Calendar.HOUR)
    set(value) = set(Calendar.HOUR, value)

/**
 * Extension for {@link Calendar.HOUR_OF_DAY}
 */
var Calendar.hourOfDay : Int
    get() = get(Calendar.HOUR_OF_DAY)
    set(value) = set(Calendar.HOUR_OF_DAY, value)

/**
 * Extension for {@link Calendar.DAY_OF_WEEK}
 */
var Calendar.dayOfWeek : Int
    get() = get(Calendar.DAY_OF_WEEK)
    set(value) = set(Calendar.DAY_OF_WEEK, value)

/**
 * Extension for {@link Calendar.DAY_OF_MONTH}
 */
var Calendar.dayOfMonth : Int
    get() = get(Calendar.DAY_OF_MONTH)
    set(value) = set(Calendar.DAY_OF_MONTH, value)

/**
 * Extension for {@link Calendar.WEEK_OF_MONTH}
 */
var Calendar.weekOfMonth : Int
    get() = get(Calendar.WEEK_OF_MONTH)
    set(value) = set(Calendar.WEEK_OF_MONTH, value)

/**
 * Extension for {@link Calendar.WEEK_OF_YEAR}
 */
var Calendar.weekOfYear : Int
    get() = get(Calendar.WEEK_OF_YEAR)
    set(value) = set(Calendar.WEEK_OF_YEAR, value)

/**
 * Extension for {@link Calendar.MONTH}
 */
var Calendar.month : Int
    get() = get(Calendar.MONTH)
    set(value) = set(Calendar.MONTH, value)

/**
 * Extension for {@link Calendar.YEAR}
 */
var Calendar.year : Int
    get() = get(Calendar.YEAR)
    set(value) = set(Calendar.YEAR, value)

public fun Calendar.fromDate(date : Date) : Calendar = apply { time = date }

public fun Calendar.isSunday() = dayOfWeek == Calendar.SUNDAY
public fun Calendar.isMonday() = dayOfWeek == Calendar.MONDAY
public fun Calendar.isTuesday() = dayOfWeek == Calendar.TUESDAY
public fun Calendar.isWednesday() = dayOfWeek == Calendar.WEDNESDAY
public fun Calendar.isThursday() = dayOfWeek == Calendar.THURSDAY
public fun Calendar.isFriday() = dayOfWeek == Calendar.FRIDAY
public fun Calendar.isSaturday() = dayOfWeek == Calendar.SATURDAY

public fun Calendar.isJanurary() = month == Calendar.JANUARY
public fun Calendar.isFebruary() = month == Calendar.FEBRUARY
public fun Calendar.isMarch() = month == Calendar.MARCH
public fun Calendar.isApril() = month == Calendar.APRIL
public fun Calendar.isMay() = month == Calendar.MAY
public fun Calendar.isJune() = month == Calendar.JUNE
public fun Calendar.isJuly() = month == Calendar.JULY
public fun Calendar.isAugust() = month == Calendar.AUGUST
public fun Calendar.isSeptember() = month == Calendar.SEPTEMBER
public fun Calendar.isOctober() = month == Calendar.OCTOBER
public fun Calendar.isNovember() = month == Calendar.NOVEMBER
public fun Calendar.isDecember() = month == Calendar.DECEMBER

public fun Calendar.isAm() = amPm == Calendar.AM
public fun Calendar.isPm() = amPm == Calendar.PM
