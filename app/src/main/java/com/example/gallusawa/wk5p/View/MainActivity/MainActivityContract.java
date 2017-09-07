package com.example.gallusawa.wk5p.View.MainActivity;

import android.content.Context;

import com.example.gallusawa.wk5p.View.BasePresenter;
import com.example.gallusawa.wk5p.View.BaseView;
import com.example.gallusawa.wk5p.model.CurrentObservation;
import com.example.gallusawa.wk5p.model.HourlyForecastOrdered;

import java.util.List;

public interface MainActivityContract {
    interface View extends BaseView {
        void getZipCode(String zipCode);
        void currentWeather(CurrentObservation weather);
        void nextWeather(List<HourlyForecastOrdered> hourlyForecastOrdered);
    }
    interface Presenter extends BasePresenter<View> {
        void getContext(Context context);
        void getLocation();
        void restCall(String zipCode, Boolean flag);
    }

}
