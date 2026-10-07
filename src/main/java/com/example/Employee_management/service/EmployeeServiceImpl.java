package com.example.Employee_management.service;

import com.example.Employee_management.dto.EmployeeRequest;
import com.example.Employee_management.dto.EmployeeResponse;
import com.example.Employee_management.dto.EmployeeUpdateRequest;
import com.example.Employee_management.entity.Employee;
import com.example.Employee_management.exception.EmployeeNotFoundException;
import com.example.Employee_management.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Override
    public Employee saveEmployee(EmployeeRequest employeeRequest) {

        Employee employee = new Employee();

        employee.setName(employeeRequest.getName());
        employee.setEmail(employeeRequest.getEmail());
        employee.setDepartment(employeeRequest.getDepartment());
        employee.setSalary(employeeRequest.getSalary());
        return employeeRepository.save(employee);
    }

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public List<EmployeeResponse> getAllEmployees() {

        List<Employee> employees = employeeRepository.findAll();

        return employees.stream()
                .map(employee -> {
                    EmployeeResponse response = new EmployeeResponse();

                    response.setId(employee.getId());
                    response.setName(employee.getName());
                    response.setEmail(employee.getEmail());
                    response.setDepartment(employee.getDepartment());
                    response.setSalary(employee.getSalary());

                    return response;
                })

                .toList();
                }

    @Override
    public EmployeeResponse getEmployeeById(String id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(
                        "Employee with id " + id + " not found"
                ));

        EmployeeResponse response = new EmployeeResponse();
        response.setId(employee.getId());
        response.setName(employee.getName());
        response.setEmail(employee.getEmail());
        response.setDepartment(employee.getDepartment());
        response.setSalary(employee.getSalary());

        return response;
    }

    @Override
    public Employee updateEmployee(String id, EmployeeUpdateRequest employeeUpdateRequest) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(
                        "Employee with id " + id + " not found"
                ));

        existingEmployee.setName(employeeUpdateRequest.getName());
        existingEmployee.setEmail(employeeUpdateRequest.getEmail());
        existingEmployee.setDepartment(employeeUpdateRequest.getDepartment());
        existingEmployee.setSalary(employeeUpdateRequest.getSalary());

        return employeeRepository.save(existingEmployee);

    }

    @Override
    public void deleteEmployee(String id){
        employeeRepository.deleteById(id);
    }
}

