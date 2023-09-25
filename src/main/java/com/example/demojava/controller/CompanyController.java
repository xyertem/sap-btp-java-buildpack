package com.example.demojava.controller;

import com.example.demojava.model.Company;
import com.example.demojava.repository.ICompanyRepository;
import com.example.demojava.resource.CompanyRequest;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CompanyController {

    private final ICompanyRepository companyRepository;

    private final Company company_;

    @Autowired
    public CompanyController(ICompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
        this.company_ = new Company();
    }
    @GetMapping("/company")
    public ResponseEntity<List<Company>> getAllCompanies(){
        return ResponseEntity.ok(companyRepository.findAll());
    }

    @PostMapping("/company")
    public ResponseEntity<Company> createCompany(@RequestBody @NotNull CompanyRequest companyRequest){
        company_.setCompanyName(companyRequest.getCompanyName());
        company_.setAdress(companyRequest.getAdress());
        return  ResponseEntity.status(201).body(this.companyRepository.save(company_));
    }
}
