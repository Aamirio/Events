package com.tech.mai.events.service.domain;

import java.util.List;

/**
 * Created by Aamirio on 18/12/2016.
 */
public class Events {

    private List<EventAndForecast> eventAndForecastList;

    public Events(List<EventAndForecast> eventAndForecastList) {
        this.eventAndForecastList = eventAndForecastList;
    }

    public List<EventAndForecast> getEventAndForecastList() {
        return eventAndForecastList;
    }
}
