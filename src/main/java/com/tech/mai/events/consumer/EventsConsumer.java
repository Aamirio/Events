package com.tech.mai.events.consumer;

import com.evdb.javaapi.data.Event;
import com.evdb.javaapi.data.SearchResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by Aamirio on 18/12/2016.
 */
public class EventsConsumer {

    private static final Logger log = LoggerFactory.getLogger(EventsConsumer.class);
    private static final String URL_LONDON_EVENTS =
            "http://api.eventful.com/rest/events/search?...&app_key=mXxS9r5HSV6664Kx&sort_order=date&location=London%s%s";

    public List<Event> getEventsByCategory(String category) {
        log.info("getEventsByCategory(" + category + ")");

        return getEventsBy("&category=", category);
    }

    public List<Event> getEventsByDate(String date) {
        log.info("getEventsByDate(" + date + ")");

        return getEventsBy("&date=", date);
    }

    private List<Event> getEventsBy(String predicate, String value) {

        final String url = String.format(URL_LONDON_EVENTS, predicate, value);
        List<Event> events = new RestTemplate().getForObject(url, SearchResult.class).getEvents();

        log.info(String.format("%d events retrieved for %s ", events.size(), value));
        return events;
    }

}
