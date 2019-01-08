package com.hackerrank.github.model;

import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@SequenceGenerator(name="ACTOR_ID_SEQ", sequenceName="ACTOR_ID_SEQ", allocationSize = 1)
@Table(name = "ACTOR")
public class Actor {

    @Id
    @GeneratedValue(generator = "ACTOR_ID_SEQ", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "AVATAR")
    private String avatar;

    @OneToMany(mappedBy="actor", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private List<Event> listaCampanhasEleitor;

    public Actor() {
    }

    public Actor(Long id, String login, String avatar) {
        this.id = id;
        this.login = login;
        this.avatar = avatar;
    }

}
