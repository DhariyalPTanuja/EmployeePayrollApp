package com.payroll.employeepayrollsystemapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
@Entity   //structure define
@Table(name = "employee_data")
public class EmployeePayrollDataModel {
    @Id                     //Primary key define
    @GeneratedValue          // auto increment id
    private int empId;
    private  String name;
    private long salary;
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;

    public EmployeePayrollDataModel() {
    }

    public EmployeePayrollDataModel(int empId, String name, long salary, String gender, LocalDate startDate, String note, String profilePic) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
        this.gender = gender;
        this.startDate = startDate;
        this.note = note;
        this.profilePic = profilePic;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    @Override
    public String toString() {
        return "EmployeePayrollDataModel{" +
                "empId=" + empId +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", gender='" + gender + '\'' +
                ", startDate=" + startDate +
                ", note='" + note + '\'' +
                ", profilePic='" + profilePic + '\'' +
                '}';
    }
}
