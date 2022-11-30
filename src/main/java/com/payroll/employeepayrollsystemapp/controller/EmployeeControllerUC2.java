package com.payroll.employeepayrollsystemapp.controller;

import com.payroll.employeepayrollsystemapp.model.EmployeePayrollDataModel;
import com.payroll.employeepayrollsystemapp.service.EmpPayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/epayrolluc2api")
public class EmployeeControllerUC2 {

    @Autowired
    //UC2
    EmpPayrollService empService;
    //display welcome msg
    @GetMapping("/welcome")
    public String welcomeMsg() {
        return empService.welcomeMsg();
    }
    //save the employee data
    @PostMapping("/save")
    public EmployeePayrollDataModel insertEmpData(@RequestBody EmployeePayrollDataModel empObj){
        return empService.addEmpData(empObj);
    }
    //fetch the data by id
    @GetMapping("/getdata/{id}")
    public EmployeePayrollDataModel fetchEmpData(@PathVariable int id){
        return empService.getEmpData(id);
    }
    //fetching all the data
    @GetMapping("/getalldata")
    public List<EmployeePayrollDataModel> fetchAllEmData(){
        return empService.getAllEmpData();
    }
    //update the exist employee data
    @PutMapping("/updatedata/{id}")
    public EmployeePayrollDataModel updateEmpData(@RequestBody EmployeePayrollDataModel empObj,@PathVariable int id){
        return empService.updateEmpData(empObj,id);
    }
    //delete the data
    @DeleteMapping("/deletedata/{empId}")
    public void deleteEmployeePayrollData(@PathVariable int empId){
        empService.deleteEmpData(empId);
    }


}
