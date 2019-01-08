package com.hackerrank.github.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@SequenceGenerator(name="REPO_ID_SEQ", sequenceName="REPO_ID_SEQ", allocationSize = 1)
@Table(name = "REPO")
public class Repo {

    @Id
    @GeneratedValue(generator = "REPO_ID_SEQ", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "URL")
    private String url;

    @OneToMany(mappedBy="repo", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private List<Event> listaCampanhasEleitor;

    public Repo() {
    }

    public Repo(Long id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }

}
