package com.payroll.employeepayrollsystemapp.service;

import com.payroll.employeepayrollsystemapp.dto.EmpPayrollDTO;
import com.payroll.employeepayrollsystemapp.model.EmployeePayrollDataModel;

import java.util.List;

public interface IEmployeeService {
    public String welcomeMsg();
    public EmployeePayrollDataModel addEmpData(EmpPayrollDTO empDto);
    public EmployeePayrollDataModel getEmpData(int id);
    public List<EmployeePayrollDataModel> findEmployeesByDepartment(String departments);
    public List<EmployeePayrollDataModel> getAllEmpData();
    public EmployeePayrollDataModel updateEmpData(EmpPayrollDTO empDto, int id);
    public EmployeePayrollDataModel deleteEmpData(int id);

}
