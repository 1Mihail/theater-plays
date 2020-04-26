package com.aop.tpma.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "theater_user")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_role_id", referencedColumnName = "id")
    private UserRole userRole;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "createdByUser")
    private Set<Play> plays;

    public User(String email, String password, String role) {
        this.email = email;
        this.password=password;
        this.userRole = new UserRole(role);
    }

    public User() {
    }
}
