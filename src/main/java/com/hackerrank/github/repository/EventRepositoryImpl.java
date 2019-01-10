package com.hackerrank.github.repository;

import com.hackerrank.github.model.Event;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

import static com.hackerrank.github.model.QActor.actor;
import static com.hackerrank.github.model.QEvent.event;
import static com.hackerrank.github.model.QRepo.repo;


public class EventRepositoryImpl {

    @Autowired
    EntityManager entityManager;

    public List<Event> getAllByActorId(Long actorId) {
        return new JPAQueryFactory(entityManager)
            .select(event)
            .from(event)
            .join(event.actor, actor).fetchJoin()
            .join(event.repo, repo).fetchJoin()
            .where(actor.id.eq(actorId))
            .fetch();
    }

    public List<Event> getAll() {
        return new JPAQueryFactory(entityManager)
                .select(event)
                .from(event)
                .join(event.actor, actor).fetchJoin()
                .join(event.repo, repo).fetchJoin()
                .fetch();
    }

}
