package com.hackerrank.github.repository;

import com.hackerrank.github.model.Event;
import org.springframework.data.repository.CrudRepository;

public interface RepoRepository extends CrudRepository<Event, Long> {
}
