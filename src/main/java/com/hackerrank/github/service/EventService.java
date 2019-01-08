package com.hackerrank.github.service;


import com.hackerrank.github.model.Event;
import com.hackerrank.github.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public void deleteAll() {
        eventRepository.deleteAll();
    }

    public void save(Event event) {
        validateEvent(event);

        eventRepository.save(event);
    }

    public void validateEvent(Event event) {
        Optional<Event> eventOptional = eventRepository.findById(event.getId());

        if (eventOptional.isPresent()) {
            throw new RuntimeException("Event Id Already exists.");
        }
    }

    public List<Event> getAll() {
        return (List<Event>) eventRepository.findAll();
    }
}
