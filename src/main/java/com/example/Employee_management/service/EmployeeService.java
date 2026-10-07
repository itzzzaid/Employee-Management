package com.example.Employee_management.service;

import com.example.Employee_management.dto.EmployeeRequest;
import com.example.Employee_management.dto.EmployeeResponse;
import com.example.Employee_management.dto.EmployeeUpdateRequest;
import com.example.Employee_management.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Employee saveEmployee(EmployeeRequest employeeRequest);

    List<EmployeeResponse> getAllEmployees();

    EmployeeResponse getEmployeeById(String id);

    Employee updateEmployee(String id, EmployeeUpdateRequest employeeUpdateRequest);

    void deleteEmployee(String id);

}