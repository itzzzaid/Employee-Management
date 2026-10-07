package com.example.Employee_management.repository;

import com.example.Employee_management.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee,String> {


}
