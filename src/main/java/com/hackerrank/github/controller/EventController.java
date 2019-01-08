package com.hackerrank.github.controller;

import com.hackerrank.github.model.Event;
import com.hackerrank.github.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("events")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping
    public void save(@RequestBody Event event) {
        eventService.save(event);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Event> getAll() {
        return eventService.getAll();
    }
}
