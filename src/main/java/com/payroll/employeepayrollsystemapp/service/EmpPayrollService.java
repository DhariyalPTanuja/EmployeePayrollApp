package com.payroll.employeepayrollsystemapp.service;

import com.payroll.employeepayrollsystemapp.model.EmployeePayrollDataModel;
import com.payroll.employeepayrollsystemapp.repository.EmpPayrollRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.support.ReflectivePropertyAccessor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpPayrollService  {

   @Autowired    //dependency injection  autowired repository object
    EmpPayrollRepo empRepository;
    public String welcomeMsg() {
        return "welcome  to EmployeePayroll App";
    }

    public EmployeePayrollDataModel addEmpData(EmployeePayrollDataModel emp){
        return empRepository.save(emp);
    }
    public EmployeePayrollDataModel getEmpData(int id){
       EmployeePayrollDataModel empGetObj = empRepository.findById(id).get();
        return empGetObj;
    }
    public List<EmployeePayrollDataModel> getAllEmpData(){
        List<EmployeePayrollDataModel> empList = empRepository.findAll();
        return empList;
    }

    public EmployeePayrollDataModel updateEmpData(EmployeePayrollDataModel empObj, int id){
        Optional<EmployeePayrollDataModel> empUpdateObj = empRepository.findById(id);
        empUpdateObj.get().setName(empObj.getName());
        empUpdateObj.get().setSalary(empObj.getSalary());
        empUpdateObj.get().setGender(empObj.getGender());
        empUpdateObj.get().setStartDate(empObj.getStartDate());
        empUpdateObj.get().setNote(empObj.getNote());
        empUpdateObj.get().setProfilePic(empObj.getProfilePic());
        empRepository.save(empUpdateObj.get());
        return empUpdateObj.get();

    }

    public void deleteEmpData(int id){
        empRepository.deleteById(id);;
    }
    
}
