package io.dwak.sleepcyclealarm.base.mvp

import rx.Subscription
import rx.subscriptions.CompositeSubscription
import java.util.ArrayList

public interface Presenter {
    val viewSubscription : CompositeSubscription

    public open fun prepareToAttachToView() {

    }

    public open fun onAttachToView() {
    }

    public open fun onDetachFromView() {
        viewSubscription.clear()
    }
}