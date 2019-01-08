package com.hackerrank.github.repository;

import com.hackerrank.github.dto.EventDto;
import com.hackerrank.github.model.Event;

import java.util.List;

public interface EventRepositoryCustom {

    List<EventDto> getByActorId(Long actorId);
}
