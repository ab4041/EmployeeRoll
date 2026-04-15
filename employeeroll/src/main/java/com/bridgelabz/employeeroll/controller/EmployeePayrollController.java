package com.bridgelabz.employeeroll.controller;

import com.bridgelabz.employeeroll.dto.EmployeePayrollDTO;
import com.bridgelabz.employeeroll.model.EmployeePayrollData;
import com.bridgelabz.employeeroll.service.IEmployeePayrollService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService employeePayrollService;


    @GetMapping("/")
    public String getMessage() {

        log.info("Received request for welcome message");

        return "Welcome to Employee Payroll App";
    }


    @GetMapping("/get")
    public List<EmployeePayrollData> getEmployeePayrollData() {

        log.info("Fetching all employee payroll data");

        return employeePayrollService.getEmployeePayrollData();
    }


    @GetMapping("/get/{empId}")
    public EmployeePayrollData getEmployeePayrollDataById(
            @PathVariable int empId) {

        log.info("Fetching employee data for ID: {}", empId);

        return employeePayrollService
                .getEmployeePayrollDataById(empId);
    }


    @PostMapping("/create")
    public EmployeePayrollData createEmployeePayrollData(
            @RequestBody EmployeePayrollDTO dto) {

        log.info("Creating employee: {}", dto);

        return employeePayrollService
                .createEmployeePayrollData(dto);
    }


    @PutMapping("/update/{empId}")
    public EmployeePayrollData updateEmployeePayrollData(
            @PathVariable int empId,
            @RequestBody EmployeePayrollDTO dto) {

        log.info("Updating employee ID: {}", empId);

        return employeePayrollService
                .updateEmployeePayrollData(empId, dto);
    }


    @DeleteMapping("/delete/{empId}")
    public void deleteEmployeePayrollData(
            @PathVariable int empId) {

        log.info("Deleting employee ID: {}", empId);

        employeePayrollService
                .deleteEmployeePayrollData(empId);
    }
}