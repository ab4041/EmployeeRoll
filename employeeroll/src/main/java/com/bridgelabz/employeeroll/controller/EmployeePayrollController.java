package com.bridgelabz.employeeroll.controller;

import com.bridgelabz.employeeroll.dto.EmployeePayrollDTO;
import com.bridgelabz.employeeroll.model.EmployeePayrollData;
import com.bridgelabz.employeeroll.service.IEmployeePayrollService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    IEmployeePayrollService employeePayrollService;

    @PostMapping("/create")
    public EmployeePayrollData createEmployeePayrollData(
            @RequestBody EmployeePayrollDTO dto) {

        return employeePayrollService.createEmployeePayrollData(dto);
    }

}