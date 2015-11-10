package io.dwak.sleepcyclealarm.ui.times;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import io.dwak.sleepcyclealarm.base.BaseTest;
import io.dwak.sleepcyclealarm.dagger.component.DaggerTestInteractorComponent;
import io.dwak.sleepcyclealarm.dagger.module.TestPresenterModule;
import io.dwak.sleepcyclealarm.extension.CalendarUtils;
import io.dwak.sleepcyclealarm.model.WakeUpTime;
import io.dwak.sleepcyclealarm.presenter.WakeUpTimesPresenter;
import io.dwak.sleepcyclealarm.view.WakeUpTimesView;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class WakeUpTimesViewTest extends BaseTest<WakeUpTimesPresenter> {
    private WakeUpTimesView view = mock(WakeUpTimesView.class);
    private PublishSubject<Date> itemClicks = PublishSubject.create();
    private static final long ONE_AND_HALF_HOURS_MS = 5400000;

    @Override
    @Before
    public void setUp() throws Exception {
        when(view.getItemClicks())
                .thenReturn(itemClicks.asObservable()
                                      .subscribeOn(Schedulers.immediate())
                                      .observeOn(Schedulers.immediate()));
        super.setUp();
    }

    @Override
    public void inject() {
        getComponentBuilder()
                .presenterModule(new TestPresenterModule(view))
                .interactorComponent(DaggerTestInteractorComponent.create())
                .build()
                .inject(this);
    }

    @Test
    public void testSleepNowTimes() throws Exception {
        getPresenter().setSleepNow(true);
        verifyCalculatedTimes();
    }

    @Test
    public void testSleepLaterTimes() throws Exception {
        getPresenter().setSleepNow(false);
        Calendar sleepLaterTime = Calendar.getInstance();
        CalendarUtils.setHourOfDay(sleepLaterTime, 12);
        CalendarUtils.setMinute(sleepLaterTime, 00);
        getPresenter().setSleepTime(sleepLaterTime.getTime());
        verifyCalculatedTimes();
    }

    private void verifyCalculatedTimes() {
        Date now = getPresenter().getSleepTime();
        Assert.assertNotNull(now);
        doAnswer(invocation -> {
            Object[] arguments = invocation.getArguments();
            Assert.assertNotNull(arguments[0]);
            Assert.assertNotNull(arguments[1]);

            Date sleepTime = (Date) arguments[0];
            Assert.assertEquals(now, sleepTime);
            System.out.println(Arrays.toString(invocation.getArguments()));
            List<WakeUpTime> wakeUpTimes = (List<WakeUpTime>) arguments[1];

            Assert.assertEquals(7, wakeUpTimes.size());

            for(int i = 0; i < wakeUpTimes.size(); i++){
                Calendar cal0 = null;
                Calendar cal1 = null;
                if(i == 0){
                    cal0 = CalendarUtils.fromDate(Calendar.getInstance(), sleepTime);
                    CalendarUtils.setMinute(cal0, CalendarUtils.getMinute(cal0) + 14);
                    cal1 = CalendarUtils.fromDate(Calendar.getInstance(), wakeUpTimes.get(i).getTime());
                }
                else {
                    cal0 = CalendarUtils.fromDate(Calendar.getInstance(), wakeUpTimes.get(i-1).getTime());
                    cal1 = CalendarUtils.fromDate(Calendar.getInstance(), wakeUpTimes.get(i).getTime());
                }

                Assert.assertEquals(ONE_AND_HALF_HOURS_MS, cal1.getTimeInMillis() - cal0.getTimeInMillis());
            }
            return null;
        }).when(view)
          .showTimes(any(Date.class), anyListOf(WakeUpTime.class));

        getPresenter().getTimes();
        verify(view).showTimes(any(Date.class), anyListOf(WakeUpTime.class));
    }
}
