package com.bridgelabz.employeeroll.service;

import com.bridgelabz.employeeroll.dto.EmployeePayrollDTO;
import com.bridgelabz.employeeroll.model.EmployeePayrollData;

import java.util.List;

public interface IEmployeePayrollService {

    List<EmployeePayrollData> getEmployeePayrollData();

    EmployeePayrollData getEmployeePayrollDataById(int empId);

    EmployeePayrollData getEmployeePayrollDataByName(String name);

    EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO dto);

    EmployeePayrollData updateEmployeePayrollData(int empId,
                                                  EmployeePayrollDTO dto);

    void deleteEmployeePayrollData(int empId);
}