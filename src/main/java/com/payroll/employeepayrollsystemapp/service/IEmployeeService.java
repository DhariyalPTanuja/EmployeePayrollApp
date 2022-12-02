package com.payroll.employeepayrollsystemapp.service;

import com.payroll.employeepayrollsystemapp.dto.EmpPayrollDTO;
import com.payroll.employeepayrollsystemapp.model.EmployeePayrollDataModel;

import java.util.List;

public interface IEmployeeService {
    public String welcomeMsg();
    public EmployeePayrollDataModel addEmpData(EmployeePayrollDataModel emp);

    public EmployeePayrollDataModel updateEmpData(EmployeePayrollDataModel empObj, int id);
    public void deleteEmpData(int id);
    public EmployeePayrollDataModel addEmpDataDto(EmpPayrollDTO empDto);
    public EmployeePayrollDataModel getEmpData(int id);
    public List<EmployeePayrollDataModel> getAllEmpData();
    public EmployeePayrollDataModel updateEmpDataDto(EmpPayrollDTO empDto, int id);
}
