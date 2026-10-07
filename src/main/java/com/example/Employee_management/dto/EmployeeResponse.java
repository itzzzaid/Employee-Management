package com.example.Employee_management.dto;

import lombok.Data;

@Data
public class EmployeeResponse {

    private String id;
    private String name;
    private String email;
    private String department;
    private double salary;


}
