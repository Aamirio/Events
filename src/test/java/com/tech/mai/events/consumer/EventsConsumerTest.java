package com.tech.mai.events.consumer;

import com.evdb.javaapi.data.Event;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by Aamirio on 18/12/2016.
 */
public class EventsConsumerTest {

    private static final Logger log = LoggerFactory.getLogger(EventsConsumerTest.class);

    private EventsConsumer eventsConsumer = new EventsConsumer();

    @Test
    public void getEventsByCategory() {
        List<Event> events = eventsConsumer.getEventsByCategory("schools_alumni");
        assertEvents(events);
    }

    @Test
    public void getEventsByDate() {
        List<Event> events = eventsConsumer.getEventsByDate("Future");
        assertEvents(events);
    }

    private void assertEvents(List<Event> events) {

        assertNotNull(events);
        assertTrue(events.size() > 0);

        for(Event event : events) {
            assertNotNull(event);
            assertNotNull(event.getTitle());
            assertNotNull(event.getStartTime());
            assertNotNull(event.getVenue());
            assertNotNull(event.getVenue().getLongitude());
            assertNotNull(event.getVenue().getLatitude());

            log.info("\n\tTitle: " + event.getTitle()
                    + "\n\tVenue: " + event.getVenue().getName()
                    + "\n\tLongitude: " + event.getVenue().getLongitude()
                    + "\n\tLatitude: " + event.getVenue().getLatitude()
                    + "\n\tDate: " + event.getStartTime());
        }
    }

}
