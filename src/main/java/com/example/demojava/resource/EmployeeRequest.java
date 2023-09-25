package com.example.demojava.resource;

import com.example.demojava.model.Company;

public class EmployeeRequest {

    private final String name;

    private final String lastname;

    private final String companyId;

    public EmployeeRequest(String name, String lastname, String companyId) {
        this.name = name;
        this.lastname = lastname;
        this.companyId = companyId;
    }

    public String getCompanyId() { return companyId; }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }


}
