package com.payroll.employeepayrollsystemapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class EmployeePayrollSystemAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeePayrollSystemAppApplication.class, args);

        log.info("Employee payroll start .. using annotation Slf4j");
    }
}
