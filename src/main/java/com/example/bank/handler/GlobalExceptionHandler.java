package com.example.bank.handler;

import com.example.bank.exception.Error;
import com.example.bank.exception.BankException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public com.example.bank.exception.Error methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        return processFieldErrors(fieldErrors);
    }

    @ExceptionHandler(BankException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public com.example.bank.exception.Error processValidationError(BankException ex) {
        com.example.bank.exception.Error error = new Error(NOT_FOUND.value(),ex.getMessage());
        return error;
    }

    private com.example.bank.exception.Error processFieldErrors(List<FieldError> fieldErrors) {
        com.example.bank.exception.Error error = new com.example.bank.exception.Error(BAD_REQUEST.value(), "validation error");
        for (FieldError fieldError : fieldErrors) {
            error.addFieldError(fieldError.getObjectName(),fieldError.getField(), fieldError.getDefaultMessage());
        }
        return error;
    }
}
