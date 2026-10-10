package com.example.Employee_management.controller;


import com.example.Employee_management.dto.EmployeeRequest;
import com.example.Employee_management.dto.EmployeeResponse;
import com.example.Employee_management.dto.EmployeeUpdateRequest;
import com.example.Employee_management.entity.Employee;
import com.example.Employee_management.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
@Tag(
        name = "Employee Management",
        description = "APIs to create, retrieve, update and delete employees"
)
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

        @Operation(summary = "Create a new employee")
        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public Employee saveEmployee(@Valid @RequestBody EmployeeRequest employeeRequest) {  // take data from json and convert into
                                                                         //employee obj
            return employeeService.saveEmployee(employeeRequest);

        }

    @Operation(
            summary = "Get all employees",
            description = "Retrieves the list of all employees"
    )

        @GetMapping
    public List<EmployeeResponse> getAllEmployees(){
        return employeeService.getAllEmployees();
        }

    @Operation(summary = "Get employee by ID")
    @GetMapping("/{id}")
    public EmployeeResponse getEmployeeById(@PathVariable String id) {
        return employeeService.getEmployeeById(id);
    }

    @Operation(summary = "Update an existing employee")
    @PutMapping("/{id}")
    public Employee updateEmployee(
            @PathVariable String id,@Valid @RequestBody EmployeeUpdateRequest employeeUpdateRequest) {
        return employeeService.updateEmployee(id,employeeUpdateRequest);
    }

    @Operation(summary = "Delete an employee")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable String id){
        employeeService.deleteEmployee(id);
    }







}
