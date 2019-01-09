package com.hackerrank.github.controller;

import com.hackerrank.github.model.Event;
import com.hackerrank.github.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("events")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping
    public ResponseEntity save(@RequestBody Event event) {
        eventService.save(event);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Event> getAll() {
        return eventService.getAll();
    }

    @RequestMapping(value = "/actors/{actorId}", method = RequestMethod.GET)
    public List<Event> getByActor(@PathVariable Long actorId) {
        return eventService.getByActor(actorId);
    }
}
