package com.bridgelabz.employeeroll.service;

import com.bridgelabz.employeeroll.dto.EmployeePayrollDTO;
import com.bridgelabz.employeeroll.model.EmployeePayrollData;

public interface IEmployeePayrollService {

    EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO dto);

}