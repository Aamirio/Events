package com.tech.mai.events.service;

import com.evdb.javaapi.data.Event;
import com.tech.mai.events.consumer.EventsConsumer;
import com.tech.mai.events.consumer.WeatherConsumer;
import com.tech.mai.events.consumer.domain.Forecast;
import com.tech.mai.events.service.domain.EventAndForecast;
import com.tech.mai.events.service.domain.Events;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

/**
 * Created by Aamirio on 18/12/2016.
 */
public class EventsServiceHandler implements EventsService {

    EventsConsumer eventsConsumer = new EventsConsumer();
    WeatherConsumer weatherConsumer = new WeatherConsumer();

    @Override
    public Events getEventsByCategory(String category) {
        List<Event> events = eventsConsumer.getEventsByCategory(category);

        return new Events(getForecastsForEvents(events));
    }

    @Override
    public Events getEventsByDate(String date) {
        List<Event> events = eventsConsumer.getEventsByDate(date);

        return new Events(getForecastsForEvents(events));
    }

    private List<EventAndForecast> getForecastsForEvents(List<Event> events) {
        List<EventAndForecast> eventsAndForecasts = new ArrayList<EventAndForecast>();

        for (Event event : events) {
            Forecast forecast = null;
            Long noOfDays = getNoOfDaysFromNow(event.getStartTime());

            List<Forecast> forecasts =
                    weatherConsumer.getWeatherByLocation(
                            event.getVenueLatitude(),
                            event.getVenueLongitude(),
                            noOfDays.intValue() + 1)
                            .getList();

            forecast = noOfDays > 15 ? forecasts.get(15) : forecasts.get(noOfDays.intValue());
            eventsAndForecasts.add(new EventAndForecast(event, forecast));
        }

        return eventsAndForecasts;
    }

    private long getNoOfDaysFromNow(Date eventDate) {
        LocalDate eventLocalDate = eventDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        long noOfDays = DAYS.between(LocalDate.now(), eventLocalDate);

        if (noOfDays < 1) { noOfDays = 0L; }
        if (noOfDays > 15) { noOfDays = 15L; }
        return noOfDays;
    }


}
