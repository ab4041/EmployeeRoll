package com.bridgelabz.employeeroll.controller;

import com.bridgelabz.employeeroll.dto.EmployeePayrollDTO;
import com.bridgelabz.employeeroll.model.EmployeePayrollData;
import com.bridgelabz.employeeroll.service.IEmployeePayrollService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService employeePayrollService;

    @GetMapping("/")
    public String getMessage() {

        return "Welcome to Employee Payroll App";
    }

    @GetMapping("/get")
    public List<EmployeePayrollData> getEmployeePayrollData() {

        return employeePayrollService.getEmployeePayrollData();
    }

    @GetMapping("/get/{empId}")
    public EmployeePayrollData getEmployeePayrollDataById(
            @PathVariable int empId) {

        return employeePayrollService
                .getEmployeePayrollDataById(empId);
    }

    @PostMapping("/create")
    public EmployeePayrollData createEmployeePayrollData(
            @RequestBody EmployeePayrollDTO dto) {

        return employeePayrollService
                .createEmployeePayrollData(dto);
    }

    @PutMapping("/update/{empId}")
    public EmployeePayrollData updateEmployeePayrollData(
            @PathVariable int empId,
            @RequestBody EmployeePayrollDTO dto) {

        return employeePayrollService
                .updateEmployeePayrollData(empId, dto);
    }

    @DeleteMapping("/delete/{empId}")
    public void deleteEmployeePayrollData(
            @PathVariable int empId) {

        employeePayrollService
                .deleteEmployeePayrollData(empId);
    }
}