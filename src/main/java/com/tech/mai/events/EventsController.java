package com.tech.mai.events;

import com.tech.mai.events.service.EventsService;
import com.tech.mai.events.service.EventsServiceHandler;
import com.tech.mai.events.service.domain.Events;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/events")
public class EventsController {

    EventsService eventsService = new EventsServiceHandler();

    @RequestMapping(method= RequestMethod.GET)
    public @ResponseBody
    Events getEventsByCategory(@RequestParam(value="category", required=true) String category) {
        return eventsService.getEventsByCategory(category);
    }

    @RequestMapping(method= RequestMethod.GET)
    public @ResponseBody
    Events getEventsByDate(@RequestParam(value="date", required=true) String date) {
        return eventsService.getEventsByDate(date);
    }

}
