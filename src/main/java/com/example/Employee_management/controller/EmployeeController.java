package com.example.Employee_management.controller;


import com.example.Employee_management.dto.EmployeeRequest;
import com.example.Employee_management.dto.EmployeeResponse;
import com.example.Employee_management.dto.EmployeeUpdateRequest;
import com.example.Employee_management.entity.Employee;
import com.example.Employee_management.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public Employee saveEmployee(@Valid @RequestBody EmployeeRequest employeeRequest) {  // take data from json and convert into
                                                                         //employee obj
            return employeeService.saveEmployee(employeeRequest);

        }

        @GetMapping
    public List<EmployeeResponse> getAllEmployees(){
        return employeeService.getAllEmployees();
        }

    @GetMapping("/{id}")
    public EmployeeResponse getEmployeeById(@PathVariable String id) {
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(
            @PathVariable String id,@Valid @RequestBody EmployeeUpdateRequest employeeUpdateRequest) {
        return employeeService.updateEmployee(id,employeeUpdateRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable String id){
        employeeService.deleteEmployee(id);
    }







}
