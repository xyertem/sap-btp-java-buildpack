package com.example.demojava.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Optional;

@Document("employees")
public class Employee {
    @Id
    private String id;

    private String name;

    private String lastname;

    @DBRef
    private Company company;

    public Employee() { //Default consroctor
    }

    public Employee(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }


    public Company getCompany() { return company; }

    public void setCompany(Company company) { this.company = company; }

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
