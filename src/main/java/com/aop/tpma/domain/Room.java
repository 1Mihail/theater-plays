package com.aop.tpma.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "room")
@Getter
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique=true, nullable = false)
    private String name;

    @Column(nullable = false, name = "number_of_seats")
    private int noOfSeats;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "room")
    private Set<Play> plays;
}
