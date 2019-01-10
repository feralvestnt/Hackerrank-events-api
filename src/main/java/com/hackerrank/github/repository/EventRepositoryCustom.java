package com.hackerrank.github.repository;

import com.hackerrank.github.model.Event;

import java.util.List;

public interface EventRepositoryCustom {

    List<Event> getAllByActorId(Long actorId);

    List<Event> getAll();
}
