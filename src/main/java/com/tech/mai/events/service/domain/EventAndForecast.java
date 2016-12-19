package com.tech.mai.events.service.domain;

import com.evdb.javaapi.data.Event;
import com.tech.mai.events.consumer.domain.Forecast;

/**
 * Created by Aamirio on 18/12/2016.
 */
public class EventAndForecast {

    private Event event;
    private Forecast forecast;

    public EventAndForecast(Event event, Forecast forecast) {
        this.event = event;
        this.forecast = forecast;
    }

    public Event getEvent() {
        return event;
    }

    public Forecast getForecast() {
        return forecast;
    }
}
