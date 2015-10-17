package io.dwak.sleepycyclealarm.view

import io.dwak.sleepycyclealarm.model.Option

public interface OptionsView {
    fun showOptions(options : List<Option>)
}