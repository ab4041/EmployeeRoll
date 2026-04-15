package com.bridgelabz.employeeroll.repository;

import com.bridgelabz.employeeroll.model.EmployeePayrollData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeePayrollRepository
        extends JpaRepository<EmployeePayrollData, Integer> {

    Optional<EmployeePayrollData> findByName(String name);
}