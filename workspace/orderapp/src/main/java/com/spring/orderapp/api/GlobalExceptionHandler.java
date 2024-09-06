package com.spring.orderapp.api;

import com.spring.orderapp.service.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.*;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {
    // method gets called whenever @Controller or @RestController throws EntityNotFoundException
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex) {
        Map<String,Object> exceptionMap = new HashMap<>();
        exceptionMap.put("timestamp", new Date());
        exceptionMap.put("errorMessage", ex.getMessage());
        // use ResponseEntity to pass extra headers along with data
        return new ResponseEntity<Object>(exceptionMap, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String,Object> exceptionMap = new HashMap<>();
            exceptionMap.put("timestamp", new Date());
            List<String> errors = ex.getBindingResult().getFieldErrors()
                    .stream().map(exception -> exception.getDefaultMessage()).collect(Collectors.toList());
        exceptionMap.put("errors", errors);
        return new ResponseEntity<Object>(exceptionMap, HttpStatus.BAD_REQUEST);
    }
}
