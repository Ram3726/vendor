package com.FinalProject.vendor.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CarExceptionController {
    @ExceptionHandler(value = CarNotFoundException.class)
    public ResponseEntity<Object> exception(CarNotFoundException CarNotFoundException){
        return new ResponseEntity<>("Car Not found !!!", HttpStatus.NOT_FOUND);
    }
}
