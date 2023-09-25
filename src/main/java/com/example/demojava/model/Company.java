package com.example.demojava.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("companies")
public class Company {

    @Id
    private String id;

    private String companyName;

    private String adress;

    public Company() {
    }

    public Company(String companyName, String adress) {

        this.companyName = companyName;
        this.adress = adress;
    }

    public String getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getAdress() {
        return adress;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
