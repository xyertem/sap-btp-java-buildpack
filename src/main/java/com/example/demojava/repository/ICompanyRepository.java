package com.example.demojava.repository;

import com.example.demojava.model.Company;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ICompanyRepository extends MongoRepository<Company, String> {
}
