package com.example.demojava.resource;

import com.example.demojava.model.Company;

public class EmployeeRequest {

    private  String employeeId;
    private  String name;

    private  String lastname;

    private  String companyId;

    public EmployeeRequest(String employeeId) {
        this.employeeId = employeeId;
    }

    public EmployeeRequest(String name, String lastname, String companyId) {
        this.name = name;
        this.lastname = lastname;
        this.companyId = companyId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getCompanyId() { return companyId; }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }


}
