package com.example.demojava.resource;

public class EmployeeRequest {

    private String name;

    private String lastname;

    public EmployeeRequest(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }
}
