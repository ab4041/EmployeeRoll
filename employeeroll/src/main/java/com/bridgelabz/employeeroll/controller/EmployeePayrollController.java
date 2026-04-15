package com.bridgelabz.employeeroll.controller;

import com.bridgelabz.employeeroll.dto.EmployeePayrollDTO;
import com.bridgelabz.employeeroll.dto.ResponseDTO;
import com.bridgelabz.employeeroll.model.EmployeePayrollData;
import com.bridgelabz.employeeroll.service.IEmployeePayrollService;

import jakarta.validation.Valid;

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


    // Welcome API
    @GetMapping("/")
    public ResponseDTO getMessage() {

        log.info("Received request for welcome message");

        return new ResponseDTO(
                "Welcome to Employee Payroll App",
                null
        );
    }


    // Get all employees
    @GetMapping("/get")
    public ResponseDTO getEmployeePayrollData() {

        log.info("Fetching all employees");

        List<EmployeePayrollData> empList =
                employeePayrollService.getEmployeePayrollData();

        return new ResponseDTO(
                "Fetched all employees successfully",
                empList
        );
    }


    // Get employee by ID
    @GetMapping("/get/{empId}")
    public ResponseDTO getEmployeePayrollDataById(
            @PathVariable int empId
    ) {

        log.info("Fetching employee with ID {}", empId);

        EmployeePayrollData empData =
                employeePayrollService.getEmployeePayrollDataById(empId);

        return new ResponseDTO(
                "Employee fetched successfully",
                empData
        );
    }


    // Get employee by name (UC11 feature)
    @GetMapping("/find/{name}")
    public ResponseDTO getEmployeePayrollDataByName(
            @PathVariable String name
    ) {

        log.info("Fetching employee with name {}", name);

        EmployeePayrollData empData =
                employeePayrollService.getEmployeePayrollDataByName(name);

        return new ResponseDTO(
                "Employee fetched successfully",
                empData
        );
    }


    // Create employee
    @PostMapping("/create")
    public ResponseDTO createEmployeePayrollData(
            @Valid @RequestBody EmployeePayrollDTO dto
    ) {

        log.info("Creating employee {}", dto);

        EmployeePayrollData empData =
                employeePayrollService.createEmployeePayrollData(dto);

        return new ResponseDTO(
                "Employee created successfully",
                empData
        );
    }


    // Update employee
    @PutMapping("/update/{empId}")
    public ResponseDTO updateEmployeePayrollData(
            @PathVariable int empId,
            @Valid @RequestBody EmployeePayrollDTO dto
    ) {

        log.info("Updating employee {}", empId);

        EmployeePayrollData empData =
                employeePayrollService.updateEmployeePayrollData(empId, dto);

        return new ResponseDTO(
                "Employee updated successfully",
                empData
        );
    }


    // Delete employee
    @DeleteMapping("/delete/{empId}")
    public ResponseDTO deleteEmployeePayrollData(
            @PathVariable int empId
    ) {

        log.info("Deleting employee {}", empId);

        employeePayrollService.deleteEmployeePayrollData(empId);

        return new ResponseDTO(
                "Employee deleted successfully",
                "Deleted ID: " + empId
        );
    }
}