package com.bridgelabz.employeepayrollapp.dto;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class EmployeePayrollDTO {

    @NotEmpty(message = "Employee name cannot br null")
    public String name;

    @Min(message = "Min Wage Should be more than 200", value=200)
    public long salary;

    public String getName() {
        return name;
    }

    public long getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public EmployeePayrollDTO(String name, long salary) {
        this.name = name;
        this.salary = salary;
    }

    public EmployeePayrollDTO() {
    }

    @Override
    public String toString() {
        return "EmployeePayrollDTO" +
                "name=" + name  +
                "salary=" + salary ;
    }



}
