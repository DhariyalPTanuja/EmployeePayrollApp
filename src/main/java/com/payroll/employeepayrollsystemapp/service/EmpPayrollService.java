package com.payroll.employeepayrollsystemapp.service;

import com.payroll.employeepayrollsystemapp.dto.EmpPayrollDTO;
import com.payroll.employeepayrollsystemapp.exceptions.EmployeePayrollException;
import com.payroll.employeepayrollsystemapp.exceptions.EmployeePayrollExceptionHandler;
import com.payroll.employeepayrollsystemapp.model.EmployeePayrollDataModel;
import com.payroll.employeepayrollsystemapp.repository.EmpPayrollRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class EmpPayrollService implements IEmployeeService {
   @Autowired  //dependency injection  autowired repository object
    EmpPayrollRepo empRepository;
   private List<EmployeePayrollDataModel> employeePayrollDataModelList = new ArrayList<>();
   public List<EmployeePayrollDataModel> getEmployeePayrollData() {
            return employeePayrollDataModelList;
   }

    public String welcomeMsg() {
        return "welcome  to EmployeePayroll App";
    }
    //to add the employee data
    public EmployeePayrollDataModel addEmpData(EmpPayrollDTO empDto){
       log.info("User using create Api to add data in database");
        EmployeePayrollDataModel empModel = new EmployeePayrollDataModel(empDto);
        return empRepository.save(empModel);
    }

    public EmployeePayrollDataModel getEmpData(int id) throws EmployeePayrollException{
       log.info("user retrieve all the data form database");
        EmployeePayrollDataModel empGetObj = empRepository.findById(id).get();
        return empGetObj;
    }
    public List<EmployeePayrollDataModel> getAllEmpData() {
        List<EmployeePayrollDataModel> empList = empRepository.findAll();
        return empList;
    }

public EmployeePayrollDataModel updateEmpData(EmpPayrollDTO empDto, int id) {
    Optional<EmployeePayrollDataModel> empUpdateObj = empRepository.findById(id);
    EmployeePayrollDataModel empObj = new EmployeePayrollDataModel(id,empDto);
   empRepository.save(empObj);
     return  empObj;

    }
    public EmployeePayrollDataModel deleteEmpData(int empId) throws EmployeePayrollException {
        EmployeePayrollDataModel empGetObj = empRepository.findById(empId).get();
        empRepository.deleteById(empId);
       return employeePayrollDataModelList.stream()
                .filter(empData -> empData.getEmpId() == empId)
                .findFirst()
                .orElseThrow(() -> new EmployeePayrollException("Employee Not found"));
    }


}
