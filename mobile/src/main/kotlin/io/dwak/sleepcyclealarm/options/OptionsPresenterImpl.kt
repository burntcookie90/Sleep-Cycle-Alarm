package io.dwak.sleepcyclealarm.options

import io.dwak.mvp_base.AbstractPresenter
import io.dwak.sleepcyclealarm.model.Option
import io.dwak.sleepcyclealarm.presenter.OptionsPresenter
import io.dwak.sleepcyclealarm.view.OptionsView

public class OptionsPresenterImpl : AbstractPresenter<OptionsView>(), OptionsPresenter {

    override fun getOptions() {
        view.showOptions(arrayListOf(Option.NOW, Option.WAKE_UP_AT));
    }
}