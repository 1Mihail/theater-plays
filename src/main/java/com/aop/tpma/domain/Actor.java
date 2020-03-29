package com.aop.tpma.domain;

import com.aop.tpma.util.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "actor")
@Getter
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private Gender gender;

    @Column(nullable = false, name = "date_of_birth")
    private Date dateOfBirth;

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "actors")
    private Set<Play> plays;
}
