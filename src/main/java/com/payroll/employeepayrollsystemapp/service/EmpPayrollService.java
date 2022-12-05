package com.payroll.employeepayrollsystemapp.service;

import com.payroll.employeepayrollsystemapp.dto.EmpPayrollDTO;
import com.payroll.employeepayrollsystemapp.exceptions.EmployeePayrollException;
import com.payroll.employeepayrollsystemapp.model.EmployeePayrollDataModel;
import com.payroll.employeepayrollsystemapp.repository.EmpPayrollRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class EmpPayrollService implements IEmployeeService {
   @Autowired  //dependency injection  autowired repository object
    EmpPayrollRepo empRepository;
   private List<EmployeePayrollDataModel> employeePayrollDataModelList = new ArrayList<>();
   public List<EmployeePayrollDataModel> getEmployeePayrollData() {
            return employeePayrollDataModelList;
   }
   //Exception throw
    public EmployeePayrollDataModel getEmpData(int empId){
//        EmployeePayrollDataModel empGetObj = empRepository.findById(id).get();
        return employeePayrollDataModelList.stream()
                .filter(empData -> empData.getEmpId() == empId)
                .findFirst()
                .orElseThrow(() -> new EmployeePayrollException("Employee Not found"));
    }
    public String welcomeMsg() {
        return "welcome  to EmployeePayroll App";
    }
    //to add the employee data
    public EmployeePayrollDataModel addEmpDataDto(EmpPayrollDTO empDto){
        // EmployeePayrollDataModel empModel = null;
        EmployeePayrollDataModel empModel = new EmployeePayrollDataModel(empDto);
        return empRepository.save(empModel);
    }

//    public EmployeePayrollDataModel getEmpData(int id){
//        EmployeePayrollDataModel empGetObj = empRepository.findById(id).get();
//        return empGetObj;
//    }
    public List<EmployeePayrollDataModel> getAllEmpData(){
        List<EmployeePayrollDataModel> empList = empRepository.findAll();
        return empList;
    }

    public EmployeePayrollDataModel updateEmpDataDto(EmpPayrollDTO empDto, int id){
        EmployeePayrollDataModel empObj = new EmployeePayrollDataModel(empDto);
        Optional<EmployeePayrollDataModel> empUpdateObj = empRepository.findById(id);
        empUpdateObj.get().setName(empObj.getName());
        empUpdateObj.get().setSalary(empObj.getSalary());
        empUpdateObj.get().setGender(empObj.getGender());
        empUpdateObj.get().setStartDate(empObj.getStartDate());
        empUpdateObj.get().setNote(empObj.getNote());
        empUpdateObj.get().setProfilePic(empObj.getProfilePic());
        empUpdateObj.get().setDepartments(empObj.getDepartments());
        empRepository.save(empUpdateObj.get());
        return empUpdateObj.get();

    }
    public void deleteEmpData(int id){
        empRepository.deleteById(id);
    }

}
