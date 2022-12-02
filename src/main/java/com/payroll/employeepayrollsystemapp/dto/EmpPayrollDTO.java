package com.payroll.employeepayrollsystemapp.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public class EmpPayrollDTO {
    @NotEmpty(message = "Employee name cannot be null")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-z]{3,}$", message = "employee name must be start with capital letter and minimum 3 char")
    public   String name;
    public long salary;
    public String gender;
    public LocalDate startDate;
    public String note;
    public String profilePic;

    public EmpPayrollDTO(String name, long salary, String gender, LocalDate startDate, String note, String profilePic) {
        this.name = name;
        this.salary = salary;
        this.gender = gender;
        this.startDate = startDate;
        this.note = note;
        this.profilePic = profilePic;
    }


}
