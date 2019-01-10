package com.hackerrank.github.controller;

import com.hackerrank.github.model.Actor;
import com.hackerrank.github.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("actors")
public class ActorsController {

    @Autowired
    private ActorService actorService;

    @RequestMapping(method = RequestMethod.PUT)
    public void save(@RequestBody Actor actor) {
        actorService.save(actor);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Actor> getActors() {
        return actorService.getActors();
    }

    @RequestMapping(value = "/streak", method = RequestMethod.GET)
    public List<Actor> getStreak() {
        return actorService.getStreak();
    }
}
