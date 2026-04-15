package com.bridgelabz.employeeroll.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeePayrollExceptionHandler {


    // Handle validation errors
    @ExceptionHandler(MethodArgumentNotValidException.class)

    public ResponseEntity<EmployeePayrollExceptionResponse>
    handleValidationException(MethodArgumentNotValidException exception) {

        String errorMessage =
                exception.getBindingResult()
                        .getFieldError()
                        .getDefaultMessage();

        EmployeePayrollExceptionResponse response =
                new EmployeePayrollExceptionResponse(
                        400,
                        errorMessage
                );

        return new ResponseEntity<>(response,
                HttpStatus.BAD_REQUEST);
    }


    // Handle custom employee exceptions
    @ExceptionHandler(EmployeePayrollException.class)

    public ResponseEntity<EmployeePayrollExceptionResponse>
    handleEmployeePayrollException(EmployeePayrollException exception) {

        EmployeePayrollExceptionResponse response =
                new EmployeePayrollExceptionResponse(
                        400,
                        exception.getMessage()
                );

        return new ResponseEntity<>(response,
                HttpStatus.BAD_REQUEST);
    }
}