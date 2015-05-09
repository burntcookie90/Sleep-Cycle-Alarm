package io.dwak.sleepycyclealarm.view

import io.dwak.sleepycyclealarm.model.Option

public trait OptionsView {
    fun showOptions(options : List<Option>)
}