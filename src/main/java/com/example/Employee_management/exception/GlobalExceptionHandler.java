package com.example.Employee_management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
    public class GlobalExceptionHandler {

        @ExceptionHandler(EmployeeNotFoundException.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
        public String handleEmployeeNotFound(EmployeeNotFoundException ex) {
            return ex.getMessage();
        }

        @ExceptionHandler(MethodArgumentNotValidException.class)
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        public Map<String,String> handleValidationException(MethodArgumentNotValidException ex) {

            Map<String, String> errors = new HashMap<>();

            ex.getBindingResult().getFieldErrors().forEach(error ->
                    errors.put(error.getField(), error.getDefaultMessage())
            );
                    return errors;
        }
    }


