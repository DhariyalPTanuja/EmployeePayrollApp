package com.payroll.employeepayrollsystemapp.controller;

import com.payroll.employeepayrollsystemapp.dto.EmpPayrollDTO;
import com.payroll.employeepayrollsystemapp.dto.ResponseDTO;
import com.payroll.employeepayrollsystemapp.model.EmployeePayrollDataModel;
import com.payroll.employeepayrollsystemapp.repository.EmpPayrollRepo;
import com.payroll.employeepayrollsystemapp.service.IEmployeeService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
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
//fetching or retrieve all the data
    @GetMapping("/get")
    public ResponseEntity<ResponseDTO> fetchEmpDataResponse(){
        log.info("retrieve data from employee payroll database");
        empModelList = empService.getAllEmpData();
        ResponseDTO responseDTO = new ResponseDTO("fetch employee record successfully",empModelList);
        ResponseEntity<ResponseDTO> response = new ResponseEntity<>(responseDTO, HttpStatus.OK);
        return response;
    }
    //get data by id
    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDTO> fetchEmpDataResponseById(@PathVariable int id){
        EmployeePayrollDataModel employeeModel = empService.getEmpData(id);
        ResponseDTO responseDTO = new ResponseDTO("fetch employee record by id",employeeModel);
        ResponseEntity<ResponseDTO> response = new ResponseEntity<>(responseDTO, HttpStatus.OK);
        return response;
    }

    @GetMapping("/department/{department}")
    public ResponseEntity<ResponseDTO> fetchEmpDepartmentData(@PathVariable("department") String department){
        List<EmployeePayrollDataModel> employeeModellist = empService.findEmployeesByDepartment(department);
        ResponseDTO responseDTO = new ResponseDTO("fetch employee record by department",employeeModellist);
        ResponseEntity<ResponseDTO> response = new ResponseEntity<>(responseDTO, HttpStatus.OK);
        return response;
    }
    //using @Valid annotation for apply validation
    //create Employee Payroll data
@PostMapping("/save")
public ResponseEntity<ResponseDTO> insertEmpDataUseResponse(@Valid @RequestBody EmpPayrollDTO empDto){
    EmployeePayrollDataModel employeeModel = empService.addEmpData(empDto);
    ResponseDTO responseDTO = new ResponseDTO("New employee added",employeeModel);
    ResponseEntity<ResponseDTO> response = new ResponseEntity<>(responseDTO, HttpStatus.OK);
    return response;
}

    //update the exist employee data
    //using ResponseEntity
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateEmpDataUseResponse(@Valid @RequestBody EmpPayrollDTO empDto,@PathVariable int id){
        EmployeePayrollDataModel employeeModel = empService.updateEmpData(empDto,id);
        ResponseDTO responseDTO = new ResponseDTO("existing employee data updated successfully",employeeModel);
        ResponseEntity<ResponseDTO> response = new ResponseEntity<>(responseDTO, HttpStatus.OK);
        return response;
    }
    //delete the data using Response Entity

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollDataUseResponse(@PathVariable int empId){
        EmployeePayrollDataModel employeeModel = empService.deleteEmpData(empId);
        ResponseDTO responseDTO = new ResponseDTO("Deleted succesfully",employeeModel);
        ResponseEntity<ResponseDTO> response = new ResponseEntity<>(responseDTO, HttpStatus.OK);
        return response;

    }

}
