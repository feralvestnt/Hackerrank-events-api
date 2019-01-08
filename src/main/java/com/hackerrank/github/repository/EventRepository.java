package com.hackerrank.github.repository;

import com.hackerrank.github.model.Event;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventRepository extends CrudRepository<Event, Long>, EventRepositoryCustom {

    List<Event> getByActorId(Long actorId);
}
