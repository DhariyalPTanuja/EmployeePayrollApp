package com.payroll.employeepayrollsystemapp.controller;

import com.payroll.employeepayrollsystemapp.model.EmployeePayrollDataModel;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/epayrollapi")
public class EmployeePayrollController {

    @RequestMapping(value = {"", "/", "/home"})
    public String welcomeMsg() {
        return "welcome  to EmployeePayroll App";
    }

}
