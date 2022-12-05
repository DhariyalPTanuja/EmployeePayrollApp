package com.payroll.employeepayrollsystemapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

 // using Lombok in Response DTO
//Use Lombok Library to auto generate getters and setters for the DTO
@AllArgsConstructor
public class ResponseDTO {

    String message;
    Object data;

//    public ResponseDTO(String message, Object data) {
//        this.message = message;
//        this.data = data;
//    }
}
