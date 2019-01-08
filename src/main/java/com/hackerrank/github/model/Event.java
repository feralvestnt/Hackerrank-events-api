package com.hackerrank.github.model;

import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "EVENT")
public class Event {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "TYPE")
    private String type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_ACTOR", nullable = false, foreignKey = @ForeignKey(name = "FK_ACTOR_EVENT"))
    private Actor actor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_REPO", nullable = false, foreignKey = @ForeignKey(name = "FK_REPO_EVENT"))
    private Repo repo;

    @Column(name = "created_at")
    private Timestamp createdAt;

    public Event() {
    }

    public Event(Long id, String type, Actor actor, Repo repo, Timestamp createdAt) {
        this.id = id;
        this.type = type;
        this.actor = actor;
        this.repo = repo;
        this.createdAt = createdAt;
    }

}
