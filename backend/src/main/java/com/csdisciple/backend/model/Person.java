package com.csdisciple.backend.model;

import java.util.UUID;

public class Person {
    UUID id;
    String name;

    public UUID getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
}
