package com.payroll.employeepayrollsystemapp.exceptions;

import com.payroll.employeepayrollsystemapp.dto.EmpPayrollDTO;

public class EmployeePayrollException  extends RuntimeException {
    public EmployeePayrollException(String message) {
        super(message);
    }

}
