package com.payroll.employeepayrollsystemapp.controller;

import com.payroll.employeepayrollsystemapp.dto.EmpPayrollDTO;
import com.payroll.employeepayrollsystemapp.model.EmployeePayrollDataModel;
import com.payroll.employeepayrollsystemapp.repository.EmpPayrollRepo;
import com.payroll.employeepayrollsystemapp.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/emppayroll")
public class EmployeeController {
    //EmpPayrollService empService;
    //before Introducing service interface we were using EmployeeService class object to execute API's and code was not abstract

    //Now we are create IEmployeeService interface object to execute API's and code is abstract
    @Autowired
    IEmployeeService empService;
    List<EmployeePayrollDataModel> empModelList = new ArrayList<>();
    //display welcome msg
    @GetMapping("/welcome")
    public String welcomeMsg() {
        return empService.welcomeMsg();
    }
    //save the employee data
    @Autowired
    EmpPayrollRepo empRepo;
    @PostMapping("/savedto")
    public EmployeePayrollDataModel insertEmpDataUseDto(@RequestBody EmpPayrollDTO empDto){
        empModelList.add(empService.addEmpDataDto(empDto));
        return empService.addEmpDataDto(empDto);
    }
    //fetch the data by id
    @GetMapping("/getdata/{id}")
    public EmployeePayrollDataModel fetchEmpData(@PathVariable int id){
        empModelList.add(empService.getEmpData(id));
        return empService.getEmpData(id);
    }
    //fetching all the data
    @GetMapping("/getalldata")
    public List<EmployeePayrollDataModel> fetchAllEmData(){
        return empService.getAllEmpData();
    }
    //update the exist employee data
    @PutMapping("/updatedata/{id}")
    public EmployeePayrollDataModel updateEmpDataDto(@RequestBody EmpPayrollDTO empDto,@PathVariable int id){
        empModelList.add(empService.updateEmpDataDto(empDto,id));
        return empService.updateEmpDataDto(empDto,id);
    }
    //delete the data
    @DeleteMapping("/deletedata/{empId}")
    public void deleteEmployeePayrollData(@PathVariable int empId){
        empService.deleteEmpData(empId);
    }

}
