package com.hackerrank.github.service;


import com.hackerrank.github.comum.validation.ValidationException;
import com.hackerrank.github.dto.EventDto;
import com.hackerrank.github.model.Event;
import com.hackerrank.github.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EntityManager entityManager;

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
            throw new ValidationException("Event Id Already exists.");
        }
    }

    public List<Event> getAll() {
        return (List<Event>) eventRepository.findAll();
    }

    public List<EventDto> getByActor(Long actorId) {
        List<EventDto> events = eventRepository.getByActorId(actorId);
        return events;
    }
}
