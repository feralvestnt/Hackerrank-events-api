package com.hackerrank.github.service;


import com.hackerrank.github.comum.validation.ValidationException;
import com.hackerrank.github.model.Actor;
import com.hackerrank.github.model.Event;
import com.hackerrank.github.model.Repo;
import com.hackerrank.github.repository.ActorRepository;
import com.hackerrank.github.repository.EventRepository;
import com.hackerrank.github.repository.RepoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private RepoRepository repoRepository;

    public void deleteAll() {
        eventRepository.deleteAll();
    }

    public void save(Event event) {
        validateEvent(event);
        try {
            Actor actor = event.getActor();
            actorRepository.save(actor);

            Repo repo = event.getRepo();
            repoRepository.save(repo);

            eventRepository.save(event);
        } catch (RuntimeException ex) {
            System.out.println("Error saving event " + ex);
        }
    }

    public void validateEvent(Event event) {
        Optional<Event> eventOptional = eventRepository.findById(event.getId());

        if (eventOptional.isPresent()) {
            throw new ValidationException("Event Id Already exists.");
        }
    }

    public List<Event> getAll() {
        return  eventRepository.getAll();
    }

    @Transactional
    public List<Event> getByActor(Long actorId) {
        List<Event> events = eventRepository.getAllByActorId(actorId);
        return events.stream()
                .sorted(Comparator.comparing(Event::getId))
                .collect(Collectors.toList());
    }
}
