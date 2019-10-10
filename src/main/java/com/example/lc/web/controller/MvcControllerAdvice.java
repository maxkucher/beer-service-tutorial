package com.example.lc.web.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;

@ControllerAdvice
public class MvcControllerAdvice {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Set> handleException(ConstraintViolationException ex){
     return ResponseEntity.badRequest().body(ex.getConstraintViolations());
    }
}
