package com.bridgelabz.employeeroll.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @GetMapping("/")
    public String getMessage() {
        return "Welcome to Employee Payroll App";
    }

}