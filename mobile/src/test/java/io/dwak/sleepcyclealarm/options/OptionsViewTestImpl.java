package io.dwak.sleepcyclealarm.options;

import junit.framework.Assert;

import org.jetbrains.annotations.Nullable;
import org.junit.Test;

import io.dwak.sleepcyclealarm.base.BaseTestView;
import io.dwak.sleepcyclealarm.dagger.component.DaggerTestInteractorComponent;
import io.dwak.sleepcyclealarm.dagger.module.PresenterModule;
import io.dwak.sleepcyclealarm.presenter.OptionsPresenter;
import io.dwak.sleepcyclealarm.view.OptionsView;
import kotlin.Unit;
import rx.Observable;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;

public class OptionsViewTestImpl extends BaseTestView<OptionsPresenter> implements OptionsView {
    private PublishSubject<Unit> sleepNowClicks = PublishSubject.create();
    private PublishSubject<Unit> sleepLaterClicks = PublishSubject.create();

    @Override
    public void inject() {
        getComponentBuilder()
                .presenterModule(new PresenterModule(this))
                .interactorComponent(DaggerTestInteractorComponent.create())
                .build()
                .inject(this);
    }

    @Test
    public void testSleepNowButton() throws Exception {
        sleepNowClicks.onNext(Unit.INSTANCE);
    }

    @Test
    public void testSleepLaterButton() throws Exception {
        sleepLaterClicks.onNext(Unit.INSTANCE);
    }

    @Nullable
    @Override
    public Observable<Unit> getSleepNowClicks() {
        return sleepNowClicks.asObservable()
                             .subscribeOn(Schedulers.immediate())
                             .observeOn(Schedulers.immediate());
    }

    @Nullable
    @Override
    public Observable<Unit> getSleepLaterClicks() {
        return sleepLaterClicks.asObservable()
                               .subscribeOn(Schedulers.immediate())
                               .observeOn(Schedulers.immediate());
    }

    @Override
    public void navigateToSleepNow() {
        Assert.assertTrue(true);
    }

    @Override
    public void navigateToSleepLater() {
        Assert.assertTrue(true);
    }
}
