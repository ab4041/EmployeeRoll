package com.bridgelabz.employeeroll.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeePayrollExceptionResponse {

    private int statusCode;
    private String message;
}