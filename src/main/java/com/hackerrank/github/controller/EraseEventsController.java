package com.hackerrank.github.controller;

import com.hackerrank.github.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("erase")
public class EraseEventsController {

    @Autowired
    private EventService eventService;

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteAll() {
        eventService.deleteAll();
    }
}
