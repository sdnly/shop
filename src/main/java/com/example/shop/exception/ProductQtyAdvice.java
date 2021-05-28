package com.example.shop.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ProductQtyAdvice {


    @ResponseBody
    @ExceptionHandler(ProductQtyException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String ProductQtyHandler(ProductQtyException ex) {
        return ex.getMessage();
    }
}
