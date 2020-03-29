package com.aop.tpma.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "role")
@Getter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique=true, nullable = false)
    private String name;

    @JsonIgnore
    @OneToOne
    private User user;
}
