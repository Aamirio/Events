package com.tech.mai.events.service;

import com.tech.mai.events.service.domain.Events;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by Aamirio on 19/12/2016.
 */
public class EventsServiceHandlerTest {

    private EventsServiceHandler eventsServiceHandler = new EventsServiceHandler();

    @Test
    public void getEventsByCategory() {
        Events events = eventsServiceHandler.getEventsByCategory("schools_alumni");
        assertEvents(events);
    }

    @Test
    public void getEventsByDate() {
        Events events = eventsServiceHandler.getEventsByDate("Future");
        assertEvents(events);

    }

    private void assertEvents(Events events) {
        assertNotNull(events);
        assertNotNull(events.getEventAndForecastList());
        assertTrue(events.getEventAndForecastList().size() > 0);
    }

}
