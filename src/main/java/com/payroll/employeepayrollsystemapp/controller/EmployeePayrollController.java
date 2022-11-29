package com.payroll.employeepayrollsystemapp.controller;

import com.payroll.employeepayrollsystemapp.model.EmployeePayrollDataModel;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/epayrollapi")
public class EmployeePayrollController {

    @RequestMapping(value = {"", "/", "/home"})
    public String welcomeMsg() {
        return "welcome  to EmployeePayroll App";
    }
    //UC1
    @GetMapping("/get/{empId}")
    public String getEmployeePayrollData(@PathVariable("empId") int empId){
        return " get the data successful "  ;
    }
    @PostMapping("/post")
    public String addEmployeePayrollData(@RequestBody EmployeePayrollDataModel emp){
        return  emp.toString();
    }
    @PutMapping("/update")
    public String updateEmployeePayrollData(@RequestBody EmployeePayrollDataModel emp){
        return  "update employee data" + emp.toString();
    }
    @DeleteMapping("/delete/{empId}")
    public String deleteEmployeePayrollData(@PathVariable EmployeePayrollDataModel emp){
        return  "delete employee data for  " ;
    }
}
