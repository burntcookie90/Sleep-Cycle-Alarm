package io.dwak.sleepcyclealarm.model

import java.util.Date

data class WakeUpTime(val cycles : Int,
                      val subtitle : String,
                      val time : Date) {
}