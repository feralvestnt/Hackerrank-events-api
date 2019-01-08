package com.hackerrank.github.repository;

import com.hackerrank.github.dto.EventDto;
import com.hackerrank.github.model.Event;
import static com.hackerrank.github.model.QEvent.event;
import static com.hackerrank.github.model.QActor.actor;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.EntityManager;
import java.util.List;


public class EventRepositoryImpl {

    @Autowired
    EntityManager entityManager;

    public List<EventDto> getByActorId(Long actorId) {
        return new JPAQueryFactory(entityManager)
            .select(Projections.constructor(
                EventDto.class,
                event.id,
                event.type
            ))
            .from(event)
            .join(event.actor, actor)
            .where(actor.id.eq(actorId))
            .fetch();
    }

}
