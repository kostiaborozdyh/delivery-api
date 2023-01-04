package com.delivery.api.server.controllers;

import com.delivery.auth.config.dto.ErrorMessageDTO;
import com.delivery.auth.config.exception.BadRequestException;
import com.delivery.auth.config.exception.FailedAuthenticationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value = BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessageDTO handleBadRequestException(BadRequestException ex, HttpServletRequest request) {
        return new ErrorMessageDTO(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                request.getServletPath());
    }

    @ExceptionHandler(value = FailedAuthenticationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorMessageDTO handleAuthenticationException(FailedAuthenticationException ex, HttpServletRequest request) {
        return new ErrorMessageDTO(
                HttpStatus.UNAUTHORIZED.value(),
                ex.getMessage(),
                request.getServletPath());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessageDTO handleValidationException(MethodArgumentNotValidException ex, HttpServletRequest request) {
        return new ErrorMessageDTO(
                HttpStatus.BAD_REQUEST.value(),
                "Not correct " + ex.getBindingResult().getFieldError().getField(),
                request.getServletPath());
    }
}