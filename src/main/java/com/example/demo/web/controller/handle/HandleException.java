package com.example.demo.web.controller.handle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

@Slf4j
@RestControllerAdvice
public class HandleException {

    @ExceptionHandler(value = {BindException.class})
    public ResponseEntity<?> handleException(BindException e, WebRequest request) {

        List<FieldError> fieldErrors = e.getFieldErrors();

        log.debug("Application path: " + request.getContextPath());
        log.debug("Expection message: " + e.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(fieldErrors);
    }

}
