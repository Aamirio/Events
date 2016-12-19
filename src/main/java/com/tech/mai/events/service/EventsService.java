package com.tech.mai.events.service;

import com.tech.mai.events.service.domain.Events;

/**
 * Created by Aamirio on 19/12/2016.
 */
public interface EventsService {

    public Events getEventsByCategory(String category);

    public Events getEventsByDate(String date);
}
