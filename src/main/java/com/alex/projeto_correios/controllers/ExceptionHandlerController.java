package com.alex.projeto_correios.controllers;

import com.alex.projeto_correios.exceptions.AccessDeniedException;
import com.alex.projeto_correios.exceptions.ArgumentNotAcceptedException;
import com.alex.projeto_correios.exceptions.ObjectNotFoundException;
import com.alex.projeto_correios.exceptions.StandardError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
        StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<StandardError> accessDenied(AccessDeniedException e, HttpServletRequest request){
        StandardError err = new StandardError(HttpStatus.UNAUTHORIZED.value(), e.getMessage(), System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(err);
    }

    @ExceptionHandler(ArgumentNotAcceptedException.class)
    public ResponseEntity<StandardError> argumentNotAccepted(ArgumentNotAcceptedException e, HttpServletRequest request){
        StandardError err = new StandardError(HttpStatus.NOT_ACCEPTABLE.value(), e.getMessage(), System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(err);
    }

}