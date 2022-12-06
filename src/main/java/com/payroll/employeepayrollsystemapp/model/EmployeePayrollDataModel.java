package com.payroll.employeepayrollsystemapp.model;

import com.payroll.employeepayrollsystemapp.dto.EmpPayrollDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity   //structure define
@Table(name = "employee_payroll_table")
public @Data class EmployeePayrollDataModel {
    @Id                     //Primary key define
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // auto increment
    @Column(name = "employee_id")
    private int empId;
    private  String name;
    private long salary;
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;
    // to declare attribute as a List
    @ElementCollection
    @CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name="id"))
    @Column(name = "department")
    private List<String> departments;
    public EmployeePayrollDataModel() {

    }
    public EmployeePayrollDataModel(EmpPayrollDTO dtoObj) {
        this.updateEmployeePayrollDataModel(dtoObj);

    }
    public void updateEmployeePayrollDataModel(EmpPayrollDTO dtoSaveObj) {
        this.name = dtoSaveObj.name;
        this.salary = dtoSaveObj.salary;
        this.gender =dtoSaveObj.gender;
        this.startDate = dtoSaveObj.startDate;
        this.note = dtoSaveObj.note;
        this.profilePic =dtoSaveObj.profilePic;
        this.departments =dtoSaveObj.departments;
    }
//    public EmployeePayrollDataModel(int empId, EmpPayrollDTO dtoObj) {
//        this.empId = empId;
//        this.name = dtoObj.name;
//        this.salary = dtoObj.salary;
//        this.gender = dtoObj.gender;
//        this.startDate = dtoObj.startDate;
//        this.note = dtoObj.note;
//        this.profilePic =dtoObj. profilePic;
//        this.departments=dtoObj.departments;
//    }
//


}
