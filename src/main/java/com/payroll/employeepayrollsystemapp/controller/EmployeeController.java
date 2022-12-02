package com.payroll.employeepayrollsystemapp.controller;

import com.payroll.employeepayrollsystemapp.dto.EmpPayrollDTO;
import com.payroll.employeepayrollsystemapp.model.EmployeePayrollDataModel;
import com.payroll.employeepayrollsystemapp.service.EmpPayrollService;
import com.payroll.employeepayrollsystemapp.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emppayroll")
public class EmployeeController {
    //EmpPayrollService empService;
    @Autowired
    IEmployeeService empService;

    //save the employee data
    @PostMapping("/save")
    public EmployeePayrollDataModel insertEmpData(@RequestBody EmployeePayrollDataModel emp){
        return empService.addEmpData(emp);
    }
//    //fetch the data by id
    @GetMapping("/getdata/{id}")
    public EmployeePayrollDataModel fetchEmpData(@PathVariable int id){
        return empService.getEmpData(id);
    }
//    //fetching all the data
    @GetMapping("/getalldata")
    public List<EmployeePayrollDataModel> fetchAllEmData(){
        return empService.getAllEmpData();
    }
//    //update the exist employee data
    @PutMapping("/updatedata/{id}")
    public EmployeePayrollDataModel updateEmpData(@RequestBody EmployeePayrollDataModel empObj,@PathVariable int id){
        return empService.updateEmpData(empObj,id);
    }
//    //delete the data
    @DeleteMapping("/deletedata/{empId}")
    public void deleteEmployeePayrollData(@PathVariable int empId){
        empService.deleteEmpData(empId);
    }
//
//    //UC3 introducing DTO
    @PostMapping("/savedto")
    public EmployeePayrollDataModel insertEmpDataUseDto(@RequestBody EmpPayrollDTO empDto){
        return empService.addEmpDataDto(empDto);
    }
//    // Update with DTO
    @PutMapping("/updatedata/{id}")
    public EmployeePayrollDataModel updateEmpDataDto(@RequestBody EmpPayrollDTO empDto,@PathVariable int id) {
        return empService.updateEmpDataDto(empDto, id);

    }
}
