package com.bridgelabz.employeeroll.service;

import com.bridgelabz.employeeroll.dto.EmployeePayrollDTO;
import com.bridgelabz.employeeroll.exception.EmployeePayrollException;
import com.bridgelabz.employeeroll.model.EmployeePayrollData;
import com.bridgelabz.employeeroll.repository.EmployeePayrollRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

    @Autowired
    private EmployeePayrollRepository employeePayrollRepository;


    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {

        return employeePayrollRepository.findAll();
    }


    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {

        return employeePayrollRepository
                .findById(empId)
                .orElseThrow(() ->
                        new EmployeePayrollException(
                                "Employee not found with ID: " + empId
                        ));
    }


    @Override
    public EmployeePayrollData createEmployeePayrollData(
            EmployeePayrollDTO dto
    ) {

        EmployeePayrollData empData =
                new EmployeePayrollData(
                        dto.getName(),
                        dto.getSalary()
                );

        return employeePayrollRepository.save(empData);
    }


    @Override
    public EmployeePayrollData updateEmployeePayrollData(
            int empId,
            EmployeePayrollDTO dto
    ) {

        EmployeePayrollData empData =
                this.getEmployeePayrollDataById(empId);

        empData.setName(dto.getName());
        empData.setSalary(dto.getSalary());

        return employeePayrollRepository.save(empData);
    }


    @Override
    public void deleteEmployeePayrollData(int empId) {

        EmployeePayrollData empData =
                this.getEmployeePayrollDataById(empId);

        employeePayrollRepository.delete(empData);
    }
}