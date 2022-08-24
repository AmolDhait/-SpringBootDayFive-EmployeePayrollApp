package com.bridgelabz.employeepayrollapp.dto;


import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;

public @ToString class EmployeePayrollDTO {


    @Pattern(regexp ="^[A-Z]{1}[a-zA-Z\\s]{2,}$",
             message = "Employee name Invalid")
    public String name;

    @Min(message = "Min Wage Should be more than 200", value=200)
    public long salary;

    public String gender;

    public String startDate;

    public String note;

    public String profilePic;

    public List<String> department;

}
