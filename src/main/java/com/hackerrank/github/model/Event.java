package com.hackerrank.github.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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

    @Column(name = "CREATED_AT")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp created_at;

    public Event() {
    }

    public Event(Long id, String type, Actor actor, Repo repo, Timestamp created_at) {
        this.id = id;
        this.type = type;
        this.actor = actor;
        this.repo = repo;
        this.created_at = created_at;
    }

}
