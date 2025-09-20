package com.example.unoproject.exception;

import com.example.unoproject.enums.RestEnum;
import com.example.unoproject.factory.RestResponseFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AppException.class)
    public ResponseEntity<?> handleAppException(AppException ex) {
        return RestResponseFactory.error(RestEnum.INTERNAL_ERROR, ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception ex) {
        return RestResponseFactory.error(RestEnum.INTERNAL_ERROR, ex.getMessage());
    }
}
