package com.example.demojava.resource;

public class CompanyRequest {

    private final String companyName;

    private final String adress;

    public CompanyRequest(String companyName, String adress) {
        this.companyName = companyName;
        this.adress = adress;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getAdress() {
        return adress;
    }
}
