package com.example.demojava.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("employees")
public class Employee {
    @Id
    private String id;

    private String name;

    private String lastname;

    public Employee() { //Default consroctor
    }

    public Employee(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
