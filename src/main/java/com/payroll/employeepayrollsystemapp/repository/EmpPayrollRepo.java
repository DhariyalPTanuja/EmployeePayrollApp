package com.payroll.employeepayrollsystemapp.repository;

import com.payroll.employeepayrollsystemapp.model.EmployeePayrollDataModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface EmpPayrollRepo extends JpaRepository<EmployeePayrollDataModel, Integer> {
    @Query(value = "select * from employee_payroll_table,employee_department where employee_id = id and department = department" ,nativeQuery = true)
    List<EmployeePayrollDataModel> findEmployeesByDepartment(String departments);

}
