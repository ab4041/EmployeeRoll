package com.bridgelabz.employeeroll.service;

import com.bridgelabz.employeeroll.dto.EmployeePayrollDTO;
import com.bridgelabz.employeeroll.exception.EmployeePayrollException;
import com.bridgelabz.employeeroll.model.EmployeePayrollData;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

    // Memory storage list (UC3)
    private List<EmployeePayrollData> employeeList = new ArrayList<>();

    // Auto increment employee ID
    private int empIdCounter = 1;


    // Get all employees
    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {

        return employeeList;
    }


    // Get employee by ID
    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {

        return employeeList.stream()
                .filter(emp -> emp.getId() == empId)
                .findFirst()
                .orElseThrow(() ->
                        new EmployeePayrollException(
                                "Employee not found with ID: " + empId
                        )
                );
    }


    // Create employee
    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO dto) {

        EmployeePayrollData empData =
                new EmployeePayrollData(
                        empIdCounter++,
                        dto.getName(),
                        dto.getSalary()
                );

        employeeList.add(empData);

        return empData;
    }


    // Update employee
    @Override
    public EmployeePayrollData updateEmployeePayrollData(
            int empId,
            EmployeePayrollDTO dto
    ) {

        EmployeePayrollData empData =
                this.getEmployeePayrollDataById(empId);

        empData.setName(dto.getName());
        empData.setSalary(dto.getSalary());

        return empData;
    }


    // Delete employee
    @Override
    public void deleteEmployeePayrollData(int empId) {

        EmployeePayrollData empData =
                this.getEmployeePayrollDataById(empId);

        employeeList.remove(empData);
    }
}