package com.bridgelabz.employeeroll.repository;

import com.bridgelabz.employeeroll.model.EmployeePayrollData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeePayrollRepository
        extends JpaRepository<EmployeePayrollData, Integer> {

    // UC11 derived query
    Optional<EmployeePayrollData> findByName(String name);


    // UC12 custom JPQL query
    @Query("SELECT e FROM EmployeePayrollData e WHERE e.salary > ?1")
    List<EmployeePayrollData> findEmployeesWithSalaryGreaterThan(double salary);
}