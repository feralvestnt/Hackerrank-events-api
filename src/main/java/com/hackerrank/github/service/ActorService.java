package com.hackerrank.github.service;

import com.hackerrank.github.model.Actor;
import com.hackerrank.github.model.Event;
import com.hackerrank.github.repository.ActorRepository;
import com.hackerrank.github.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ActorService {

    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private EventRepository eventRepository;

    public void save(Actor actor) {
        try {
            actorRepository.save(actor);
        } catch (RuntimeException ex) {
            System.out.println("Error saving actor " + ex);
        }
    }

    public List<Actor> getActors() {
        return getAllActors();
    }

    public List<Actor> getStreak() {
        return getAllActors();
    }

    public Map<Actor, List<Event>> getMapActorListEvent() {
        List<Event> events = (List) eventRepository.findAll();
        return
            events
            .stream()
            .collect(Collectors.groupingBy(event -> new Actor(event.getActor().getId(), event.getActor().getLogin(),
            event.getActor().getAvatar_url())));
    }

    public List<Actor> getListActors(Map<Actor, List<Event>> actorMap) {
        return
            actorMap.entrySet()
            .stream().map(a -> new Actor(a.getKey().getId(), a.getKey().getLogin(), a.getKey().getAvatar_url(),
            a.getValue()))
            .collect(Collectors.toList());
    }

    public Comparator<Actor> getComparingByEventSize() {
        return Comparator.comparing(actor -> actor.getEvents().size());
    }

    public List<Actor> getAllActors() {

        Map<Actor, List<Event>> actorListMap = getMapActorListEvent();

        List<Actor> actors = getListActors(actorListMap);

        Comparator<Actor> compEvents = getComparingByEventSize();

        compEvents = compEvents.thenComparing(
                Comparator.comparing(actor -> actor.getEvents().get(actor.getEvents().size()-1).getCreated_at()));

        compEvents = compEvents.thenComparing(Comparator.comparing(actor -> actor.getLogin())).reversed();

        List<Actor> sorted = actors.stream().sorted(compEvents).collect(Collectors.toList());

        List<Actor> newList =  sorted
                .stream()
                .map(a -> new Actor(a.getId(), a.getLogin(), a.getAvatar_url()))
                .collect(Collectors.toList());

        return newList;
    }

}