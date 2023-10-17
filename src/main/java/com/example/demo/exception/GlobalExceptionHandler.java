package com.example.demo.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,Object>> handleValidationErrors(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult().getFieldErrors()
                .stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());

        int statusCode = ex.getStatusCode().value();

        return new ResponseEntity<Map<String,Object>>(getErrorsMap(errors,statusCode), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    private Map<String, Object> getErrorsMap(List<String> errors, int statusCode) {
        Map<String, Object> errorResponse = new HashMap<>();
        String error = errors.toString().replace("[","").replace("]","");


        errorResponse.put("exception", error);
        errorResponse.put("statusCode",statusCode);
        errorResponse.put("responseMessage","Please enter valid Input");

        return errorResponse;
    }

}
