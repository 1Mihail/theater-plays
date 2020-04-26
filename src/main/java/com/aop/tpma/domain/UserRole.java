package com.aop.tpma.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "user_role")
@Getter
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true, nullable = false)
    private String name;

    @JsonIgnore
    @OneToOne(mappedBy = "userRole")
    private User user;

    public UserRole() {
    }
    public UserRole(String name) {
        this.name = name;
    }
}
