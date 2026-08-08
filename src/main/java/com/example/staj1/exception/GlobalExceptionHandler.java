package com.example.staj1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice //hata olduğunda JSON döndürecek.
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>>handleValidationException(
            MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult()
                .getFieldErrors()
                .forEach(error -> {

                    errors.put(
                            error.getField(),
                            error.getDefaultMessage()
                    );

                });

        return ResponseEntity.badRequest().body(errors);
    }
    public static class CustomerHasAddressException extends RuntimeException {
        public CustomerHasAddressException(String message) {
            super(message);
        }
    }

    @ExceptionHandler(CustomerHasAddressException.class)
    public ResponseEntity<String> handleCustomerHasAddress(CustomerHasAddressException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

}

