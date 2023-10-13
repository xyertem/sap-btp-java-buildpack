package com.example.demojava.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

//presistance
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Optional;


@Entity
@Table(name="Employee", schema = "DEMOJAVA")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Employee {
    @Id
    private String id;

    @NotNull
    @Column(name= "name")
    private String name;
    @NotNull
    @Column(name = "lastName")
    private String lastname;

    @OneToOne
    @JoinColumn(name = "Company" , referencedColumnName = "id", nullable = false)
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
