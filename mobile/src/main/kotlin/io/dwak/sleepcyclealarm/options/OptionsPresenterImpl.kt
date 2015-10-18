package io.dwak.sleepcyclealarm.options

import io.dwak.meh.base.AbstractPresenter
import io.dwak.sleepcyclealarm.model.Option
import io.dwak.sleepcyclealarm.presenter.OptionsPresenter
import io.dwak.sleepcyclealarm.view.OptionsView
import java.util.ArrayList

public class OptionsPresenterImpl : AbstractPresenter<OptionsView>(), OptionsPresenter {
    override fun getOptions() {
        var options = ArrayList<Option>()
        options.add(Option.NOW)
        options.add(Option.WAKE_UP_AT)

        view.showOptions(options);
    }
}