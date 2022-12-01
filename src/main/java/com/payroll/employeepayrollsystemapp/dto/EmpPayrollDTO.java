package com.payroll.employeepayrollsystemapp.dto;

import java.time.LocalDate;

public class EmpPayrollDTO {
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
