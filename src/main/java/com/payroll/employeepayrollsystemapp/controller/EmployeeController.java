package com.payroll.employeepayrollsystemapp.controller;

import com.payroll.employeepayrollsystemapp.dto.EmpPayrollDTO;
import com.payroll.employeepayrollsystemapp.dto.ResponseDTO;
import com.payroll.employeepayrollsystemapp.model.EmployeePayrollDataModel;
import com.payroll.employeepayrollsystemapp.repository.EmpPayrollRepo;
import com.payroll.employeepayrollsystemapp.service.IEmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    //using @Valid annotation for apply validation
    @PostMapping("/saveresopnse")
    public ResponseEntity<ResponseDTO> insertEmpDataUseResponse(@Valid @RequestBody EmpPayrollDTO empDto){
        EmployeePayrollDataModel employeeModel = empService.addEmpDataDto(empDto);
        ResponseDTO responseDTO = new ResponseDTO("New employee added",employeeModel);
        ResponseEntity<ResponseDTO> response = new ResponseEntity<>(responseDTO, HttpStatus.OK);
        return response;
    }
    //fetch the data by id
    @GetMapping("/getdata/{id}")
    public EmployeePayrollDataModel fetchEmpData(@PathVariable int id){
        empModelList.add(empService.getEmpData(id));
        return empService.getEmpData(id);
    }
    //get data -using ResponseDto
    @GetMapping("/getdataresponse/{id}")
    public ResponseEntity<ResponseDTO> fetchEmpDataResponse(@PathVariable int id){
        EmployeePayrollDataModel employeeModel = empService.getEmpData(id);
        ResponseDTO responseDTO = new ResponseDTO("fetch employee record by id",employeeModel);
        ResponseEntity<ResponseDTO> response = new ResponseEntity<>(responseDTO, HttpStatus.OK);
        return response;
    }


    //fetching all the data
    @GetMapping("/getalldata")
    public List<EmployeePayrollDataModel> fetchAllEmData(){
        return empService.getAllEmpData();
    }
    //update the exist employee data
    @PutMapping("/updatedata/{id}")
    public EmployeePayrollDataModel updateEmpDataDto(@Valid @RequestBody EmpPayrollDTO empDto,@PathVariable int id){
        empModelList.add(empService.updateEmpDataDto(empDto,id));
        return empService.updateEmpDataDto(empDto,id);
    }
    //delete the data
    @DeleteMapping("/deletedata/{empId}")
    public void deleteEmployeePayrollData(@PathVariable int empId){
        empService.deleteEmpData(empId);
    }

}
