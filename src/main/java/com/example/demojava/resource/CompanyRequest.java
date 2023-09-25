package com.example.demojava.resource;

public class CompanyRequest {

    private final String companyName;

    private final String Adress;

    public CompanyRequest(String companyName, String adress) {
        this.companyName = companyName;
        Adress = adress;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getAdress() {
        return Adress;
    }
}
