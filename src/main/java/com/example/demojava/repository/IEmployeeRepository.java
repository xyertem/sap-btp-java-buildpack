package com.example.demojava.repository;

import com.example.demojava.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IEmployeeRepository extends MongoRepository<Employee,String> {
}
