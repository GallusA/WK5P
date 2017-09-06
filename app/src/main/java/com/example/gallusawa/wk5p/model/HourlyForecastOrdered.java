package com.example.gallusawa.wk5p.model;

import java.util.List;

/**
 * Created by Pancho on 9/3/2017.
 */

public class HourlyForecastOrdered {
    String label = "";
    List<HourlyForecast> hourlyForecastOrdered;


    public HourlyForecastOrdered(String label, List<HourlyForecast> hourlyForecastOrdered) {
        this.label = label;
        this.hourlyForecastOrdered = hourlyForecastOrdered;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<HourlyForecast> getHourlyForecastOrdered() {
        return hourlyForecastOrdered;
    }

    public void setHourlyForecastOrdered(List<HourlyForecast> hourlyForecastOrdered) {
        this.hourlyForecastOrdered = hourlyForecastOrdered;
    }
}
