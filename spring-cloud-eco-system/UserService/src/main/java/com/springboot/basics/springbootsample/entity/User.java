package com.springboot.basics.springbootsample.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String email;

    protected User() {

    }

    public User(String name, String email) {
        super();
        this.name = name;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return String.format("User [id=%s, name=%s, role=%s]", id, name, email);
    }
}