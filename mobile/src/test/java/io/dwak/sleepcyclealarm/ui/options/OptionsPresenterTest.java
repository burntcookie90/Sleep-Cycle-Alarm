package io.dwak.sleepcyclealarm.ui.options;

import org.junit.Before;
import org.junit.Test;

import io.dwak.sleepcyclealarm.base.BaseTest;
import io.dwak.sleepcyclealarm.dagger.component.DaggerTestInteractorComponent;
import io.dwak.sleepcyclealarm.dagger.module.TestPresenterModule;
import io.dwak.sleepcyclealarm.presenter.OptionsPresenter;
import io.dwak.sleepcyclealarm.view.OptionsView;
import kotlin.Unit;
import rx.subjects.PublishSubject;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class OptionsPresenterTest extends BaseTest<OptionsPresenter> {
    private PublishSubject<Unit> sleepNowClicks = PublishSubject.create();
    private PublishSubject<Unit> sleepLaterClicks = PublishSubject.create();
    private OptionsView optionsView = mock(OptionsView.class);

    @Override
    @Before
    public void setUp() throws Exception {
        when(optionsView.getSleepLaterClicks())
                .thenReturn(sleepLaterClicks.asObservable());
        when(optionsView.getSleepNowClicks())
                .thenReturn(sleepNowClicks.asObservable());
        super.setUp();
    }

    @Override
    public void inject() {
        getComponentBuilder()
                .presenterModule(new TestPresenterModule(optionsView))
                .interactorComponent(DaggerTestInteractorComponent.create())
                .build()
                .inject(this);

    }

    @Test
    public void testSleepNowButton() throws Exception {
        sleepNowClicks.onNext(Unit.INSTANCE);
        verify(optionsView).navigateToSleepNow();
    }

    @Test
    public void testSleepLaterButton() throws Exception {
        sleepLaterClicks.onNext(Unit.INSTANCE);
        verify(optionsView).navigateToSleepLater();
    }

    @Test
    public void testOnReattach() throws Exception {
        sleepNowClicks.onNext(Unit.INSTANCE);

        getPresenter().onDetachFromView();
        getPresenter().prepareToAttachToView();
        getPresenter().onAttachToView();
        sleepNowClicks.onNext(Unit.INSTANCE);

        verify(optionsView, times(2)).navigateToSleepNow();
    }
}
