package io.dwak.sleepcyclealarm.base.mvp

import rx.Subscription
import java.util.ArrayList

public interface Presenter {
    val subscriptions : ArrayList<Subscription?>
    public open fun prepareToAttachToView() {

    }

    public open fun onAttachToView() {
    }

    public open fun onDetachFromView() {
        subscriptions.forEach { it?.unsubscribe() }
        subscriptions.clear()
    }
}