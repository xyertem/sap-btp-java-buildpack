package com.example.demojava.controller;

import com.example.demojava.model.Company;
import com.example.demojava.model.Employee;
import com.example.demojava.repository.ICompanyRepository;
import com.example.demojava.repository.IEmployeeRepository;
import com.example.demojava.resource.EmployeeRequest;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {


    private final Employee employee_;
    private final IEmployeeRepository employeeRepository;
    private final ICompanyRepository companyRepository;

    @Autowired
    public EmployeeController(IEmployeeRepository employeeRepository, ICompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
        this.employeeRepository = employeeRepository;
        this.employee_ = new Employee();
    }

    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        return ResponseEntity.ok(this.employeeRepository.findAll());
    }

    @PostMapping("/employee")
    public ResponseEntity<Object> createEmployee(@RequestBody @NotNull EmployeeRequest employeeRequest){
        employee_.setName(employeeRequest.getName());
        employee_.setLastname(employeeRequest.getLastname());
        String id = employeeRequest.getCompanyId();
        if(!id.isEmpty()){
            Optional<Company> optionalCompany = this.companyRepository.findById(id);
            employee_.setCompany(optionalCompany.get()); //Private company request
        }else{
            return ResponseEntity.status(400).body(new Error().getMessage());
        }
        return ResponseEntity.status(201).body(this.employeeRepository.save(employee_));
    }

    @GetMapping("/employee/{id}")
    public  ResponseEntity<Employee> getEmployeeById(@PathVariable String id){

        Optional<Employee> employee = employeeRepository.findById(id);

        if(employee.isPresent()){
            return ResponseEntity.ok(employee.get());
        }
        return ResponseEntity.status(400).body(employee.get());
    }
}
