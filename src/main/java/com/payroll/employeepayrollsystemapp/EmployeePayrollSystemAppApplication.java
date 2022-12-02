package com.payroll.employeepayrollsystemapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.naming.CannotProceedException;

@SpringBootApplication
@Slf4j
public class EmployeePayrollSystemAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeePayrollSystemAppApplication.class, args);
        log.info("Employee Payroll App started");
//        log.info("Employee Payroll App started in {} Environment",
//                context.getEnvironment().getProperty("environment"));
    }

}
