package com.junior.sistemacadastrousuariospringboot.controllers.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import com.junior.sistemacadastrousuariospringboot.services.exceptions.EmailExistsException;
import com.junior.sistemacadastrousuariospringboot.services.exceptions.ResourceNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(EmailExistsException.class)
    public ResponseEntity<StandardError> emailExistsException(EmailExistsException e, HttpServletRequest request) {
        String error = "Existing resource";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFoundException(ResourceNotFoundException e, HttpServletRequest request) {
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

}
