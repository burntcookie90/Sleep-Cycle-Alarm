package io.dwak.sleepcyclealarm.interactor

public interface LoggingInteractor {
    fun verbose(tag : String, message : String)
    fun warn(tag : String, message : String)
    fun debug(tag : String, message : String)
    fun info(tag : String, message : String)
    fun error(tag : String, message : String)
}