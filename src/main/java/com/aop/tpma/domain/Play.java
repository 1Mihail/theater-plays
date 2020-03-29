package com.aop.tpma.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Entities in JPA are nothing but POJOs representing data that can be persisted to the database.
 * An entity represents a table stored in a database.
 * Every instance of an entity represents a row in the table.
 */
@Entity
@Table(name = "play")
@Getter
public class Play {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true, nullable = false)
    private String title;

    @Column(nullable = false, length = 1000)
    private String description;

    @Column(nullable = false, name = "screening_time_start")
    private Date screeningTimeStart;

    @Column(nullable = false, name = "screening_time_end")
    private Date screeningTimeEnd;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "genres_mappings", joinColumns = {@JoinColumn(name = "play_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "genre_id", referencedColumnName = "id")})
    private Set<Genre> genres;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "actors_mappings", joinColumns = {@JoinColumn(name = "play_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "actor_id", referencedColumnName = "id")})
    private Set<Actor> actors;

    @ManyToOne
    private Room room;

    @Column(nullable = false, name = "ticket_price")
    private double ticketPrice;

    @ManyToOne
    private User createdByUser;

    public Play() {
    }
}
