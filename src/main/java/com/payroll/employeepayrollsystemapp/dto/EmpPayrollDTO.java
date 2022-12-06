package com.payroll.employeepayrollsystemapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

public @ToString class EmpPayrollDTO {
    @NotEmpty(message = "Employee name cannot be null")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-z]{3,}$", message = "employee name must be start with capital letter and minimum 3 char")
    public   String name;
    @Min(value = 1500,message = "Minimum salary should be more than 1500")
    public long salary;
    @NotBlank(message = "Gender can not be empty")
    @Pattern(regexp = "male|female|other", message ="Gender needs to be male or female or other" )
    public String gender;

    @JsonFormat(pattern = "dd MMM yyyy")
    @NotNull(message = "startDate should Not be Empty")
    @PastOrPresent(message = "startDate should be past or today's date")
    public LocalDate startDate;
    @NotBlank(message = "Note can not be empty")
    public String note;
    @NotBlank(message = "profilePic can not be empty")
    public String profilePic;
    @NotNull(message = "departments should Not be Empty")
    public List<String> departments;

    public EmpPayrollDTO(String name, long salary, String gender, LocalDate startDate, String note, String profilePic, List<String> departments) {
        this.name = name;
        this.salary = salary;
        this.gender = gender;
        this.startDate = startDate;
        this.note = note;
        this.profilePic = profilePic;
        this.departments = departments;
    }


}
