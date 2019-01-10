package com.hackerrank.github.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Comparator;
import java.util.List;

@Data
@Entity
@Table(name = "ACTOR")
public class Actor {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "AVATAR_URL")
    private String avatar_url;

    @JsonIgnore
    @Transient
    private List<Event> events;

    @JsonIgnore
    @Transient
    private int consecutiveDates;

    public Actor() {
    }

    public Actor(Long id, String login, String avatar) {
        this.id = id;
        this.login = login;
        this.avatar_url = avatar;
    }

    public Actor(Long id, String login, String avatar, List<Event> events) {
        this.id = id;
        this.login = login;
        this.avatar_url = avatar;
        this.events = events;
        this.events.stream().sorted(Comparator.comparing(Event::getCreated_at));

        for (int i = 0 ; i < events.size() ; i++) {
            int j = i + 1;
            if (j < events.size()) {
                if ((events.get(i).getCreated_at().toLocalDateTime().getDayOfMonth() + 1) ==
                    events.get(j).getCreated_at().toLocalDateTime().getDayOfMonth()) {
                    consecutiveDates++;
                }
            }
        }
    }
}
