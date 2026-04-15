package com.bridgelabz.employeeroll.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

import lombok.Data;

@Data
public class EmployeePayrollDTO {

    @NotEmpty(message = "Employee name cannot be empty")

    @Pattern(
            regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",
            message = "Employee name must start with capital letter and contain minimum 3 characters"
    )
    private String name;


    @Min(value = 500, message = "Salary must be greater than 500")
    private double salary;

}