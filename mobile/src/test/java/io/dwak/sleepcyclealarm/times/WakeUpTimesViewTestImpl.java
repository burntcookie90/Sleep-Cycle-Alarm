package io.dwak.sleepcyclealarm.times;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Date;

import io.dwak.sleepcyclealarm.base.BaseTest;
import io.dwak.sleepcyclealarm.dagger.module.PresenterModule;
import io.dwak.sleepcyclealarm.model.WakeUpTime;
import io.dwak.sleepcyclealarm.presenter.WakeUpTimesPresenter;
import io.dwak.sleepcyclealarm.view.WakeUpTimesView;
import rx.Observable;

public class WakeUpTimesViewTestImpl extends BaseTest<WakeUpTimesPresenter>
        implements WakeUpTimesView {

    @Nullable
    @Override
    public Observable<Date> getItemClicks() {
        return null;
    }

    @Override
    public void setItemClicks(@Nullable Observable<Date> observable) {

    }

    @Override
    public void showTimes(@NotNull Date sleepTime, @NotNull ArrayList<WakeUpTime> wakeupTimes) {

    }

    @Override
    public void setAlarm(@NotNull Date wakeUpTime) {

    }

    @Override
    public void inject() {
        getComponentBuilder()
                .presenterModule(new PresenterModule(this)).build()
                .inject(this);
    }
}
