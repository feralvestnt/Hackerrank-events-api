package com.hackerrank.github.service;

import com.hackerrank.github.model.Actor;
import com.hackerrank.github.repository.ActorRepository;
import com.hackerrank.github.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Actor> getStreak() {
        List<Actor> actors = (List) actorRepository.findAll();

        /*List<Actor> actors =
        events.stream()
                .collect(Collectors.groupingBy(Event::getActor))
*/
        System.out.println(actors);

        return null;
    }

}
