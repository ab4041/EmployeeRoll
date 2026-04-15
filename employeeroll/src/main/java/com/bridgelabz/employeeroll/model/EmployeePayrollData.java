package com.bridgelabz.employeeroll.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employee_payroll")
public class EmployeePayrollData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private double salary;


    public EmployeePayrollData() {
    }


    public EmployeePayrollData(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public double getSalary() {
        return salary;
    }


    public void setSalary(double salary) {
        this.salary = salary;
    }
}