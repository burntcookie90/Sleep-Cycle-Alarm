package io.dwak.sleepcyclealarm.base.mvp

import rx.Subscription
import java.util.ArrayList

public abstract class AbstractPresenter<T : PresenterView>(val view : T) {
    val subscriptions = ArrayList<Subscription?>()
}