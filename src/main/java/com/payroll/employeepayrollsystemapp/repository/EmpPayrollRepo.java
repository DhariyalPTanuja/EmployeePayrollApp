package com.payroll.employeepayrollsystemapp.repository;

import com.payroll.employeepayrollsystemapp.model.EmployeePayrollDataModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface EmpPayrollRepo extends JpaRepository<EmployeePayrollDataModel, Integer> {


}
