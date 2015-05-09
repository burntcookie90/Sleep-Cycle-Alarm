package io.dwak.sleepycyclealarm.options

import io.dwak.meh.base.AbstractPresenter
import io.dwak.sleepycyclealarm.model.Option
import io.dwak.sleepycyclealarm.presenter.OptionsPresenter
import io.dwak.sleepycyclealarm.view.OptionsView
import java.util.ArrayList

public class OptionsPresenterImpl : AbstractPresenter<OptionsView>(), OptionsPresenter {
    override fun getOptions() {
        var options = ArrayList<Option>()
        options.add(Option.NOW)
        options.add(Option.WAKE_UP_AT)

        view.showOptions(options);
    }
}