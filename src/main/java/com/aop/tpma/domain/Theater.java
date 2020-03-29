package com.aop.tpma.domain;

import javax.persistence.*;

/**
 * Entities in JPA are nothing but POJOs representing data that can be persisted to the database.
 * An entity represents a table stored in a database.
 * Every instance of an entity represents a row in the table.
 */
@Entity
@Table(name = "theater")
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
